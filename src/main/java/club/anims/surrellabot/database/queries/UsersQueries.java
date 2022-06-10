package club.anims.surrellabot.database.queries;

import club.anims.surrellabot.database.model.tables.Users;
import club.anims.surrellabot.database.model.tables.records.UsersRecord;
import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersQueries {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersQueries.class);
    private final DSLContext context;

    public UsersQueries(DSLContext context){
        this.context = context;
    }

    public void addUser(int id, String name, String discordId, String guildId, boolean hasAdminPrivileges, boolean hasModPrivileges, boolean isBlacklisted, String jailChannelId){
        context.insertInto(Users.USERS, Users.USERS.ID, Users.USERS.NAME, Users.USERS.DISCORD_ID, Users.USERS.GUILD_ID, Users.USERS.HAS_ADMIN_PRIVILEGES, Users.USERS.HAS_MOD_PRIVILEGES, Users.USERS.IS_BLACKLISTED, Users.USERS.JAIL_CHANNEL_ID)
                .values(id, name, discordId, guildId, hasAdminPrivileges, hasModPrivileges, isBlacklisted, jailChannelId)
                .execute();
    }

    public void updateUser(int id, String name, String discordId, String guildId, boolean hasAdminPrivileges, boolean hasModPrivileges, boolean isBlacklisted, String jailChannelId){
        context.update(Users.USERS)
                .set(Users.USERS.NAME, name)
                .set(Users.USERS.DISCORD_ID, discordId)
                .set(Users.USERS.GUILD_ID, guildId)
                .set(Users.USERS.HAS_ADMIN_PRIVILEGES, hasAdminPrivileges)
                .set(Users.USERS.HAS_MOD_PRIVILEGES, hasModPrivileges)
                .set(Users.USERS.IS_BLACKLISTED, isBlacklisted)
                .set(Users.USERS.JAIL_CHANNEL_ID, jailChannelId)
                .where(Users.USERS.ID.eq(id))
                .execute();
    }

    public void deleteUser(int id){
        context.deleteFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .execute();
    }

    public void setUser(int id, String name, String discordId, String guildId, boolean hasAdminPrivileges, boolean hasModPrivileges, boolean isBlacklisted, String jailChannelId) {
        context.insertInto(Users.USERS, Users.USERS.ID, Users.USERS.NAME, Users.USERS.DISCORD_ID, Users.USERS.GUILD_ID, Users.USERS.HAS_ADMIN_PRIVILEGES, Users.USERS.HAS_MOD_PRIVILEGES, Users.USERS.IS_BLACKLISTED, Users.USERS.JAIL_CHANNEL_ID)
                .values(id, name, discordId, guildId, hasAdminPrivileges, hasModPrivileges, isBlacklisted, jailChannelId)
                .onDuplicateKeyUpdate()
                .set(Users.USERS.NAME, name)
                .set(Users.USERS.DISCORD_ID, discordId)
                .set(Users.USERS.GUILD_ID, guildId)
                .set(Users.USERS.HAS_ADMIN_PRIVILEGES, hasAdminPrivileges)
                .set(Users.USERS.HAS_MOD_PRIVILEGES, hasModPrivileges)
                .set(Users.USERS.IS_BLACKLISTED, isBlacklisted)
                .set(Users.USERS.JAIL_CHANNEL_ID, jailChannelId)
                .execute();
    }

    public @Nullable UsersRecord getUser(int id){
        return context.selectFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .fetchOne();
    }

    public @Nullable UsersRecord getUser(String discordId, String guildId){
        return context.selectFrom(Users.USERS)
                .where(Users.USERS.DISCORD_ID.eq(discordId))
                .and(Users.USERS.GUILD_ID.eq(guildId))
                .fetchOne();
    }
}