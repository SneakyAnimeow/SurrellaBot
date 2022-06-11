package club.anims.surrellabot.listeners;

import club.anims.surrellabot.SurrellaEmbed;
import club.anims.surrellabot.commandsmanagement.CommandContext;
import club.anims.surrellabot.commandsmanagement.CommandPermission;
import club.anims.surrellabot.commandsmanagement.ExecutableCommand;
import club.anims.surrellabot.commandsmanagement.SurrellaCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static club.anims.surrellabot.SurrellaBotLauncher.proxy;

public class MessageListenerAdapter extends ListenerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageListenerAdapter.class);

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        var guild = event.getGuild();

        // Check if the guild is registered in the database
        var guildRecord = proxy.getGuildsQueries().getGuild(guild.getId());
        if (guildRecord == null) {
            proxy.getGuildsQueries().addGuild(guild.getName(), guild.getId(), "!", "", guild.getOwnerId(),false, guild.getSelfMember().getTimeJoined().toLocalDateTime());
            guildRecord = proxy.getGuildsQueries().getGuild(guild.getId());
        }

        // Fetch all necessary data
        var prefix = guildRecord.getPrefix();
        var message = event.getMessage();

        // Check if the message starts with the prefix
        if (!message.getContentRaw().startsWith(prefix)) return;

        // Continue fetching data
        var channel = event.getChannel();
        var author = event.getAuthor();
        var mentionedMembers = event.getMessage().getMentions().getMembers();
        var mentionedChannels = event.getMessage().getMentions().getChannels();
        var allMentions = event.getMessage().getMentions();
        var args = message.getContentRaw().split(" ");
        var cmd = args[0].replaceFirst(prefix, "");
        var isDisabled = guildRecord.getIsDisabled();

        // Find the right command executor
        new Reflections("club.anims.surrellabot.commandsmanagement").getSubTypesOf(ExecutableCommand.class).forEach(command -> {
            var annotation = command.getAnnotation(SurrellaCommand.class);
            if (annotation.name().equals(cmd) || Arrays.asList(annotation.aliases()).contains(cmd)) {
                var user = proxy.getUsersQueries().getUser(author.getId(), guild.getId());
                if (user == null) {
                    proxy.getUsersQueries().setUser(0, author.getName(), author.getId(), guild.getId(), false, false, false, "");
                    user = proxy.getUsersQueries().getUser(author.getId(), guild.getId());
                }

                if(annotation.permission().equals(CommandPermission.ADMIN) && !(user.getHasAdminPrivileges() || author.getId().equals(guild.getOwnerId()))) {
                    message.replyEmbeds(new SurrellaEmbed().setTitle("Insufficient Permissions").setDescription("You do not have the required privileges to execute this command.").build()).queue();
                    return;
                }

                if(annotation.permission().equals(CommandPermission.MOD) && !(user.getHasModPrivileges() || user.getHasAdminPrivileges() || author.getId().equals(guild.getOwnerId())) ){
                    message.replyEmbeds(new SurrellaEmbed().setTitle("Insufficient Permissions").setDescription("You do not have the required privileges to execute this command.").build()).queue();
                    return;
                }

                if(isDisabled && !(user.getHasAdminPrivileges() || author.getId().equals(guild.getOwnerId()))) {
                    message.replyEmbeds(new SurrellaEmbed().setTitle("Bot disabled").setDescription("Bot was disabled on this guild. Please contact guild bot administrator or the server owner.").build()).queue();
                    return;
                }

                try {
                    command.getConstructor(CommandContext.class).newInstance(new CommandContext(
                            cmd,
                            Arrays.asList(args).subList(1, args.length),
                            author,
                            channel,
                            mentionedMembers,
                            mentionedChannels,
                            allMentions,
                            message,
                            guild
                    )).execute();
                }catch (Exception ignored) {}
            }
        });
    }
}