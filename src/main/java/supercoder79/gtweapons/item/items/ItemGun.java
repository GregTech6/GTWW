package supercoder79.gtweapons.item.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.data.IL;
import gregapi.data.LH;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.oredict.OreDictItemData;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregapi.util.OM;
import gregapi.util.UT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.api.MatHelpers;
import supercoder79.gtweapons.api.NBTUtils;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.entity.entities.EntityBullet;
import supercoder79.gtweapons.item.ModItems;

import java.util.ArrayList;
import java.util.List;


/**
 *@author SuperCoder79.
 */


public class ItemGun extends Item {

	/*
	 * 0 = pistol
	 * 1 = machine gun
	 * 2 = sniper
	 * 3 = blunderbuss
	 * 4 = assault rifle
	 * 5 = burst rifle
	 * 6 = bundlebuss
	 */
	public static final int WEAPON_NUMBER = 7;
	public IIcon[] icons = new IIcon[WEAPON_NUMBER];
	public static int[] cooldowns = {15, 4, 45, 25, 8, 16, 80};
	public static int[] hurtTime = {20, 4, 40, 0, 8, 0, 0};
	public static int[] maxHealth = {150, 750, 1500, 500, 1000, 1000, 500};
	public String[] tooltips = {"A basic gun", "The SMG shoots very fast",
			"The sniper does a lot of damage", "The blunderbuss will end most enemies in your way",
			"The assault rifle will assault monsters indeed", "The burst rifle shoots 4 bullets at a time", "The bundlebuss is like firing 4 blunderbusses at the same time"};

	public ArrayList textures = new ArrayList();
	
