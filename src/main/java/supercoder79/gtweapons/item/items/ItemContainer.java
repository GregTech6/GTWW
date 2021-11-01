package supercoder79.gtweapons.item.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import supercoder79.gtweapons.GregTechWeaponWorks;

import java.util.ArrayList;
import java.util.List;


/**
 * @author SuperCoder79.
 */


public class ItemContainer extends Item {
	/*
	 * 0 = magazine casing
	 * 1 = shotgun shell
	 */
	static final int CONTAINER_NUMBER = 2;
	public IIcon[] icons = new IIcon[CONTAINER_NUMBER];
	public ArrayList textures = new ArrayList();

	public ItemContainer(String unlocalisedName) {
		super();
		this.setHasSubtypes(true);
		this.setUnlocalizedName(unlocalisedName);

		for (int i = 0; i < CONTAINER_NUMBER; i++) {
			this.setTextureName(unlocalisedName + "_" + i);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister reg) {
		for (int i = 0; i < CONTAINER_NUMBER; i++) {
			this.icons[i] = reg.registerIcon(GregTechWeaponWorks.MOD_ID + ":containers/" + i);
		}
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List lst) {
		@SuppressWarnings("unchecked") List<ItemStack> list = (List<ItemStack>) lst;
		for (int i = 0; i < CONTAINER_NUMBER; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > CONTAINER_NUMBER) {
			meta = 0;
		}
		return this.icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

}
