package club.anims.surrellabot.commandsmanagement;

import lombok.*;
import net.dv8tion.jda.api.entities.*;

import java.util.List;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CommandContext {
    private String command;
    private List<String> args;
    private User author;
    private MessageChannel channel;
    private List<Member> mentionedMembers;
    private List<GuildChannel> mentionedChannels;
    private Mentions allMentions;
    private Message message;
    private Guild guild;
}