package club.anims.surrellabot;

import club.anims.surrellabot.database.DatabaseProxy;

import java.util.Scanner;

public class SurrellaBotLauncher {
    public static void main(String[] args){
        var proxy = new DatabaseProxy();
        proxy.createTables();

        if(!proxy.getSettingsQueries().settingExists("token")){
            var token = ask("Enter your bot token: ");
            proxy.getSettingsQueries().addSetting("token", token);
        }

        SurrellaBot.start(proxy.getSettingsQueries().getSetting("token"));
    }

    public static String ask(String question){
        System.out.println(question);
        return new Scanner(System.in).nextLine();
    }
}
