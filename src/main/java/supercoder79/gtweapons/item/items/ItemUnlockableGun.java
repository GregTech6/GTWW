package supercoder79.gtweapons.item.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.data.LH;
import gregapi.util.UT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.api.NBTUtils;
import supercoder79.gtweapons.api.config.ConfigHandler;
import supercoder79.gtweapons.api.data.GunData;
import supercoder79.gtweapons.api.data.PerkUtils;
import supercoder79.gtweapons.api.data.UnlockableGunData;
import supercoder79.gtweapons.entity.entities.EntityBullet;
import supercoder79.gtweapons.entity.entities.EntityBulletUnlockable;

import java.util.List;

public class ItemUnlockableGun extends Item {
    public static final int GUN_NUMBER = UnlockableGunData.data.size();
    public IIcon[] icons = new IIcon[GUN_NUMBER];

    public ItemUnlockableGun(String unlocalisedName){
        super();
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(unlocalisedName);
        this.setCreativeTab(CreativeTabs.tabCombat);

        for (int i = 0; i < GUN_NUMBER; i ++) {
            this.setTextureName(unlocalisedName + "_" + i);

        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < GUN_NUMBER; i ++) {
            this.icons[i] = reg.registerIcon(GregTechWeaponWorks.MOD_ID + ":guns/unlockable/" + i);
        }
    }
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < GUN_NUMBER; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta > GUN_NUMBER) {
            meta = 0;
        }
        return this.icons[meta];
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }

    //Attempt 2: make this not shit
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        GunData data = UnlockableGunData.data.get(stack.getItemDamage());
        if (!world.isRemote) { //check if this is server side
            if (NBTUtils.NBTGetInteger(stack, "health") <= 0) {//if nbt hasn't been set yet
//                System.out.println("Test " + data.name);
                //perk creator
                //common: 35%
                //uncommon: 30%
                //rare: 20%
                //super rare: 10%
                //legendary: 5%
                //Perks:
                //Fire rate
                //Damage
                //durability
                //magazine size

                float durabilityExtra = 1f;
                int perkAmt = (int)Math.floor(Math.random() * 3) + 2;
                String perks = "";
                for (int i = 0; i < perkAmt; i++) {
                    int rarity = (int)Math.floor(Math.random() * 20);
                    if (rarity < 7) {
                        //common
                        perks += data.craftable ? "c_" : "u_";
                        int perk = (int)Math.floor(Math.random() * 5);
                        switch (perk) {
                            case 0:
                                perks += "fr";
                                break;
                            case 1:
                                perks += "dm";
                                break;
                            case 2:
                                perks += "db";
                                durabilityExtra += 0.15f;
                                break;
                            case 3:
                                perks += "ms";
                                break;
                            case 4:
                                perks += "bullet-spread";
                                break;
                        }
                    } else if (rarity < 13) {
                        //uncommon
                        perks += data.craftable ? "u_" : "r_";
                        int perk = (int)Math.floor(Math.random() * 5);
                        switch (perk) {
                            case 0:
                                perks += "fr";
                                break;
                            case 1:
                                perks += "dm";
                                break;
                            case 2:
                                perks += "db";
                                durabilityExtra += 0.25f;
                                break;
                            case 3:
                                perks += "ms";
                                break;
                            case 4:
                                perks += "bs";
                                break;
                        }
                    } else if (rarity < 17) {
                        //rare
                        perks += data.craftable ? "r_" : "s_";
                        int perk = (int)Math.floor(Math.random() * 5);
                        switch (perk) {
                            case 0:
                                perks += "fr";
                                break;
                            case 1:
                                perks += "dm";
                                break;
                            case 2:
                                perks += "db";
                                durabilityExtra+= 0.25f;
                                break;
                            case 3:
                                perks += "ms";
                                break;
                            case 4:
                                perks += "bs";
                                break;
                        }
                    } else if (rarity < 19) {
                        //super rare
                        perks += data.craftable ? "s_" : "l_";
                        int perk = (int)Math.floor(Math.random() * 5);
                        switch (perk) {
                            case 0:
                                perks += "fr";
                                break;
                            case 1:
                                perks += "dm";
                                break;
                            case 2:
                                perks += "db";
                                durabilityExtra+= 0.30f;
                                break;
                            case 3:
                                perks += "ms";
                                break;
                            case 4:
                                perks += "bs";
                                break;
                        }
                    } else if (rarity < 20) {
                        //legendary
                        perks += "l_";
                        int perk = (int)Math.floor(Math.random() * 5);
                        switch (perk) {
                            case 0:
                                perks += "fr";
                                break;
                            case 1:
                                perks += "dm";
                                break;
                            case 2:
                                perks += "db";
                                durabilityExtra+= 0.50f;
                                break;
                            case 3:
                                perks += "ms";
                                break;
                            case 4:
                                perks += "bs";
                                break;
                        }
                    }
                    perks += ";";
                }
//                System.out.println(perks);

                NBTUtils.NBTSetString(stack, "perks", perks);
                NBTUtils.NBTSetInteger(stack, "health", (int)(data.durability*durabilityExtra));
                NBTUtils.NBTSetInteger(stack, "maxHealth", (int)(data.durability*durabilityExtra));
            } else {
                if (world.getWorldTime() >= NBTUtils.NBTGetLong(stack,"worldDelta")) { //if the gun cooldown has been finished
                    NBTUtils.NBTSetInteger(stack, "health", NBTUtils.NBTGetInteger(stack, "health") - 1);
                    if (NBTUtils.NBTGetInteger(stack, "health") <= 1) {
                        player.destroyCurrentEquippedItem();
                        return stack;
                    }
                    if (ConfigHandler.PlaySound) UT.Sounds.send(data.sound, 0.4F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), player);
                    world.spawnEntityInWorld(new EntityBullet(world, player, data, PerkUtils.getPerkList(NBTUtils.NBTGetString(stack, "perks"))));
                    List<List<String>> perks = PerkUtils.getPerkList(NBTUtils.NBTGetString(stack, "perks"));
                    float speedMultiplier = 1f;
                    for (List<String> list : perks) {
                        switch (list.get(0)) {
                            case "c":
                                switch (list.get(1)) {
                                    case "fr":
                                        speedMultiplier-=0.15f;
                                        break;
                                }
                                break;
                            case "u":
                                switch (list.get(1)) {
                                    case "fr":
                                        speedMultiplier-=0.2f;
                                        break;
                                }
                                break;
                            case "r":
                                switch (list.get(1)) {
                                    case "fr":
                                        speedMultiplier-=0.25f;
                                        break;
                                }
                                break;
                            case "s":
                                switch (list.get(1)) {
                                    case "fr":
                                        speedMultiplier-=0.3f;
                                        break;
                                }
                                break;
                            case "l":
                                switch (list.get(1)) {
                                    case "fr":
                                        speedMultiplier-=0.4f;
                                        break;
                                }
                                break;
                        }
                    }
                    if (speedMultiplier < 0.2f) speedMultiplier = 0.2f;
                    NBTUtils.NBTSetLong(stack, "worldDelta", world.getWorldTime() + (int)(data.fireRate*speedMultiplier));
                }
            }
        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean f3) {
        GunData data = UnlockableGunData.data.get(stack.getItemDamage());
        String name = data.rarity.color;
        switch (data.type) {
            case Pistol:
               name += "Pistol (" + data.rarity.name + ")" + LH.Chat.RESET;
                break;
            case SMG:
                name += "SMG (" + data.rarity.name + ")" + LH.Chat.RESET;
                break;
            case Sniper:
                name += "Sniper (" + data.rarity.name + ")" + LH.Chat.RESET;
                break;
            case Shotgun:
                name += "Shotgun (" + data.rarity.name + ")" + LH.Chat.RESET;
                break;
            case Rifle:
                name += "Assault Rifle (" + data.rarity.name + ")" + LH.Chat.RESET;
                break;
            case BurstRiffle4:
                name += "Burst Rifle (" + data.rarity.name + ")" + LH.Chat.RESET;
                break;
        }
        list.add(name);

        String perks = NBTUtils.NBTGetString(stack, "perks");
        if (!perks.isEmpty()) {
            list.add("Durability: " + NBTUtils.NBTGetInteger(stack, "health") + "/" + NBTUtils.NBTGetInteger(stack, "maxHealth"));
            List<List<String>> perkList = PerkUtils.getPerkList(perks);
            for (List<String> innerList : perkList) {
                String perkToAdd = "";
                String rarity = innerList.get(0);
                String perk = innerList.get(1);
                switch (rarity) {
                    case "c":
                        perkToAdd += LH.Chat.WHITE;
                        switch (perk) {
                            case "fr":
                                perkToAdd += "+ 15% Fire Rate";
                                break;
                            case "dm":
                                perkToAdd += "+ 10% Damage";
                                break;
                            case "db":
                                perkToAdd += "+ 15% Durability";
                                break;
                            case "ms":
                                perkToAdd += "+ 20% Magazine Size";
                                break;
                            case "bs":
                                perkToAdd += "- 20% Bullet Spread";
                                break;
                        }
                        if (f3) perkToAdd += " (Common)";
                        break;
                    case "u":
                        perkToAdd += LH.Chat.GREEN;
                        switch (perk) {
                            case "fr":
                                perkToAdd += "+ 20% Fire Rate";
                                break;
                            case "dm":
                                perkToAdd += "+ 15% Damage";
                                break;
                            case "db":
                                perkToAdd += "+ 20% Durability";
                                break;
                            case "ms":
                                perkToAdd += "+ 25% Magazine Size";
                                break;
                            case "bs":
                                perkToAdd += "- 25% Bullet Spread";
                                break;
                        }
                        if (f3) perkToAdd += " (Uncommon)";
                        break;
                    case "r":
                        perkToAdd += LH.Chat.BLUE;
                        switch (perk) {
                            case "fr":
                                perkToAdd += "+ 25% Fire Rate";
                                break;
                            case "dm":
                                perkToAdd += "+ 20% Damage";
                                break;
                            case "db":
                                perkToAdd += "+ 25% Durability";
                                break;
                            case "ms":
                                perkToAdd += "+ 35% Magazine Size";
                                break;
                            case "bs":
                                perkToAdd += "- 30% Bullet Spread";
                                break;
                        }
                        if (f3) perkToAdd += " (Rare)";
                        break;
                    case "s":
                        perkToAdd += LH.Chat.PURPLE;
                        switch (perk) {
                            case "fr":
                                perkToAdd += "+ 30% Fire Rate";
                                break;
                            case "dm":
                                perkToAdd += "+ 35% Damage";
                                break;
                            case "db":
                                perkToAdd += "+ 30% Durability";
                                break;
                            case "ms":
                                perkToAdd += "+ 50% Magazine Size";
                                break;
                            case "bs":
                                perkToAdd += "- 40% Bullet Spread";
                                break;
                        }
                        if (f3) perkToAdd += " (Super Rare)";
                        break;
                    case "l":
                        perkToAdd += LH.Chat.GOLD;
                        switch (perk) {
                            case "fr":
                                perkToAdd += "+ 40% Fire Rate";
                                break;
                            case "dm":
                                perkToAdd += "+ 45% Damage";
                                break;
                            case "db":
                                perkToAdd += "+ 50% Durability";
                                break;
                            case "ms":
                                perkToAdd += "+ 75% Magazine Size";
                                break;
                            case "bs":
                                perkToAdd += "- 55% Bullet Spread";
                                break;
                        }
                        if (f3) perkToAdd += " (Legendary)";
                        break;
                }
                perkToAdd += LH.Chat.RESET;
                list.add(perkToAdd);
            }
        } else {
            list.add("Right click once to generate gun info");
        }
    }
}
