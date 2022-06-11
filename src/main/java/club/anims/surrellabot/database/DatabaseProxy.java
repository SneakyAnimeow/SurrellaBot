package club.anims.surrellabot.database;

import club.anims.surrellabot.database.queries.GuildsQueries;
import club.anims.surrellabot.database.queries.SettingsQueries;
import club.anims.surrellabot.database.queries.UsersQueries;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jooq.impl.SQLDataType;

import static org.jooq.impl.DSL.primaryKey;
import static org.jooq.impl.DSL.unique;

public class DatabaseProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseProxy.class);

    private HikariDataSource getDataSource() {
        return new HikariDataSource(new HikariConfig("/hikari.properties"));
    }

    private DSLContext getContext() {
        return DSL.using(getDataSource(), SQLDialect.SQLITE);
    }

    public SettingsQueries getSettingsQueries(){
        return new SettingsQueries(getContext());
    }

    public GuildsQueries getGuildsQueries(){
        return new GuildsQueries(getContext());
    }

    public UsersQueries getUsersQueries(){
        return new UsersQueries(getContext());
    }

    public void createTables(){
        var context = getContext();
        context.createTableIfNotExists("settings")
                .column("id", SQLDataType.INTEGER.identity(true))
                .column("name", SQLDataType.VARCHAR(255).notNull())
                .column("value", SQLDataType.NVARCHAR(2048))
                .constraints(
                        primaryKey("id"),
                        unique("name")
                )
                .execute();

        context.createTableIfNotExists("users")
                .column("id", SQLDataType.INTEGER.identity(true))
                .column("name", SQLDataType.NVARCHAR(32).notNull())
                .column("discord_id", SQLDataType.VARCHAR(64).notNull())
                .column("guild_id", SQLDataType.VARCHAR(64).notNull())
                .column("has_admin_privileges", SQLDataType.BOOLEAN.notNull())
                .column("has_mod_privileges", SQLDataType.BOOLEAN.notNull())
                .column("is_blacklisted", SQLDataType.BOOLEAN.notNull())
                .column("jail_channel_id", SQLDataType.VARCHAR(64).notNull())
                .constraints(
                        primaryKey("id")
                )
                .execute();

        context.createTableIfNotExists("guilds")
                .column("id", SQLDataType.INTEGER.identity(true))
                .column("name", SQLDataType.NVARCHAR(64).notNull())
                .column("guild_id", SQLDataType.VARCHAR(64).notNull())
                .column("prefix", SQLDataType.VARCHAR(32).notNull())
                .column("log_channel_id", SQLDataType.VARCHAR(64).notNull())
                .column("server_owner_discord_id", SQLDataType.VARCHAR(64).notNull())
                .column("is_disabled", SQLDataType.BOOLEAN.notNull())
                .column("date_joined", SQLDataType.TIMESTAMP.notNull())
                .constraints(
                        primaryKey("id"),
                        unique("guild_id")
                )
                .execute();
    }
}
