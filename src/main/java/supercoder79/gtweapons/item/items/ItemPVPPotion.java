package supercoder79.gtweapons.item.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;

import java.util.List;


public class ItemPVPPotion extends Item {
    public ItemPVPPotion() {
        super();
        this.setUnlocalizedName("pvp_potion");
        this.setCreativeTab(CreativeTabs.tabBrewing);
        this.setTextureName(GregTechWeaponWorks.MOD_ID+":consumable/pvp_potion");
    }
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(21, 72000, 24));
        player.addPotionEffect(new PotionEffect(6, 7, 9));
        player.addPotionEffect(new PotionEffect(23, 72000, 5));
        stack.stackSize--;
        return stack;
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean f3) {
        list.add("Creative only item!");
        list.add("Changes max health to 50 hearts instead of 10.");
        list.add("Makes you invulnerable for 10 seconds after drinking.");
        list.add("Stops your hunger from depleting.");
    }
}