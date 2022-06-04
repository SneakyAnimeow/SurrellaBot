package club.anims.surrellabot.database;

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
    }
}
