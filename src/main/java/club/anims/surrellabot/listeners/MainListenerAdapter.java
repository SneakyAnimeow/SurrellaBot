package club.anims.surrellabot.listeners;

import club.anims.surrellabot.commandsmanagement.CommandContext;
import club.anims.surrellabot.commandsmanagement.ExecutableCommand;
import club.anims.surrellabot.commandsmanagement.SurrellaCommand;
import club.anims.surrellabot.database.DatabaseProxy;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.util.Arrays;

public class MainListenerAdapter extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        var guild = event.getGuild();

        // Check if the guild is registered in the database
        var proxy = new DatabaseProxy();
        var guildRecord = proxy.getGuildsQueries().getGuild(guild.getId());
        if (guildRecord == null) {
            var guildName = guild.getName().replaceAll("[^a-zA-Z0-9]", "");
            proxy.getGuildsQueries().setGuild(0, guildName, guild.getId(), "!", "", guild.getOwnerId(),false, guild.getSelfMember().getTimeJoined().toLocalDateTime());
            guildRecord = proxy.getGuildsQueries().getGuild(guild.getId());
        }

        // Fetch all necessary data
        var prefix = guildRecord.getPrefix();
        var channel = event.getChannel();
        var author = event.getAuthor();
        var message = event.getMessage();
        var mentionedMembers = event.getMessage().getMentions().getMembers();
        var mentionedChannels = event.getMessage().getMentions().getChannels();
        var allMentions = event.getMessage().getMentions();
        var args = message.getContentRaw().split(" ");
        var cmd = args[0].replaceFirst(prefix, "");

        // Find the right command executor
        new Reflections("club.anims.surrellabot.commandsmanagement").getSubTypesOf(ExecutableCommand.class).forEach(command -> {
            if (command.getAnnotation(SurrellaCommand.class).name().equals(cmd)) {
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