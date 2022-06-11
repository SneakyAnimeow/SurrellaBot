package club.anims.surrellabot.commandsmanagement.commands;

import club.anims.surrellabot.SurrellaEmbed;
import club.anims.surrellabot.commandsmanagement.CommandContext;
import club.anims.surrellabot.commandsmanagement.CommandPermission;
import club.anims.surrellabot.commandsmanagement.ExecutableCommand;
import club.anims.surrellabot.commandsmanagement.SurrellaCommand;
import org.reflections.Reflections;

import java.util.Arrays;

@SurrellaCommand(name = "help", description = "Shows help for a command", usage = "help [command]", aliases = {"help", "h"}, permission = CommandPermission.DEFAULT)
public class Help extends ExecutableCommand {
    public Help(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        var output = new SurrellaEmbed().setTitle("Command not found");

        if(context.getArgs().size()<1){
            output.setTitle("Available commands");
            new Reflections("club.anims.surrellabot.commandsmanagement.commands").getSubTypesOf(ExecutableCommand.class).forEach(clazz -> {
                var command = clazz.getAnnotation(SurrellaCommand.class);
                output.addField(command.name(), String.format("`%s`\n%s", command.usage(), command.description()), false);
            });
        }else {
            new Reflections("club.anims.surrellabot.commandsmanagement.commands").getSubTypesOf(ExecutableCommand.class).stream().filter(clazz -> {
                var command = clazz.getAnnotation(SurrellaCommand.class);
                return command.name().equalsIgnoreCase(context.getArgs().get(0)) || Arrays.stream(command.aliases()).toList().contains(context.getArgs().get(0));
            }).forEach(clazz -> {
                var command = clazz.getAnnotation(SurrellaCommand.class);
                output.setTitle(command.name());
                output.addField("Usage", String.format("`%s`", command.usage()), false);
                output.addField("Description", command.description(), false);
                output.addField("Aliases", String.format("`%s`", String.join(", ", command.aliases())), false);
                output.addField("Permission", command.permission().toString(), false);
            });
        }
        context.getMessage().replyEmbeds(output.build()).queue();
    }
}