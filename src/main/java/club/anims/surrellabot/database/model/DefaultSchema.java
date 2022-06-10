/*
 * This file is generated by jOOQ.
 */
package club.anims.surrellabot.database.model;


import club.anims.surrellabot.database.model.tables.Guilds;
import club.anims.surrellabot.database.model.tables.Settings;
import club.anims.surrellabot.database.model.tables.SqliteSequence;
import club.anims.surrellabot.database.model.tables.Users;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>guilds</code>.
     */
    public final Guilds GUILDS = Guilds.GUILDS;

    /**
     * The table <code>settings</code>.
     */
    public final Settings SETTINGS = Settings.SETTINGS;

    /**
     * The table <code>sqlite_sequence</code>.
     */
    public final SqliteSequence SQLITE_SEQUENCE = SqliteSequence.SQLITE_SEQUENCE;

    /**
     * The table <code>users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Guilds.GUILDS,
            Settings.SETTINGS,
            SqliteSequence.SQLITE_SEQUENCE,
            Users.USERS
        );
    }
}