package supercoder79.gtweapons;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import gregapi.block.MaterialMachines;
import gregapi.block.MaterialScoopable;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ICondition;
import gregapi.code.ModData;
import gregapi.data.*;
import gregapi.oredict.OreDictMaterial;
import gregapi.recipes.handlers.RecipeMapHandlerPrefix;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.CR;
import gregapi.util.UT;
import gregtech.tileentity.multiblocks.MultiTileEntityTank3x3x3Metal;
import gregtech.tileentity.multiblocks.MultiTileEntityTank5x5x5Metal;
import gregtech.tileentity.tanks.MultiTileEntityBarrelMetal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidStack;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.api.materials.GTWWMaterials;
import supercoder79.gtweapons.block.ModBlocks;
import supercoder79.gtweapons.entity.ModEntities;
import supercoder79.gtweapons.handlers.UIRenderHandler;
import supercoder79.gtweapons.item.GTMetaItem;
import supercoder79.gtweapons.item.ModItems;
import supercoder79.gtweapons.loot.ChestLootHandler;
import supercoder79.gtweapons.tile.ModTiles;

import static supercoder79.gtweapons.api.materials.GTWWMaterials.fluidCoalGas;
import static supercoder79.gtweapons.api.materials.GTWWMaterials.fluidLiqueficatedCoal;
import static supercoder79.gtweapons.api.materials.GTWWMaterials.fluidMolotovMixture;

/**
 * @author SuperCoder79
 *
 * Please don't decompile this. Wait, the decompiler removes all comments, shit
 *
 * WARNING: All bugs are features, All features are bugs.
 *
 * WARNING #2: This code is mostly copypasted, so therefore if there are problems, blame greg as always. (Just kidding, don't do that)
 *
 * WARNING #3: in order to prevent yourself from contracting any diseases while viewing this code, it's advised to keep bleach or tide pods handy at all times.
 */
@Mod(modid=GregTechWeaponWorks.MOD_ID, name=GregTechWeaponWorks.MOD_NAME, version=GregTechWeaponWorks.VERSION, dependencies="required-after:gregapi_post")
public final class GregTechWeaponWorks extends Abstract_Mod {
	@Mod.Instance
	public static GregTechWeaponWorks INSTANCE;
	public static final String MOD_ID = "gtweapons";
	public static final String MOD_NAME = "GregTech WeaponWorks";
	/** This is your Mods Log Name */
	public static final String MOD_LOG_NAME = "GTWW"; 
	/** This is your Mods Version */
	public static final String VERSION = "0.2.0";
	public static ModData MOD_DATA = new ModData(MOD_ID, MOD_NAME);

	@SidedProxy(modId = MOD_ID, clientSide = "supercoder79.gtweapons.proxy.ProxyClient", serverSide = "supercoder79.gtweapons.proxy.ProxyServer")
    public static Abstract_Proxy PROXY;




    @Override public String getModID() {return MOD_ID;}
	@Override public String getModName() {return MOD_NAME;}
	@Override public String getModNameForLog() {return MOD_LOG_NAME;}
	@Override public Abstract_Proxy getProxy() {return PROXY;}

	// Do not change these 7 Functions. Just keep them this way.
	@EventHandler public final void onPreLoad (FMLPreInitializationEvent aEvent) {
		onModPreInit(aEvent);
	}
	@EventHandler public final void onLoad (FMLInitializationEvent aEvent) {
		onModInit(aEvent);
	}
	@EventHandler public final void onPostLoad	(FMLPostInitializationEvent	aEvent) {
		onModPostInit(aEvent);
	}
	@EventHandler public final void onServerStarting (FMLServerStartingEvent aEvent) {
		onModServerStarting(aEvent);
	}
	@EventHandler public final void onServerStarted	(FMLServerStartedEvent aEvent) {
		onModServerStarted(aEvent);
	}
	@EventHandler public final void onServerStopping (FMLServerStoppingEvent aEvent) {
		onModServerStopping(aEvent);
	}
	@EventHandler public final void onServerStopped (FMLServerStoppedEvent aEvent) {
		onModServerStopped(aEvent);
	}

	public GregTechWeaponWorks(){
		INSTANCE = this;
	}

