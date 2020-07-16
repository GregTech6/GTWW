package supercoder79.gtweapons.item.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.api.NBTUtils;
import supercoder79.gtweapons.entity.entities.EntityGrenade;

import java.util.List;

public class ItemGrenade extends Item {
    public static final int GRENADE_NUMBER = 3;
    public IIcon[] icons = new IIcon[GRENADE_NUMBER];
    public ItemGrenade() {
        super();
        this.setHasSubtypes(true);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("grenade");
        this.setCreativeTab(CreativeTabs.tabCombat);
        for (int i = 0; i < GRENADE_NUMBER; i ++) {
            this.setTextureName("grenade" + "_" + i);

        }
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < GRENADE_NUMBER; i ++) {
            this.icons[i] = reg.registerIcon(GregTechWeaponWorks.MOD_ID + ":throwable/" + i);
        }
    }
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List lst) {
        @SuppressWarnings("unchecked") List<ItemStack> list = (List<ItemStack>)lst;
        for (int i = 0; i < GRENADE_NUMBER; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta > GRENADE_NUMBER) {
            meta = 0;
        }
        return this.icons[meta];
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.getTotalWorldTime() >= NBTUtils.NBTGetLong(stack,"worldDelta")) {
            if (!world.isRemote) {
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
                player.inventoryContainer.detectAndSendChanges();
                world.spawnEntityInWorld(new EntityGrenade(world, player, stack.getItemDamage()));
                NBTUtils.NBTSetLong(stack, "worldDelta", world.getTotalWorldTime() + 10);
            }
        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lst, boolean f3) {
        @SuppressWarnings("unchecked") List<String> list = (List<String>)lst;
        list.add("Right click to throw.");
        switch (stack.getItemDamage()) {
            case 0:
                list.add("Explosion does not break blocks.");
                break;
            case 1:
                list.add("Explosion will break blocks!");
                break;
            case 2:
                list.add("Explosion is very powerful and places fire everywhere!");
                list.add("For your pyromaniac desires.");
                break;
        }
    }
}
