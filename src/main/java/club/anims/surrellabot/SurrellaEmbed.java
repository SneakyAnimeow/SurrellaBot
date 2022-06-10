package club.anims.surrellabot;

import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;

public class SurrellaEmbed extends EmbedBuilder {
    public SurrellaEmbed(){
        this.setColor(0x1214bd);
        this.setAuthor("Surrella", "http://surrella.anims.club/", "http://surrella.anims.club/surella2.png");
        this.setTitle("Response from Surrella");
        this.setFooter("", "http://surrella.anims.club/surella2.png");
        this.setTimestamp(Instant.now());
    }
}
