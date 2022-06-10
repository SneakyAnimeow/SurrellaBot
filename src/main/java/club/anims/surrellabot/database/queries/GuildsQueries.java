package club.anims.surrellabot.database.queries;

import club.anims.surrellabot.database.model.tables.Guilds;
import club.anims.surrellabot.database.model.tables.records.GuildsRecord;
import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class GuildsQueries {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuildsQueries.class);

    private DSLContext context;

    public GuildsQueries(DSLContext context){
        this.context = context;
    }

    public void addGuild(int id, String name, String guildId, String prefix, String logChannelId, String serverOwnerDiscordId, boolean isDisabled, LocalDateTime dateJoined){
        context.insertInto(Guilds.GUILDS, Guilds.GUILDS.ID, Guilds.GUILDS.NAME, Guilds.GUILDS.GUILD_ID, Guilds.GUILDS.PREFIX, Guilds.GUILDS.LOG_CHANNEL_ID, Guilds.GUILDS.SERVER_OWNER_DISCORD_ID, Guilds.GUILDS.IS_DISABLED, Guilds.GUILDS.DATE_JOINED)
                .values(id, name, guildId, prefix, logChannelId, serverOwnerDiscordId, isDisabled, dateJoined)
                .execute();
    }

    public void updateGuild(int id, String name, String guildId, String prefix, String logChannelId, String serverOwnerDiscordId, boolean isDisabled, LocalDateTime dateJoined){
        context.update(Guilds.GUILDS)
                .set(Guilds.GUILDS.NAME, name)
                .set(Guilds.GUILDS.GUILD_ID, guildId)
                .set(Guilds.GUILDS.PREFIX, prefix)
                .set(Guilds.GUILDS.LOG_CHANNEL_ID, logChannelId)
                .set(Guilds.GUILDS.SERVER_OWNER_DISCORD_ID, serverOwnerDiscordId)
                .set(Guilds.GUILDS.IS_DISABLED, isDisabled)
                .set(Guilds.GUILDS.DATE_JOINED, dateJoined)
                .where(Guilds.GUILDS.ID.eq(id))
                .execute();
    }

    public void deleteGuild(int id){
        context.deleteFrom(Guilds.GUILDS)
                .where(Guilds.GUILDS.ID.eq(id))
                .execute();
    }

    public void setGuild(int id, String name, String guildId, String prefix, String logChannelId, String serverOwnerDiscordId, boolean isDisabled, LocalDateTime dateJoined) {
        context.insertInto(Guilds.GUILDS, Guilds.GUILDS.ID, Guilds.GUILDS.NAME, Guilds.GUILDS.GUILD_ID, Guilds.GUILDS.PREFIX, Guilds.GUILDS.LOG_CHANNEL_ID, Guilds.GUILDS.SERVER_OWNER_DISCORD_ID, Guilds.GUILDS.IS_DISABLED, Guilds.GUILDS.DATE_JOINED)
                .values(id, name, guildId, prefix, logChannelId, serverOwnerDiscordId, isDisabled, dateJoined)
                .onConflict(Guilds.GUILDS.ID).doUpdate()
                .set(Guilds.GUILDS.NAME, name)
                .set(Guilds.GUILDS.GUILD_ID, guildId)
                .set(Guilds.GUILDS.PREFIX, prefix)
                .set(Guilds.GUILDS.LOG_CHANNEL_ID, logChannelId)
                .set(Guilds.GUILDS.SERVER_OWNER_DISCORD_ID, serverOwnerDiscordId)
                .set(Guilds.GUILDS.IS_DISABLED, isDisabled)
                .set(Guilds.GUILDS.DATE_JOINED, dateJoined)
                .execute();
    }

    public @Nullable GuildsRecord getGuild(int id){
        return context.selectFrom(Guilds.GUILDS)
                .where(Guilds.GUILDS.ID.eq(id))
                .fetchOne();
    }

    public @Nullable GuildsRecord getGuild(String guildId){
        return context.selectFrom(Guilds.GUILDS)
                .where(Guilds.GUILDS.GUILD_ID.eq(guildId))
                .fetchOne();
    }

    public @Nullable GuildsRecord[] getGuilds(String serverOwnerDiscordId){
        return context.selectFrom(Guilds.GUILDS)
                .where(Guilds.GUILDS.SERVER_OWNER_DISCORD_ID.eq(serverOwnerDiscordId))
                .fetchArray();
    }
}