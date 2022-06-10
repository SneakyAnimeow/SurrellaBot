package club.anims.surrellabot.database.queries;

import club.anims.surrellabot.database.model.tables.Settings;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SettingsQueries{
    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsQueries.class);

    private DSLContext context;

    public SettingsQueries(DSLContext context){
        this.context = context;
    }

    public void addSetting(String name, String value){
        context.insertInto(Settings.SETTINGS, Settings.SETTINGS.NAME, Settings.SETTINGS.VALUE)
                .values(name, value)
                .execute();
    }

    public String getSetting(String name){
        return context.select(Settings.SETTINGS.VALUE)
                .from(Settings.SETTINGS)
                .where(Settings.SETTINGS.NAME.eq(name))
                .fetchOne()
                .getValue(Settings.SETTINGS.VALUE);
    }

    public void updateSetting(String name, String value){
        context.update(Settings.SETTINGS)
                .set(Settings.SETTINGS.VALUE, value)
                .where(Settings.SETTINGS.NAME.eq(name))
                .execute();
    }

    public void deleteSetting(String name){
        context.deleteFrom(Settings.SETTINGS)
                .where(Settings.SETTINGS.NAME.eq(name))
                .execute();
    }

    public void setSetting(String name, String value){
        context.insertInto(Settings.SETTINGS, Settings.SETTINGS.NAME, Settings.SETTINGS.VALUE)
                .values(name, value)
                .onDuplicateKeyUpdate()
                .set(Settings.SETTINGS.VALUE, value)
                .execute();
    }

    public boolean settingExists(String name){
        return context.select(Settings.SETTINGS.ID)
                .from(Settings.SETTINGS)
                .where(Settings.SETTINGS.NAME.eq(name))
                .fetchOne() != null;
    }
}