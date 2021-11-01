package supercoder79.gtweapons.item.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.util.UT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.api.NBTUtils;
import supercoder79.gtweapons.api.damage.DamageSourceScissors;

import java.util.ArrayList;
import java.util.List;

public class ItemScissors extends Item {
	static final int SCISSOR_NUMBER = 4;
	public static int[] maxHealth = {300, 250, 800, 1};
	public IIcon[] icons = new IIcon[SCISSOR_NUMBER];
	public ArrayList textures = new ArrayList();

	public ItemScissors(String unlocalisedName) {
		super();
		this.setHasSubtypes(true);
		this.setUnlocalizedName(unlocalisedName);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);

		for (int i = 0; i < SCISSOR_NUMBER; i++) {
			this.setTextureName(unlocalisedName + "_" + i);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister reg) {
		for (int i = 0; i < SCISSOR_NUMBER; i++) {
			this.icons[i] = reg.registerIcon(GregTechWeaponWorks.MOD_ID + ":melee/" + i);
		}
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List lst) {
		@SuppressWarnings("unchecked") List<ItemStack> list = (List<ItemStack>) lst;
		for (int i = 0; i < SCISSOR_NUMBER; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > SCISSOR_NUMBER) {
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
		if (stack.getItemDamage() == 2) {
			if (!NBTUtils.NBTGetBoolean(stack, "wound")) {
				NBTUtils.NBTSetBoolean(stack, "wound", true);
				UT.Sounds.send("gtweapons:reload", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
			}
		}
		return stack;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		int num = stack.getItemDamage();
		if (NBTUtils.NBTGetInteger(stack, "health") <= 0) {
			NBTUtils.NBTSetInteger(stack, "health", maxHealth[stack.getItemDamage()]);
		}
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			switch (num) {
				case 0:
					entityLivingBase.attackEntityFrom(new DamageSourceScissors(player), 5.0F);
					NBTUtils.NBTSetInteger(stack, "health", NBTUtils.NBTGetInteger(stack, "health") - 1);
					break;
				case 1:
					entityLivingBase.attackEntityFrom(new DamageSourceScissors(player), 4.0F);
					NBTUtils.NBTSetInteger(stack, "health", NBTUtils.NBTGetInteger(stack, "health") - 1);
					break;
				case 2:
					if (NBTUtils.NBTGetBoolean(stack, "wound"))
						entityLivingBase.attackEntityFrom(new DamageSourceScissors(player), 10.0F);
					else entityLivingBase.attackEntityFrom(new DamageSourceScissors(player), 4.0F);
					NBTUtils.NBTSetBoolean(stack, "wound", false);
					NBTUtils.NBTSetInteger(stack, "health", NBTUtils.NBTGetInteger(stack, "health") - 1);

					break;
				case 3:
					if (entityLivingBase instanceof EntityPlayer) {
						if (((EntityPlayer) entityLivingBase).getDisplayName().startsWith("SuperCoder79")) {
							entityLivingBase.attackEntityFrom(new DamageSourceScissors(player), 79.0F * 2);
							NBTUtils.NBTSetInteger(stack, "health", NBTUtils.NBTGetInteger(stack, "health") - 1);
						}
						player.setCurrentItemOrArmor(0, null);
						return false;
					}
					break;
			}
			if (NBTUtils.NBTGetInteger(stack, "health") == 0) {
				player.setCurrentItemOrArmor(0, null);
				return false;
			}
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lst, boolean f3) {
		@SuppressWarnings("unchecked") List<String> list = (List<String>) lst;
		int num = stack.getItemDamage();
		switch (num) {
			case 0:
				list.add("Attack a mob to do 5 damage");
				break;
			case 1:
				list.add("Attack a mob to do 4 damage");
				break;
			case 2:
				list.add("Right click to wind the spring to do more damage");
				list.add("Does 4 damage unwound and 10 wound");
				break;
			case 3:
				list.add("Tired of your e-nets being broken by pesky SuperCoders? Hit SuperCoder with this and he will be very sorry.");
				list.add("Does 79 damage to SuperCoder, but no damage otherwise");
				break;
		}
		list.add("Current health: " + NBTUtils.NBTGetInteger(stack, "health"));
	}
}
