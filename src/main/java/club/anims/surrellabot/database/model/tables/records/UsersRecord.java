/*
 * This file is generated by jOOQ.
 */
package club.anims.surrellabot.database.model.tables.records;


import club.anims.surrellabot.database.model.tables.Users;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record8<Integer, String, String, String, Boolean, Boolean, Boolean, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>users.id</code>.
     */
    public UsersRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>users.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>users.name</code>.
     */
    public UsersRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>users.discord_id</code>.
     */
    public UsersRecord setDiscordId(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>users.discord_id</code>.
     */
    public String getDiscordId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>users.guild_id</code>.
     */
    public UsersRecord setGuildId(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>users.guild_id</code>.
     */
    public String getGuildId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>users.has_admin_privileges</code>.
     */
    public UsersRecord setHasAdminPrivileges(Boolean value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>users.has_admin_privileges</code>.
     */
    public Boolean getHasAdminPrivileges() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>users.has_mod_privileges</code>.
     */
    public UsersRecord setHasModPrivileges(Boolean value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>users.has_mod_privileges</code>.
     */
    public Boolean getHasModPrivileges() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>users.is_blacklisted</code>.
     */
    public UsersRecord setIsBlacklisted(Boolean value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>users.is_blacklisted</code>.
     */
    public Boolean getIsBlacklisted() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>users.jail_channel_id</code>.
     */
    public UsersRecord setJailChannelId(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>users.jail_channel_id</code>.
     */
    public String getJailChannelId() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, String, Boolean, Boolean, Boolean, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Integer, String, String, String, Boolean, Boolean, Boolean, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.DISCORD_ID;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.GUILD_ID;
    }

    @Override
    public Field<Boolean> field5() {
        return Users.USERS.HAS_ADMIN_PRIVILEGES;
    }

    @Override
    public Field<Boolean> field6() {
        return Users.USERS.HAS_MOD_PRIVILEGES;
    }

    @Override
    public Field<Boolean> field7() {
        return Users.USERS.IS_BLACKLISTED;
    }

    @Override
    public Field<String> field8() {
        return Users.USERS.JAIL_CHANNEL_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getDiscordId();
    }

    @Override
    public String component4() {
        return getGuildId();
    }

    @Override
    public Boolean component5() {
        return getHasAdminPrivileges();
    }

    @Override
    public Boolean component6() {
        return getHasModPrivileges();
    }

    @Override
    public Boolean component7() {
        return getIsBlacklisted();
    }

    @Override
    public String component8() {
        return getJailChannelId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getDiscordId();
    }

    @Override
    public String value4() {
        return getGuildId();
    }

    @Override
    public Boolean value5() {
        return getHasAdminPrivileges();
    }

    @Override
    public Boolean value6() {
        return getHasModPrivileges();
    }

    @Override
    public Boolean value7() {
        return getIsBlacklisted();
    }

    @Override
    public String value8() {
        return getJailChannelId();
    }

    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setDiscordId(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setGuildId(value);
        return this;
    }

    @Override
    public UsersRecord value5(Boolean value) {
        setHasAdminPrivileges(value);
        return this;
    }

    @Override
    public UsersRecord value6(Boolean value) {
        setHasModPrivileges(value);
        return this;
    }

    @Override
    public UsersRecord value7(Boolean value) {
        setIsBlacklisted(value);
        return this;
    }

    @Override
    public UsersRecord value8(String value) {
        setJailChannelId(value);
        return this;
    }

    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, Boolean value5, Boolean value6, Boolean value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer id, String name, String discordId, String guildId, Boolean hasAdminPrivileges, Boolean hasModPrivileges, Boolean isBlacklisted, String jailChannelId) {
        super(Users.USERS);

        setId(id);
        setName(name);
        setDiscordId(discordId);
        setGuildId(guildId);
        setHasAdminPrivileges(hasAdminPrivileges);
        setHasModPrivileges(hasModPrivileges);
        setIsBlacklisted(isBlacklisted);
        setJailChannelId(jailChannelId);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(club.anims.surrellabot.database.model.tables.pojos.Users value) {
        super(Users.USERS);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDiscordId(value.getDiscordId());
            setGuildId(value.getGuildId());
            setHasAdminPrivileges(value.getHasAdminPrivileges());
            setHasModPrivileges(value.getHasModPrivileges());
            setIsBlacklisted(value.getIsBlacklisted());
            setJailChannelId(value.getJailChannelId());
        }
    }
}
