package supercoder79.gtweapons.item;

import gregapi.code.ICondition.And;
import gregapi.code.ICondition.Or;
import gregapi.data.*;
import gregapi.item.prefixitem.PrefixItem;
import gregapi.oredict.OreDictManager;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregapi.render.TextureSet;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.api.MatHelpers;
import supercoder79.gtweapons.api.qwerty.ShapelessCraftFrom;

import java.util.List;

import static gregapi.data.TD.Prefix.*;

public class GTMetaItem {
	public static OreDictPrefix prefixMagazineLC;
	public static OreDictPrefix prefixMagazineMC;
	public static OreDictPrefix prefixMagazineHC;
	public static OreDictPrefix prefixBulletSG;


	public static void init(){
		addDataToNormalItems(); // look at the function name, dummy
//		final OreDictPrefix prefixBulletHC = OreDictPrefix.createPrefix("gtweaponsBulletHC");
//		prefixBulletHC.setCategoryName("High Caliber Bullets");
//		prefixBulletHC.setLocalItemName("High Caliber ", " Bullet");
//		prefixBulletHC.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
//		prefixBulletHC.setStacksize(24);
//		prefixBulletHC.setMaterialStats(CS.U*2);
//		prefixBulletHC.setTextureSetName("gtweaponsBulletHC");
//		prefixBulletHC.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
//		prefixBulletHC.mByProducts.add(OM.stack(MT.Dynamite, OP.ingot.mAmount));
//		prefixBulletHC.mByProducts.add(OM.stack(MT.Pb, OP.ingot.mAmount / 4));
//		final int prefixBulletHCID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsBulletHC");
//		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.bulletHC", prefixBulletHC){
//			public void func_77624_a(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H)
//			{
//				OreDictMaterial mat = OreDictManager.INSTANCE.getItemData(aStack).mMaterial.mMaterial;
//				float tCombat = MatHelpers.getDamageFromMaterial(mat.mID, 2);
//				aList.add(LH.Chat.WHITE + "Damage (Sniper): " + LH.Chat.BLUE  + tCombat + LH.Chat.RED + " (" + (tCombat) / 2.0F + " Hearts)" + LH.Chat.GRAY);
//
//			}
//		};
//
//		final OreDictPrefix prefixBulletLC = OreDictPrefix.createPrefix("gtweaponsBulletLC");
//		prefixBulletLC.setCategoryName("Low Caliber Bullets");
//		prefixBulletLC.setLocalItemName("Low Caliber ", " Bullet");
//		prefixBulletLC.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
//		prefixBulletLC.setStacksize(48);
//		prefixBulletLC.setMaterialStats(CS.U);
//		prefixBulletLC.setTextureSetName("gtweaponsBulletLC");
//		prefixBulletLC.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
//		prefixBulletLC.mByProducts.add(OM.stack(MT.Gunpowder, OP.ingot.mAmount));
//		prefixBulletLC.mByProducts.add(OM.stack(MT.Pb, OP.ingot.mAmount / 4));
//		final int prefixBulletLCID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsBulletLC");
//		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.bulletLC", prefixBulletLC){
//			public void func_77624_a(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H)
//			{
//				OreDictMaterial mat = OreDictManager.INSTANCE.getItemData(aStack).mMaterial.mMaterial;
//				float tCombat = MatHelpers.getDamageFromMaterial(mat.mID, 0);
//				float tCombat2 = MatHelpers.getDamageFromMaterial(mat.mID, 1);
//				aList.add(LH.Chat.WHITE + "Damage (Pistol): " + LH.Chat.BLUE  + tCombat + LH.Chat.RED + " (" + (tCombat) / 2.0F + " Hearts)" + LH.Chat.GRAY);
//				aList.add(LH.Chat.WHITE + "Damage (SMG): " + LH.Chat.BLUE  + tCombat2 + LH.Chat.RED + " (" + (tCombat2) / 2.0F + " Hearts)" + LH.Chat.GRAY);
//			}
//		};
//
//
		prefixBulletSG = OreDictPrefix.createPrefix("gtweaponsBulletSG");
		prefixBulletSG.setCategoryName("Shotgun Shells");
		prefixBulletSG.setLocalItemName("", " Blunderbuss shot");
		prefixBulletSG.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
		prefixBulletSG.setStacksize(32);
		prefixBulletSG.setMaterialStats(CS.U9*4);
		prefixBulletSG.setTextureSetName("gtweaponsBulletSG");
		prefixBulletSG.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
		prefixBulletSG.mByProducts.add(OM.stack(MT.Paper, OP.ingot.mAmount / 2));
		prefixBulletSG.mByProducts.add(OM.stack(MT.Gunpowder, OP.ingot.mAmount / 2));
		final int prefixBulletSGID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsBulletSG");
		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.bulletSG", prefixBulletSG){
			public void func_77624_a(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H)
			{
				OreDictMaterial mat = OreDictManager.INSTANCE.getItemData(aStack).mMaterial.mMaterial;
				float tCombat = MatHelpers.getDamageFromMaterial(mat.mID, 3);
				aList.add(LH.Chat.WHITE + "Damage: " + LH.Chat.BLUE  + tCombat + LH.Chat.RED + " (" + (tCombat) / 2.0F + " Hearts)" + LH.Chat.GRAY);
			}
		};

