package club.anims.surrellabot;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class SurrellaBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(SurrellaBot.class);

    @Getter
    private static final String VERSION = "beta 1.0.1";

    @Getter
    private static SurrellaBot instance;

    private JDA jda;

    private SurrellaBot(String token) throws LoginException {
        jda = JDABuilder.createDefault(token).build();
    }

    public static void start(String token) {
        try{
            instance = new SurrellaBot(token);
        }catch (LoginException e){
            LOGGER.error("Failed to start SurrellaBot", e);
            System.exit(1);
        }
    }
}
