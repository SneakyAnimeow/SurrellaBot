package club.anims.surrellabot.commandsmanagement;

public class ExecutableCommand {
    public final CommandContext context;

    public ExecutableCommand(CommandContext context) {
        this.context = context;
    }

    public void execute() {}
}
