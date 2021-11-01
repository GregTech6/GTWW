package supercoder79.gtweapons.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import supercoder79.gtweapons.item.items.*;

public class ModItems {
	public static Item gun;
	public static Item unlockableGun;
	public static Item container;
	public static Item scissors;
	public static Item pvpPotion;
	public static Item grenade;
	public static Item ejectedBullet;

	public static void init() {
		GameRegistry.registerItem(gun = new ItemGun("gun"), "gun");
		GameRegistry.registerItem(container = new ItemContainer("container"), "container");
		GameRegistry.registerItem(scissors = new ItemScissors("scissors"), "scissors");
		GameRegistry.registerItem(pvpPotion = new ItemPVPPotion(), "pvp_potion");
		GameRegistry.registerItem(grenade = new ItemGrenade(), "grenade");
		GameRegistry.registerItem(ejectedBullet = new ItemEjectedBullet(), "ejected_bullet");
		GameRegistry.registerItem(unlockableGun = new ItemUnlockableGun("unlockable_gun"), "unlockable_gun");
	}
}
