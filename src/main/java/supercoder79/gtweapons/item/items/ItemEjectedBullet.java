package supercoder79.gtweapons.item.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import supercoder79.gtweapons.GregTechWeaponWorks;

import java.util.List;

public class ItemEjectedBullet extends Item {
	public static final int BULLET_NUMBER = 3;
	public IIcon[] icons = new IIcon[BULLET_NUMBER];

	public ItemEjectedBullet() {
		super();
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("bullet");
		this.setCreativeTab(CreativeTabs.tabCombat);
		for (int i = 0; i < BULLET_NUMBER; i++) {
			this.setTextureName("bullet" + "_" + i);

		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister reg) {
		for (int i = 0; i < BULLET_NUMBER; i++) {
			this.icons[i] = reg.registerIcon(GregTechWeaponWorks.MOD_ID + ":bullets/" + i);
		}
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List lst) {
		@SuppressWarnings("unchecked") List<ItemStack> list = (List<ItemStack>) lst;
		for (int i = 0; i < BULLET_NUMBER; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > BULLET_NUMBER) {
			meta = 0;
		}
		return this.icons[meta];
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lst, boolean f3) {
		@SuppressWarnings("unchecked") List<String> list = (List<String>) lst;
		list.add("Refill this used bullet with gunpowder!");
	}
}
