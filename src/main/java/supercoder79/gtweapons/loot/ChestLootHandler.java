package supercoder79.gtweapons.loot;

import cpw.mods.fml.common.Mod;
import gregapi.data.CS;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregtech.loaders.c.Loader_Loot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.item.ModItems;

import java.util.HashMap;

import static gregtech.loaders.c.Loader_Loot.addLoot;

public class ChestLootHandler {
    public String lootType;
    public static HashMap<String, ChestLootHandler> dungeonMap = new HashMap();

    public ChestLootHandler(String type)
    {
        this.lootType = type;
        dungeonMap.put(type, this);
    }

    public ChestLootHandler addItem(ItemStack item)
    {
        return this.addItem(item, 1, 1, 1);
    }

    public ChestLootHandler addItem(ItemStack item, int chances)
    {
        return this.addItem(item, 1, 1, chances);
    }

    public ChestLootHandler addItem(ItemStack item, int max, int chances)
    {
        return this.addItem(item, 1, max, chances);
    }

    public ChestLootHandler addItem(ItemStack item, int min, int max, int chances)
    {
        ChestGenHooks.addItem(this.lootType, new WeightedRandomChestContent(item, min, max, chances));
        return this;
    }
    public static void init()
    {
        if (!(ConfigHandler.DungeonLoot)) return;
        System.out.println("Loading Loot");
        OreDictPrefix shotgunShell = OreDictPrefix.get("gtweaponsBulletSG");
        OreDictPrefix ammoLC = OreDictPrefix.get("gtweaponsMagazineLC");
        OreDictPrefix ammoMC = OreDictPrefix.get("gtweaponsMagazineMC");
        OreDictPrefix ammoHC = OreDictPrefix.get("gtweaponsMagazineHC");
        OreDictMaterial[] mats = new OreDictMaterial[]{MT.Steel, MT.Bronze, MT.BlackSteel, MT.BlackBronze, MT.Au, MT.Ag, MT.Pb, MT.DamascusSteel, MT.Cu, MT.Brass, MT.Pt, MT.Bi};
        OreDictMaterial[] matsNotInsane = new OreDictMaterial[] {MT.Steel, MT.Bronze, MT.Au};
//        OreDictMaterial[] mats = new OreDictMaterial[]{MT.Steel, MT.Bronze};
//        MultiItemTool gt = CS.ToolsGT.sMetaTool;
//        MultiItemTool qt = (MultiItemTool)QTI.qwerTool.getItem();

        ChestLootHandler mineshaft = new ChestLootHandler("mineshaftCorridor");
        ChestLootHandler jungleShooter = new ChestLootHandler("pyramidJungleDispenser");//.addItem(star.mat(MT.Steel, 1), 16, 2).addItem(star.mat(MT.Ag, 1), 16, 1).addItem(star.mat(MT.Pb, 1), 16, 1).addItem(star.mat(MT.Bronze, 1), 16, 2).addItem(star.mat(MT.Ti, 1), 16, 1);
        ChestLootHandler jungleChest = new ChestLootHandler("pyramidJungleChest");
        ChestLootHandler desertChest = new ChestLootHandler("pyramidDesertyChest");
        ChestLootHandler dungeonChest = new ChestLootHandler("dungeonChest");
        ChestLootHandler village = new ChestLootHandler("villageBlacksmith");//.addItem(star.mat(MT.Steel, 1), 16, 2).addItem(star.mat(MT.Fe, 1), 16, 2).addItem(star.mat(MT.Bronze, 1), 16, 1).addItem(star.mat(MT.DamascusSteel, 1), 16, 1).addItem(star.mat(MT.BlueSteel, 1), 16, 1).addItem(star.mat(MT.RedSteel, 1), 16, 1);
        ChestLootHandler library = new ChestLootHandler("strongholdLibrary");
        ChestLootHandler strong1 = new ChestLootHandler("strongholdCorridor");
        ChestLootHandler strong2 = new ChestLootHandler("strongholdCrossing");
        ChestLootHandler bonus = new ChestLootHandler("bonusChest");

        for (int q = 0; q < matsNotInsane.length; q++)
        {
            ChestLootHandler[] loot = new ChestLootHandler[]{village, strong1, strong2, mineshaft, jungleChest, desertChest, bonus};
            for (int s = 0; s < loot.length; s++) {
                loot[s].addItem(OP.bulletGtSmall.mat(matsNotInsane[q], 1), 8, 32, 3);
                loot[s].addItem(shotgunShell.mat(matsNotInsane[q], 1), 3, 6, 3);
                loot[s].addItem(OP.bulletGtMedium.mat(matsNotInsane[q], 1), 8, 24, 2);
                loot[s].addItem(OP.bulletGtLarge.mat(matsNotInsane[q], 1), 8, 16, 1);
                loot[s].addItem(ammoLC.mat(matsNotInsane[q], 1), 1, 4, 2);
                loot[s].addItem(ammoMC.mat(matsNotInsane[q], 1), 1, 3, 1);
                loot[s].addItem(ammoHC.mat(matsNotInsane[q], 1), 1, 2, 1);
                loot[s].addItem(new ItemStack(ModItems.container, 1, 0), 1, 2, 2);
                loot[s].addItem(new ItemStack(ModItems.container, 1, 1), 1, 3, 3);
            }

        }
        for (int q = 0; q < mats.length; q++) {
            dungeonChest.addItem(OP.bulletGtSmall.mat(mats[q], 1), 8, 32, 3);
            dungeonChest.addItem(shotgunShell.mat(mats[q], 1), 3, 6, 3);
            dungeonChest.addItem(OP.bulletGtMedium.mat(mats[q], 1), 8, 24, 2);
            dungeonChest.addItem(OP.bulletGtLarge.mat(mats[q], 1), 8, 16, 1);
            dungeonChest.addItem(ammoLC.mat(mats[q], 1), 1, 4, 2);
            dungeonChest.addItem(ammoMC.mat(mats[q], 1), 1, 3, 1);
            dungeonChest.addItem(ammoHC.mat(mats[q], 1), 1, 2, 1);
            dungeonChest.addItem(new ItemStack(ModItems.container, 1, 0), 1, 2, 2);
            dungeonChest.addItem(new ItemStack(ModItems.container, 1, 1), 1, 3, 3);
        }
        ChestLootHandler[] loot = new ChestLootHandler[]{dungeonChest, village, strong1, strong2, mineshaft, jungleChest, desertChest, bonus};
        for (int s = 0; s < loot.length; s++) {
            loot[s].addItem(new ItemStack(ModItems.gun, 1, 0), 1, 1, 3);
            loot[s].addItem(new ItemStack(ModItems.gun, 1, 3), 1, 1, 2);
        }
        dungeonChest.addItem(IL.Tool_Lighter_Invar_Full.get(1), 1, 1, 4);
        dungeonChest.addItem(IL.Tool_Lighter_Platinum_Full.get(1), 1, 1, 1);
        dungeonChest.addItem(IL.Tool_MatchBox_Full.get(1), 1, 4, 10);
        //too lazy to write my own code
        addLoot(ChestGenHooks.DUNGEON_CHEST             ,  10, 4, 8, IL.Bottle_Holy_Water.get(1));
        addLoot(ChestGenHooks.DUNGEON_CHEST             ,  30, 8,16, IL.Bottle_Purple_Drink.get(1));
        addLoot(ChestGenHooks.DUNGEON_CHEST             ,  5, 8,16, IL.Bottle_Glue.get(1));
        addLoot(ChestGenHooks.DUNGEON_CHEST             ,  10, 8,16, IL.Bottle_Lubricant.get(1));
        addLoot(ChestGenHooks.DUNGEON_CHEST             ,   2, 1, 4, IL.Pill_Cure_All.get(1));
        addLoot(ChestGenHooks.DUNGEON_CHEST             ,   3, 1, 1, IL.Porcelain_Cup.get(1));

    }

    public static ChestLootHandler get(String key)
    {
        if (dungeonMap.containsKey(key)) return dungeonMap.get(key);
        return new ChestLootHandler(key);
    }
}
