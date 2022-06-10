package club.anims.surrellabot;

import club.anims.surrellabot.listeners.MainListenerAdapter;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class SurrellaBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(SurrellaBot.class);

    @Getter
    private static final String VERSION = "beta 1.0.0";

    @Getter
    private static SurrellaBot instance;

    private JDA jda;

    private SurrellaBot(String token) throws LoginException {
        jda = JDABuilder.createDefault(token)
                .enableCache(CacheFlag.MEMBER_OVERRIDES,
                        CacheFlag.VOICE_STATE,
                        CacheFlag.ROLE_TAGS,
                        CacheFlag.ACTIVITY,
                        CacheFlag.CLIENT_STATUS,
                        CacheFlag.EMOTE,
                        CacheFlag.ONLINE_STATUS)
                .enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                .addEventListeners(new MainListenerAdapter())
                .build();
    }

    public static void start(String token) {
        try{
            instance = new SurrellaBot(token);
        }catch (LoginException e){
            LOGGER.error("Failed to start Surrella Bot", e);
            System.exit(1);
        }
    }
}
