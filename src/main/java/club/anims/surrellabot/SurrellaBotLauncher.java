package club.anims.surrellabot;

import club.anims.surrellabot.database.DatabaseProxy;

public class SurrellaBotLauncher {
    public static void main(String[] args){
        var proxy = new DatabaseProxy();
        proxy.createTables();
        SurrellaBot.start("");
    }
}