	public ItemGun(String unlocalisedName){
		super();
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(unlocalisedName);
		this.setCreativeTab(CreativeTabs.tabCombat);
		
		for (int i = 0; i < WEAPON_NUMBER; i ++) {
		this.setTextureName(unlocalisedName + "_" + i);

		}

	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < WEAPON_NUMBER; i ++) {
	        this.icons[i] = reg.registerIcon(GregTechWeaponWorks.MOD_ID + ":guns/" + i);
	    }
	}
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < WEAPON_NUMBER; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > WEAPON_NUMBER) {
	        meta = 0;
	    }
	    return this.icons[meta];
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (NBTUtils.NBTGetInteger(stack, "health") == 0){
				NBTUtils.NBTSetInteger(stack, "health", maxHealth[stack.getItemDamage()]);
		}

		if (world.getTotalWorldTime() >= NBTUtils.NBTGetLong(stack,"worldDelta")){
			if(NBTUtils.NBTGetInteger(stack, "ammo") <= 0) { // check if gun has 0 ammo
				for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
					String ammoType = "gtweaponsMagazineLC";
					if (stack.getItemDamage() == 1){
						ammoType = "gtweaponsMagazineLC";
					}
					if (stack.getItemDamage() == 2){
						ammoType = "gtweaponsMagazineHC";
					}
					if (stack.getItemDamage() == 3) {
						ammoType = "gtweaponsBulletSG";
					}
					if (stack.getItemDamage() == 4) {
						ammoType = "gtweaponsMagazineMC";
					}
					if (stack.getItemDamage() == 5) {
						ammoType = "gtweaponsMagazineMC";
					}
					if (stack.getItemDamage() == 6) {
						ammoType = "gtweaponsBulletSG";
					}
					OreDictItemData oDID = OM.anydata(player.inventory.getStackInSlot(i));
					if (oDID != null && oDID.mPrefix == OreDictPrefix.get(ammoType)) {
						if (stack.getItemDamage() == 6) {
							if (player.inventory.getStackInSlot(i).stackSize >= 4) {
								player.inventory.decrStackSize(i, 4);
								NBTUtils.NBTSetInteger(stack, "matID", oDID.mMaterial.mMaterial.mID);
								NBTUtils.NBTSetInteger(stack, "ammo", 1);
							} else {
								break;
							}
						} else {
							player.inventory.decrStackSize(i, 1);
							NBTUtils.NBTSetInteger(stack, "matID", oDID.mMaterial.mMaterial.mID);
							if (stack.getItemDamage() == 3)
								NBTUtils.NBTSetInteger(stack, "ammo", 1);
							else
								NBTUtils.NBTSetInteger(stack, "ammo", 8);
						}


//						stack.setStackDisplayName("Reloaded"); // what a horrible failure xD
						if (ConfigHandler.PlaySound) {
//							world.playSoundAtEntity(player, "gtweapons:reload", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
							UT.Sounds.send("gtweapons:reload", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
						}

						if (stack.getItemDamage() == 3) {
//							if (!player.inventory.addItemStackToInventory(OP.scrapGt.mat(MT.Paper, 2))) {
//								player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, OP.scrapGt.mat(MT.Paper, 2)));
//							}
							break;
						} else if (stack.getItemDamage() == 6) {
//							if (!player.inventory.addItemStackToInventory(OP.scrapGt.mat(MT.Paper, 8))) {
//								player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, OP.scrapGt.mat(MT.Paper, 8)));
//							}
							break;
						} else {
							if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.container, 1, 0))) {
								player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ModItems.container, 1, 0)));
							}
							break;
						}
					}
				}
			} else { // if not reloading
				if (NBTUtils.NBTGetInteger(stack, "ammo") > 0) {
					if (!world.isRemote) {
//						System.out.println("test");
						if (stack.getItemDamage() == 0) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:pistol", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ModItems.ejectedBullet, 1, 0)));
						}
						if (stack.getItemDamage() == 1) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:smg", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ModItems.ejectedBullet, 1, 0)));
						}
						if (stack.getItemDamage() == 2) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:sniper", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ModItems.ejectedBullet, 1, 2)));
						}
						if (stack.getItemDamage() == 3) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:blunderbuss", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, OP.scrapGt.mat(MT.Paper, 2)));
						}
						if (stack.getItemDamage() == 4) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:ar", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ModItems.ejectedBullet, 1, 1)));
						}
						if (stack.getItemDamage() == 5) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:burst", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(ModItems.ejectedBullet, 4, 1)));
						}
						if (stack.getItemDamage() == 6) {
							if (ConfigHandler.PlaySound) UT.Sounds.send("gtweapons:blunderbuss", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
							player.getEntityWorld().spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, OP.scrapGt.mat(MT.Paper, 8)));
						}
					}
					if (NBTUtils.NBTGetInteger(stack, "ammo") == 0)
						NBTUtils.NBTSetInteger(stack, "matID", 0);
					if (!world.isRemote && (NBTUtils.NBTGetInteger(stack, "health") > 1)) {
						NBTUtils.NBTSetInteger(stack, "ammo", NBTUtils.NBTGetInteger(stack, "ammo") - 1);
						if (stack.getItem() == ModItems.gun && stack.getItemDamage() < cooldowns.length)
							NBTUtils.NBTSetLong(stack, "worldDelta", world.getTotalWorldTime() + cooldowns[stack.getItemDamage()]);
						world.spawnParticle("largesmoke", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 0.0D);
						NBTUtils.NBTSetInteger(stack, "health", NBTUtils.NBTGetInteger(stack, "health") - 1);
//						world.playSound(player.posX, player.posY, player.posZ, "gtweapons:pistol", 1.0F, 0.6F, false);
						player.jump();
						if (stack.getItemDamage() == 3) {
							for (int i = 0; i < 8; i++) {
								world.spawnEntityInWorld(new EntityBullet(world, player, MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()), hurtTime[stack.getItemDamage()], NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()));
							}
						} else if (stack.getItemDamage() == 5) {
							NBTUtils.NBTSetInteger(stack, "ammo", NBTUtils.NBTGetInteger(stack, "ammo") - 3);
							for (int i = 0; i < 4; i++) {
								world.spawnEntityInWorld(new EntityBullet(world, player, MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()), hurtTime[stack.getItemDamage()], NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()));
							}
						} else if (stack.getItemDamage() == 6) {
							for (int i = 0; i < 32; i++) {
								world.spawnEntityInWorld(new EntityBullet(world, player, MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()), hurtTime[stack.getItemDamage()], NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()));
							}
						} else {
							world.spawnEntityInWorld(new EntityBullet(world, player, MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()), hurtTime[stack.getItemDamage()], NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()));
						}
					}
				}
			}
		}
		return stack;
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean f3) { //idk what i'm doing anymore
		if (stack.getItemDamage() != 3 && stack.getItemDamage() != 6) {
			list.add(LH.Chat.BLINKING_RED + "This gun has been deprecated!");
		}
		list.add(tooltips[stack.getItemDamage()]);
		if (!f3){
			list.add("Use F3+H for more info");
			list.add(MatHelpers.getDamageSimpleString(NBTUtils.NBTGetInteger(stack, "health"), maxHealth[stack.getItemDamage()]));
		} else {
			if (!(NBTUtils.NBTGetInteger(stack, "matID") == 0)) {
				list.add("Ammo remaining: " + NBTUtils.NBTGetInteger(stack, "ammo"));
				if (stack.getItemDamage() == 3)
					list.add("Current Damage: " + MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()) / 2.0F + " Hearts * 8 bullets");
				else if (stack.getItemDamage() == 5)
					list.add("Current Damage: " + MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()) / 2.0F + " Hearts * 4 bullets");
				else if (stack.getItemDamage() == 6)
					list.add("Current Damage: " + MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()) / 2.0F + " Hearts * 32 bullets");
				else
					list.add("Current Damage: " + MatHelpers.getDamageFromMaterial(NBTUtils.NBTGetInteger(stack, "matID"), stack.getItemDamage()) / 2.0F + " Hearts");

					list.add("Ammo Material: " + OreDictMaterial.MATERIAL_ARRAY[NBTUtils.NBTGetInteger(stack, "matID")].mNameLocal);
				}
				list.add("Current Health: " + NBTUtils.NBTGetInteger(stack, "health") + " / " + maxHealth[stack.getItemDamage()] + " (" + (int)((NBTUtils.NBTGetInteger(stack, "health") / (float) maxHealth[stack.getItemDamage()])*100)+"%" +")");
			}
		}

}
