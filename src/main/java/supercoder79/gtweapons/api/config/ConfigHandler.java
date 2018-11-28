package supercoder79.gtweapons.api.config;

import gregapi.data.CS;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static boolean PVPEnabled = false;
    public static boolean DungeonLoot = true;
    public static boolean PlaySound = true;
    public static boolean BreakGlass = true;
    public static void loadConfig(){
        Configuration mainConfig = new Configuration(new File(CS.DirectoriesGT.CONFIG_GT, "gtww.cfg"));
        PVPEnabled = mainConfig.get("general", "PVPEnabled", false, "Set this to true if you like killing your friends").getBoolean();
        DungeonLoot = mainConfig.get("general", "DungeonLoot", true, "Set this to false to disable spawning ammo in dungeon and temple chests").getBoolean();
        PlaySound = mainConfig.get("general", "PlaySound", true, "Set this to false if you want to disable guns emitting sounds.").getBoolean();
        BreakGlass = mainConfig.get("general", "BreakGlass", true, "Set this to false if you prefer your windows intact.").getBoolean();
        mainConfig.save();

    }
}