	private static void multiblocks(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetal, MultiTileEntityBlock aMetalChips, MultiTileEntityBlock aMetalWires, MultiTileEntityBlock aMachine, MultiTileEntityBlock aWooden, MultiTileEntityBlock aBush, MultiTileEntityBlock aStone, MultiTileEntityBlock aWool, MultiTileEntityBlock aTNT, MultiTileEntityBlock aHive, MultiTileEntityBlock aUtilMetal, MultiTileEntityBlock aUtilStone, MultiTileEntityBlock aUtilWood, MultiTileEntityBlock aUtilWool, OreDictMaterial aMat, Class aClass) {
		aMat = MT.SteelGalvanized;
		//stainless steel id:18002
		aRegistry.add("100% E-Net Proof Galvanized Steel Wall", "Multiblock Machines", 0, 17101, aClass, aMat.mToolQuality, 64, aMachine, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(6.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.texture", "metalwall", "gt.designs", Integer.valueOf(3) }), new Object[] { "P", Character.valueOf('P'), MultiTileEntityRegistry.getRegistry("gt.multitileentity").getItem(18008) });
		aRegistry.add("Small Galvanized Steel Tank Main Valve", "Multiblock Machines", 1, 17101, MultiTileEntityTank3x3x3Metal.class, aMat.mToolQuality, 16, aMachine, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(6.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.texture", "tankmetal", "gt.tankcap", Integer.valueOf(1296000), "gt.design", Integer.valueOf(0), "gt.gasproof", Boolean.valueOf(true), Boolean.valueOf(false) }), new Object[] { " R ", "hMs", " R ", Character.valueOf('M'), aRegistry.getItem(0), Character.valueOf('R'), OP.ring.dat(aMat) });
		aRegistry.add("100% E-Net Proof Dense Galvanized Steel Wall", "Multiblock Machines", 2, 17101, aClass, aMat.mToolQuality, 64, aMachine, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(6.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.texture", "metalwall", "gt.designs", Integer.valueOf(3) }), new Object[] { "P", Character.valueOf('P'), MultiTileEntityRegistry.getRegistry("gt.multitileentity").getItem(18028) });
		aRegistry.add("Small Dense Galvanized Steel Tank Main Valve", "Multiblock Machines", 3, 17101, MultiTileEntityTank3x3x3Metal.class, aMat.mToolQuality, 16, aMachine, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(6.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.texture", "tankmetal", "gt.tankcap", Integer.valueOf(5184000), "gt.design", Integer.valueOf(2), "gt.gasproof", Boolean.valueOf(true), Boolean.valueOf(false) }), new Object[] { " R ", "hMs", " R ", Character.valueOf('M'), aRegistry.getItem(2), Character.valueOf('R'), OP.ring.dat(aMat) });
		//5x5
		aRegistry.add("Large Galvanized Steel Tank Main Valve", "Multiblock Machines", 5, 17101, MultiTileEntityTank5x5x5Metal.class, aMat.mToolQuality, 16, aMachine, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(6.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.texture", "tankmetal", "gt.tankcap", Integer.valueOf(6000000), "gt.design", Integer.valueOf(0), "gt.gasproof", Boolean.valueOf(true), Boolean.valueOf(false) }), new Object[] { "PPP", "hMs", "PPP", 'M', aRegistry.getItem(0), 'P', OP.plateDense.dat(aMat) });
		aRegistry.add("Large Dense Galvanized Steel Tank Main Valve", "Multiblock Machines", 6, 17101, MultiTileEntityTank5x5x5Metal.class, aMat.mToolQuality, 16, aMachine, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(6.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.texture", "tankmetal", "gt.tankcap", Integer.valueOf(24000000), "gt.design", Integer.valueOf(2), "gt.gasproof", Boolean.valueOf(true), Boolean.valueOf(false) }), new Object[] { "PPP", "hMs", "PPP", 'M', aRegistry.getItem(2), 'P', OP.plateDense.dat(aMat) });

		//not a multiblock, but whatever :P
		aRegistry.add("Galvanized Steel Drum", "Fluid Containers", 4, 32719, MultiTileEntityBarrelMetal.class, 0, 16, aUtilMetal, UT.NBT.make(null, new Object[] { "gt.material", aMat, "gt.hardness", Float.valueOf(1.0F), "gt.resistance", Float.valueOf(6.0F), "gt.color", Integer.valueOf(UT.Code.getRGBInt(aMat.fRGBaSolid)), "gt.tankcap", Integer.valueOf(48000), "gt.gasproof", Boolean.valueOf(true) }), new Object[] { " h ", "PSP", "PSP", Character.valueOf('P'), OP.plateCurved.dat(aMat), Character.valueOf('S'), OP.stickLong.dat(aMat) });
	}

	@Override
	public void onModPreInit2(FMLPreInitializationEvent aEvent) {
		System.out.println("--- Start SuperCoder pretending he knows how to code ---");
		new MultiTileEntityRegistry("gtww.multitiles");
		ConfigHandler.loadConfig();

		// If you want to make yourself a new OreDict Material. Please look up proper IDs. So replace 32766 with a Number inside YOUR own ID Range. (you can look that up in gregapi.oredict.OreDictMaterial.java)
		//I don't have a good use for this yet

		// You would think this order is not easy to mess up. well you are wrong
		ModItems.init(); //inits normal items
		GTMetaItem.init(); //inits GT-Style items
		ModEntities.init(); //inits entities
        ModBlocks.init(); //inits blocks
        ModTiles.init(); //inits tile entities
		GTWWMaterials.init(); //inits materials



		//** Start copied code
		MultiTileEntityBlock Metal = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "iron", Material.iron, Block.soundTypeMetal, "pickaxe", 0, 0, 15, false, false);
		MultiTileEntityBlock MetalChips = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "iron", Material.iron, Block.soundTypeMetal, "shovel", 0, 0, 15, false, false);
		MultiTileEntityBlock MetalWires = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "machine", MaterialMachines.instance, Block.soundTypeMetal, "cutter", 0, 0, 15, false, false);
		MultiTileEntityBlock Machine = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "machine", MaterialMachines.instance, Block.soundTypeMetal, "wrench", 0, 0, 15, false, false);
		MultiTileEntityBlock Wooden = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "wood", Material.wood, Block.soundTypeWood, "axe", 0, 0, 15, false, false);
		MultiTileEntityBlock Bush = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "leaves", Material.leaves, Block.soundTypeGrass, "axe", 0, 0, 15, false, false);
		MultiTileEntityBlock Stone = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "rock", Material.rock, Block.soundTypeStone, "pickaxe", 0, 0, 15, false, false);
		MultiTileEntityBlock Wool = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "cloth", Material.cloth, Block.soundTypeCloth, "shears", 0, 0, 15, false, false);
		MultiTileEntityBlock TNT = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "tnt", Material.tnt, Block.soundTypeGrass, "pickaxe", 0, 0, 15, false, false);
		MultiTileEntityBlock UtilMetal = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight, Block.soundTypeMetal, "pickaxe", 0, 0, 15, false, false);
		MultiTileEntityBlock UtilStone = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight, Block.soundTypeStone, "pickaxe", 0, 0, 15, false, false);
		MultiTileEntityBlock UtilWood = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight, Block.soundTypeWood, "axe", 0, 0, 15, false, false);
		MultiTileEntityBlock UtilWool = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight, Block.soundTypeCloth, "shears", 0, 0, 15, false, false);
		MultiTileEntityBlock Hive = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "rock", MaterialScoopable.instance, Block.soundTypeWood, "scoop", 0, 0, 15, false, false);
		//** End copied code

		MultiTileEntityRegistry multitiles = MultiTileEntityRegistry.getRegistry("gtww.multitiles"); // dont change or get an angry bear that wants to kill you

		multiblocks(multitiles, Metal, MetalChips, MetalWires, Machine, Wooden, Bush, Stone, Wool, TNT, UtilMetal, UtilStone, UtilWood, UtilWool, Hive, MT.NULL, MultiTileEntityMultiBlockPart.class);

	}
	
	@Override
	public void onModInit2(FMLInitializationEvent aEvent) {
		MinecraftForge.EVENT_BUS.register(new UIRenderHandler());

		//CR.shaped(new ItemStack(ModItems.gun, 1, 0),CR.DEF, "CCN", "SBI", "dhW", 'C', OP.plateCurved.mat(MT.Steel,1), 'N', OP.plateDouble.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.Steel, 1), 'B', OP.bolt.mat(MT.Steel,1), 'I', OP.stick.mat(MT.Steel, 1), 'W', OP.stick.mat(MT.Wood,1));
		//CR.shaped(new ItemStack(ModItems.gun, 1, 1),CR.DEF, "CCN", "SBI", "dhW", 'C', OP.plateCurved.mat(MT.StainlessSteel,1), 'N', OP.plateDouble.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.StainlessSteel, 1), 'B', OP.bolt.mat(MT.StainlessSteel,1), 'I', OP.stick.mat(MT.StainlessSteel, 1), 'W', OP.stick.mat(MT.StainlessSteel,1));
		//CR.shaped(new ItemStack(ModItems.gun, 1, 2),CR.DEF, "CCN", "SBI", "dhW", 'C', OP.plateCurved.mat(MT.TungstenSteel,1), 'N', OP.plateDouble.mat(MT.Ti, 1), 'S', OP.screw.mat(MT.Ti, 1), 'B', OP.bolt.mat(MT.Ti,1), 'I', OP.stick.mat(MT.Ti, 1), 'W', OP.stick.mat(MT.Ti,1));

		CR.shaped(new ItemStack(ModItems.gun, 1, 3),CR.DEF, "CSN", "SBI", "dhW", 'C', OP.plateCurved.mat(MT.Bronze,1), 'N', OP.bolt.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.Bronze, 1), 'B', OP.bolt.mat(MT.Bronze,1), 'I', OP.stick.mat(MT.Bronze, 1), 'W', OP.stick.mat(MT.Wood,1));

		//CR.shaped(new ItemStack(ModItems.gun, 1, 4),CR.DEF, "LCN", "SBI", "dhW", 'C', OP.plateCurved.mat(MT.Steel,1), 'N', OP.plateDouble.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.Al, 1), 'B', OP.bolt.mat(MT.Steel,1), 'I', OP.stick.mat(MT.StainlessSteel, 1), 'W', OP.stick.mat(MT.StainlessSteel,1), 'L', OP.stickLong.mat(MT.Steel, 1));
		CR.shaped(new ItemStack(ModItems.gun, 1, 5),CR.DEF, "CLN", "SBI", "dhW", 'C', OP.plateCurved.mat(MT.StainlessSteel,1), 'N', OP.plateDouble.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.Al, 1), 'B', OP.bolt.mat(MT.StainlessSteel,1), 'I', OP.stick.mat(MT.StainlessSteel, 1), 'W', OP.stick.mat(MT.StainlessSteel,1), 'L', OP.stickLong.mat(MT.Ti, 1));
		CR.shaped(new ItemStack(ModItems.gun, 1, 6),CR.DEF, "BSB", "IzI", "BSB", 'B', new ItemStack(ModItems.gun, 1, 3), 'S', OP.plateCurved.mat(MT.StainlessSteel, 1), 'I', OP.stickLong.mat(MT.StainlessSteel, 1));

		CR.shaped(new ItemStack(ModItems.container, 1, 0), CR.DEF, " f ", "PhP",  'P', OP.plate.mat(MT.Steel, 1));
		CR.shaped(new ItemStack(ModItems.container, 1, 1), CR.DEF,  "PGP",  'P', new ItemStack(Items.paper, 1, 0), 'G', new ItemStack(Items.gunpowder, 1, 0), 'L', OP.plateTiny.mat(MT.Brass, 1));

		CR.shaped(new ItemStack(ModItems.scissors, 1, 0), CR.DEF, "L L", " S ", "R R", 'L', OP.stick.mat(MT.Fe, 1), 'S', OP.screw.mat(MT.Fe, 1), 'R', OP.ring.mat(MT.Fe, 1));
		CR.shaped(new ItemStack(ModItems.scissors, 1, 1), CR.DEF, "L L", " S ", "R R", 'L', OP.stick.mat(MT.Bronze, 1), 'S', OP.screw.mat(MT.Bronze, 1), 'R', OP.ring.mat(MT.Bronze, 1));
		CR.shaped(new ItemStack(ModItems.scissors, 1, 2), CR.DEF, "L L", " S ", "RPR", 'L', OP.stick.mat(MT.TungstenSteel, 1), 'S', OP.screw.mat(MT.TungstenSteel, 1), 'R', OP.ring.mat(MT.TungstenSteel, 1), 'P', OP.springSmall.mat(MT.TungstenSteel, 1));
		CR.shaped(new ItemStack(ModItems.scissors, 1, 3), CR.DEF, "L L", " S ", "R R", 'L', OP.stick.mat(MT.Au, 1), 'S', OP.screw.mat(MT.Au, 1), 'R', OP.ring.mat(MT.Au, 1));

		CR.shaped(new ItemStack(ModItems.grenade, 3, 0), CR.DEF, "hOQ", "fIS", "GGG", 'I', OP.plateCurved.mat(MT.Fe, 1), 'O', OP.ring.mat(MT.Fe, 1), 'S', OP.stick.mat(MT.Fe, 1), 'G', OP.dust.mat(MT.Gunpowder, 1), 'Q', OP.screw.mat(MT.Fe, 1));
        CR.shaped(new ItemStack(ModItems.grenade, 2, 1), CR.DEF, "hIS", "IGI", " If", 'I', OP.plateCurved.mat(MT.Steel, 1),  'S', new ItemStack(Items.string, 1), 'G', OP.dust.mat(MT.Dynamite, 1));

        CR.shapeless(OP.bulletGtSmall.mat(MT.Empty, 1), CR.DEF, new Object[]{new ItemStack(ModItems.ejectedBullet, 1, 0), OP.dustTiny.mat(MT.Gunpowder, 1)});
		CR.shapeless(OP.bulletGtMedium.mat(MT.Empty, 1), CR.DEF, new Object[]{new ItemStack(ModItems.ejectedBullet, 1, 1), OP.dustTiny.mat(MT.Gunpowder, 1), OP.dustTiny.mat(MT.Gunpowder, 1)});
		CR.shapeless(OP.bulletGtLarge.mat(MT.Empty, 1), CR.DEF, new Object[]{new ItemStack(ModItems.ejectedBullet, 1, 2), OP.dustTiny.mat(MT.Gunpowder, 1), OP.dustTiny.mat(MT.Gunpowder, 1), OP.dustTiny.mat(MT.Gunpowder, 1)});

		CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 4), CR.DEF, "PPD", "dST", "hfT", 'P', OP.plateCurved.mat(MT.Bronze, 1), 'D', OP.plateDouble.mat(MT.Bronze, 1), 'S', OP.screw.mat(MT.Bronze, 1), 'T', new ItemStack(Items.stick, 1));
        CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 5), CR.DEF, "WSW", "hWR", "sQT", 'W', OP.plate.mat(MT.WoodSealed, 1), 'S', OP.plate.mat(MT.Steel, 1), 'R', OP.screw.mat(MT.Steel, 1), 'Q', OP.bolt.mat(MT.Steel, 1), 'T', new ItemStack(Items.stick, 1));
        CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 29), CR.DEF, "PPD", "dST", "hfT", 'P', OP.plateCurved.mat(MT.Steel, 1), 'D', OP.plateDouble.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.Fe, 1), 'T', OP.stick.mat(MT.Bronze, 1));
		CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 29), CR.DEF, "PPD", "dST", "hfT", 'P', OP.plateCurved.mat(MT.Steel, 1), 'D', OP.plateDouble.mat(MT.Steel, 1), 'S', OP.screw.mat(MT.WroughtIron, 1), 'T', OP.stick.mat(MT.Bronze, 1));
        CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 27), CR.DEF, "PPS", "TTH", "hfH", 'P', OP.plateCurved.mat(MT.Steel, 1), 'S', OP.plate.mat(MT.Steel, 1), 'T', OP.stick.mat(MT.Fe, 1), 'H', OP.stick.mat(MT.Bronze, 1));
		CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 27), CR.DEF, "PPS", "TTH", "hfH", 'P', OP.plateCurved.mat(MT.Steel, 1), 'S', OP.plate.mat(MT.Steel, 1), 'T', OP.stick.mat(MT.WroughtIron, 1), 'H', OP.stick.mat(MT.Bronze, 1));
        CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 9), CR.DEF, "PPL", "TTS", "Shf", 'P', OP.plateCurved.mat(MT.Bronze, 1), 'L', OP.plateDouble.mat(MT.Bronze, 1), 'T', OP.stick.mat(MT.Bronze, 1), 'S', new ItemStack(Items.stick, 1));
        CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 6), CR.DEF, "PIL", "TLT", "hfT", 'P', OP.plateCurved.mat(MT.Bronze, 1), 'I', OP.stick.mat(MT.Fe, 1), 'L', OP.plate.mat(MT.WoodSealed, 1), 'T', OP.stick.mat(MT.Bronze, 1));
        CR.shaped(new ItemStack(ModItems.unlockableGun, 1, 6), CR.DEF, "PIL", "TLT", "hfT", 'P', OP.plateCurved.mat(MT.Bronze, 1), 'I', OP.stick.mat(MT.WroughtIron, 1), 'L', OP.plate.mat(MT.WoodSealed, 1), 'T', OP.stick.mat(MT.Bronze, 1));

        CR.shaped(new ItemStack(ModBlocks.teslas.get(0), 1), CR.DEF, "RwS", "BCB", "ShR", 'C', OP.casingMachine.dat(MT.SteelGalvanized), 'B', OP.wireGt16.dat(MT.Cu), 'S', OP.stick.mat(MT.Steel, 1), 'R', OP.ring.mat(MT.Steel, 1));

        CR.shapeless(MultiTileEntityRegistry.getRegistry("gt.multitileentity").getItem(18008), new Object[]{MultiTileEntityRegistry.getRegistry("gtww.multitiles").getItem(0)});
		CR.shapeless(MultiTileEntityRegistry.getRegistry("gt.multitileentity").getItem(18028), new Object[]{MultiTileEntityRegistry.getRegistry("gtww.multitiles").getItem(2)});
	}
	
	@Override
	public void onModPostInit2(cpw.mods.fml.common.event.FMLPostInitializationEvent aEvent) {
		ChestLootHandler.init(); // loads dungeon loot
		RM.Boxinator.add(new RecipeMapHandlerPrefix(OP.bulletGtSmall, 8L, CS.NF, 16L, 64L, 0L, CS.NF, GTMetaItem.prefixMagazineLC, 1L, new ItemStack(ModItems.container, 1, 0), CS.NI, true, false, false, new ICondition.And(new ICondition.Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS)));
		RM.Boxinator.add(new RecipeMapHandlerPrefix(OP.bulletGtMedium, 8L, CS.NF, 16L, 64L, 0L, CS.NF, GTMetaItem.prefixMagazineMC, 1L, new ItemStack(ModItems.container, 1, 0), CS.NI, true, false, false, new ICondition.And(new ICondition.Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS)));
		RM.Boxinator.add(new RecipeMapHandlerPrefix(OP.bulletGtLarge, 8L, CS.NF, 16L, 64L, 0L, CS.NF, GTMetaItem.prefixMagazineHC, 1L, new ItemStack(ModItems.container, 1, 0), CS.NI, true, false, false, new ICondition.And(new ICondition.Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS)));

		RM.Unboxinator.add(new RecipeMapHandlerPrefix(GTMetaItem.prefixMagazineLC, 1L, CS.NF, 16L, 128L, 0L, CS.NF, OP.bulletGtSmall, 8L,  CS.NI, new ItemStack(ModItems.container, 1, 0),true, false, false, new ICondition.And(new ICondition.Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS)));
		RM.Unboxinator.add(new RecipeMapHandlerPrefix(GTMetaItem.prefixMagazineMC, 1L, CS.NF, 16L, 128L, 0L, CS.NF, OP.bulletGtMedium, 8L,  CS.NI, new ItemStack(ModItems.container, 1, 0),true, false, false, new ICondition.And(new ICondition.Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS)));
		RM.Unboxinator.add(new RecipeMapHandlerPrefix(GTMetaItem.prefixMagazineHC, 1L, CS.NF, 16L, 128L, 0L, CS.NF, OP.bulletGtLarge, 8L,  CS.NI, new ItemStack(ModItems.container, 1, 0),true, false, false, new ICondition.And(new ICondition.Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS)));
		RM.Mixer.addRecipe0(true, 16, 64, new FluidStack[]{MT.Kerosine.liquid(CS.U10*4, true), MT.Petrol.liquid(CS.U10*4*4, true)}, UT.Fluids.make(fluidMolotovMixture, 2000), CS.ZL_IS);
        RM.Canner.addRecipe1(true, 64, 128, new ItemStack(Items.glass_bottle, 1), UT.Fluids.make(fluidMolotovMixture, 500), CS.NF, new ItemStack(ModItems.grenade, 1, 2));
		RM.Boxinator.addRecipe2(true, 32, 8, new ItemStack(ModItems.ejectedBullet, 1, 0), OP.dustTiny.mat(MT.Gunpowder, 1), OP.bulletGtSmall.mat(MT.Empty, 1));
        RM.Boxinator.addRecipe2(true, 32, 8, new ItemStack(ModItems.ejectedBullet, 1, 1), OP.dustTiny.mat(MT.Gunpowder, 2), OP.bulletGtMedium.mat(MT.Empty, 1));
        RM.Boxinator.addRecipe2(true, 32, 8, new ItemStack(ModItems.ejectedBullet, 1, 2), OP.dustTiny.mat(MT.Gunpowder, 3), OP.bulletGtLarge.mat(MT.Empty, 1));

        RM.BurnMixer.addRecipe1(true, 64, 16, OP.dust.mat(MT.Coal, 1), FL.Water.make(25), UT.Fluids.make(fluidLiqueficatedCoal, 25), CS.ZL_IS);
		RM.BurnMixer.addRecipe1(true, 64, 8, OP.dust.mat(MT.Lignite, 1), FL.Water.make(10), UT.Fluids.make(fluidLiqueficatedCoal, 10), CS.ZL_IS);
		RM.BurnMixer.addRecipe1(true, 64, 16, OP.dust.mat(MT.Coal, 1), FL.DistW.make(25), UT.Fluids.make(fluidLiqueficatedCoal, 25), CS.ZL_IS);
		RM.BurnMixer.addRecipe1(true, 64, 8, OP.dust.mat(MT.Lignite, 1), FL.DistW.make(10), UT.Fluids.make(fluidLiqueficatedCoal, 10), CS.ZL_IS);

		RM.DistillationTower.addRecipeX(true, 64, 32, CS.ZL_IS, new FluidStack[]{UT.Fluids.make(fluidLiqueficatedCoal, 50)}, new FluidStack[]{MT.Fuel.liquid(CS.U1000*30, true), MT.Diesel.liquid(CS.U1000*30, true), MT.Kerosine.liquid(CS.U1000*20, true), UT.Fluids.make(fluidCoalGas, 100)}, OP.dustSmall.mat(MT.Asphalt, 1));
		//God damn it greg
        //RM.DistillationTower.addRecipeX(true, 256, 640, CS.ZL_IS, new FluidStack[]{UT.Fluids.make(fluidCoalGas, 1250L)}, new FluidStack[]{FL.DistW.make(1250L), MT.Petrol.liquid(CS.U20*10, true), MT.Butane.gas(CS.U20*20, true), MT.Propane.gas(CS.U20*15, true)});

        //Thorium shit

		System.out.println("If you have waited for this long, congratulations! You get a cake!");
	}
	
	@Override
	public void onModServerStarting2(cpw.mods.fml.common.event.FMLServerStartingEvent aEvent) {

	}
	
	@Override
	public void onModServerStarted2(cpw.mods.fml.common.event.FMLServerStartedEvent aEvent) {
		
	}
	
	@Override
	public void onModServerStopping2(cpw.mods.fml.common.event.FMLServerStoppingEvent aEvent) {
		
	}
	
	@Override
	public void onModServerStopped2(cpw.mods.fml.common.event.FMLServerStoppedEvent aEvent) {
		
	}
}
