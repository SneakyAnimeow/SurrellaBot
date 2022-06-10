package club.anims.surrellabot.commandsmanagement.commands;

import club.anims.surrellabot.commandsmanagement.CommandContext;
import club.anims.surrellabot.commandsmanagement.CommandPermission;
import club.anims.surrellabot.commandsmanagement.ExecutableCommand;
import club.anims.surrellabot.commandsmanagement.SurrellaCommand;
import org.slf4j.Logger;

@SurrellaCommand(name = "info", description = "Shows information about the bot", usage = "info", aliases = {"about"}, permission = CommandPermission.DEFAULT)
public class Info extends ExecutableCommand {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Info.class);

    public Info(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.getMessage().reply("Hello world!").queue();
    }
}
