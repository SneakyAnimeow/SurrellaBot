package club.anims.surrellabot.commandsmanagement;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SurrellaCommand {
    String name();
    String description();
    String usage();
    String[] aliases();
    CommandPermission permission();
}