		prefixMagazineHC = gregapi.oredict.OreDictPrefix.createPrefix("gtweaponsMagazineHC");
		prefixMagazineHC.setCategoryName("High Caliber Bullet Magazines");
		prefixMagazineHC.setLocalItemName("High Caliber ", " Bullet Magazine");
		prefixMagazineHC.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
		prefixMagazineHC.setStacksize(4);
		prefixMagazineHC.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
		//prefixMagazineHC.setMaterialStats(CD.U);
		prefixMagazineHC.setMaterialStats(CS.U3 * 8);
		prefixMagazineHC.setTextureSetName("gtweaponsMagazineHC");
		prefixMagazineHC.mByProducts.add(OM.stack(MT.Steel, CS.U * 2));
		prefixMagazineHC.mByProducts.add(OM.stack(MT.Brass, CS.U3 * 8));
		prefixMagazineHC.mByProducts.add(OM.stack(MT.Gunpowder, CS.U3 * 8));

		final int prefixMagazineHCID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsMagazineHC");
		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.magazineHC", prefixMagazineHC) {
			public void func_77624_a(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H)
			{
				OreDictMaterial mat = OreDictManager.INSTANCE.getItemData(aStack).mMaterial.mMaterial;
				float tCombat = MatHelpers.getDamageFromMaterial(mat.mID, 2);
				aList.add(LH.Chat.WHITE + "Damage (Sniper): " + LH.Chat.BLUE  + tCombat + LH.Chat.RED + " (" + (tCombat) / 2.0F + " Hearts)" + LH.Chat.GRAY);
			}
		};

		prefixMagazineMC = gregapi.oredict.OreDictPrefix.createPrefix("gtweaponsMagazineMC");
		prefixMagazineMC.setCategoryName("Medium Caliber Bullet Magazines");
		prefixMagazineMC.setLocalItemName("Medium Caliber ", " Bullet Magazine");
		prefixMagazineMC.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
		prefixMagazineMC.setStacksize(4);
		prefixMagazineMC.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
		//prefixMagazineLC.setMaterialStats(CD.U);
		prefixMagazineMC.setMaterialStats(CS.U9 * 8);
		prefixMagazineMC.setTextureSetName("gtweaponsMagazineMC");
		prefixMagazineMC.mByProducts.add(OM.stack(MT.Steel, CS.U * 2));
		prefixMagazineMC.mByProducts.add(OM.stack(MT.Brass, CS.U9 * 8));
		prefixMagazineMC.mByProducts.add(OM.stack(MT.Gunpowder, CS.U9 * 8));
		final int prefixMagazineMCID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsMagazineMC");
		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.magazineMC", prefixMagazineMC){
			public void func_77624_a(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H)
			{
				OreDictMaterial mat = OreDictManager.INSTANCE.getItemData(aStack).mMaterial.mMaterial;
				float tCombat = MatHelpers.getDamageFromMaterial(mat.mID, 4);
				float tCombat2 = MatHelpers.getDamageFromMaterial(mat.mID, 5);
				aList.add(LH.Chat.WHITE + "Damage (Assault Rifle): " + LH.Chat.BLUE  + tCombat + LH.Chat.RED + " ( " + (tCombat) / 2.0F + " Hearts)" + LH.Chat.GRAY);
				aList.add(LH.Chat.WHITE + "Damage (Burst Rifle): " + LH.Chat.BLUE  + tCombat2 + LH.Chat.RED + " (" + (tCombat2) / 2.0F + " Hearts)" + LH.Chat.GRAY);
			}
		};

		prefixMagazineLC = gregapi.oredict.OreDictPrefix.createPrefix("gtweaponsMagazineLC");
		prefixMagazineLC.setCategoryName("Low Caliber Bullet Magazines");
		prefixMagazineLC.setLocalItemName("Low Caliber ", " Bullet Magazine");
		prefixMagazineLC.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
		prefixMagazineLC.setStacksize(4);
		prefixMagazineLC.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
		//prefixMagazineLC.setMaterialStats(CD.U);
		prefixMagazineLC.setMaterialStats(CS.U9 * 8);
		prefixMagazineLC.setTextureSetName("gtweaponsMagazineLC");
		prefixMagazineLC.mByProducts.add(OM.stack(MT.Steel, CS.U * 2));
		prefixMagazineLC.mByProducts.add(OM.stack(MT.Brass, CS.U9 * 8));
		prefixMagazineLC.mByProducts.add(OM.stack(MT.Gunpowder, CS.U9 * 8));
		final int prefixMagazineLCID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsMagazineLC");
		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.magazineLC", prefixMagazineLC){
			public void func_77624_a(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H)
			{
				OreDictMaterial mat = OreDictManager.INSTANCE.getItemData(aStack).mMaterial.mMaterial;
				float tCombat = MatHelpers.getDamageFromMaterial(mat.mID, 0);
				float tCombat2 = MatHelpers.getDamageFromMaterial(mat.mID, 1);
				aList.add(LH.Chat.WHITE + "Damage (Pistol): " + LH.Chat.BLUE  + tCombat + LH.Chat.RED + " ( " + (tCombat) / 2.0F + " Hearts)" + LH.Chat.GRAY);
				aList.add(LH.Chat.WHITE + "Damage (SMG): " + LH.Chat.BLUE  + tCombat2 + LH.Chat.RED + " (" + (tCombat2) / 2.0F + " Hearts)" + LH.Chat.GRAY);
			}
		};

		//Unused
//		final gregapi.oredict.OreDictPrefix prefixMagazineSG = gregapi.oredict.OreDictPrefix.createPrefix("gtweaponsMagazineSG");
//		prefixMagazineSG.setCategoryName("Shotgun Cartridges");
//		prefixMagazineSG.setLocalItemName("", " Shotgun Cartridge");
//		prefixMagazineSG.add(UNIFICATABLE, RECYCLABLE, SCANNABLE);
//		prefixMagazineSG.setStacksize(4);
//		prefixMagazineSG.setCondition(new And(new Or(TD.Atomic.METAL, TD.Compounds.ALLOY), TD.Properties.HAS_TOOL_STATS));
//		//prefixMagazineSG.setMaterialStats(CD.U);
//		prefixMagazineSG.setMaterialStats(CS.U * 2);
//		prefixMagazineSG.setTextureSetName("gtweaponsMagazineSG");
//		prefixMagazineSG.mByProducts.add(OM.stack(MT.Paper, OP.ingot.mAmount));
//		prefixMagazineSG.mByProducts.add(OM.stack(MT.Brass, (OP.ingot.mAmount/9)*2));
//		final int prefixMagazineSGID = TextureSet.addToAll(GregTechWeaponWorks.MOD_ID, true, "gtweaponsMagazineSG");
//		new PrefixItem(GregTechWeaponWorks.MOD_DATA, "gtweapons.meta.item.magazineSG", prefixMagazineSG);

		//do the crafting recipes
		// RRR
		// PRP
		// DpD
//		prefixBulletLC.addListener(new ShapelessCraftFrom( 1, null, new String[][] {{"XWX", "hVf", "   "}}, OP.plateCurved, null, null, Items.gunpowder, OP.round.dat(OreDictMaterial.MATERIAL_ARRAY[MT.Pb.mID]), TD.Atomic.ANTIMATTER.NOT));
		prefixBulletSG.addListener(new ShapelessCraftFrom( 1, null, new String[][] {{" X ", "XVX", " X "}}, OP.nugget, null, null, new ItemStack(ModItems.container, 1, 1), null, TD.Atomic.ANTIMATTER.NOT));

		prefixMagazineLC.addListener(new ShapelessCraftFrom( 1, null, new String[][] {{"XXX", "XVX", "XXX"}}, OP.bulletGtSmall, null, null, new ItemStack(ModItems.container, 1, 0), null, TD.Atomic.ANTIMATTER.NOT));
		prefixMagazineHC.addListener(new ShapelessCraftFrom( 1, null, new String[][] {{"XXX", "XVX", "XXX"}}, OP.bulletGtLarge, null, null, new ItemStack(ModItems.container, 1, 0), null, TD.Atomic.ANTIMATTER.NOT));
		prefixMagazineMC.addListener(new ShapelessCraftFrom( 1, null, new String[][] {{"XXX", "XVX", "XXX"}}, OP.bulletGtMedium, null, null, new ItemStack(ModItems.container, 1, 0), null, TD.Atomic.ANTIMATTER.NOT));
//		RM.Press.addRecipeX(false, 120,600, new ItemStack[] {}, new ItemStack(prefixMagazineHC));

	}
	public static void addDataToNormalItems(){
		OM.data(ST.make(ModItems.container, 1,0), MT.Steel, CS.U*2); // steel magazine casing
		//empty shotgun shell - 0.5 paper and 0.111 brass
		OM.data(ST.make(ModItems.container, 1,1), MT.Paper, CS.U/2, OM.stack(MT.Brass, CS.U/9));
		OM.data(ST.make(ModItems.ejectedBullet, 1, 0), MT.Brass, CS.U9);
		OM.data(ST.make(ModItems.ejectedBullet, 1, 1), MT.Brass, CS.U9*2);
		OM.data(ST.make(ModItems.ejectedBullet, 1, 2), MT.Brass, CS.U3);
	}
}
