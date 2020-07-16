package supercoder79.gtweapons.api.data.gun;

import java.util.HashMap;
import java.util.Map;

public class UnlockableGunData {
    public static Map<Integer, GunData> data = new HashMap<>();

    public static final String PISTOL = "gtweapons:pistol";
    public static final String AR = "gtweapons:ar";
    public static final String SMG = "gtweapons:smg";
    public static final String SNIPER = "gtweapons:sniper";
    public static final String HEAVYPISTOL = "gtweapons:heavypistol";
    public static final String MINIGUN = "gtweapons:speedshot";
    public static final String SILENCED = "gtweapons:silenced";
    public static final String HEAVYAR = "gtweapons:heavyar";


    static {
        data.put(0, new GunData("Cyclone", GunType.SMG, SMG, Rarity.SuperRare, GunManufacturer.ST, AmmoType.LowMagazine, 8, 1, new int[]{2, 6}, 6, 800, 0.2, 6.0f, false));
        data.put(1, new GunData("Tsunami", GunType.SMG, SMG, Rarity.Legendary, GunManufacturer.ST, AmmoType.LowMagazine, 8, 1, new int[]{4, 8}, 2, 1200, 0.3, 8.0f, false));
        data.put(2, new GunData("Quickshot", GunType.Rifle, AR, Rarity.Rare, GunManufacturer.ST, AmmoType.MedMagazine, 8, 1, new int[]{6, 14}, 10, 750, 0.1, 7.5f, false));
        data.put(3, new GunData("Old Faithful", GunType.Rifle, AR, Rarity.SuperRare, GunManufacturer.ST, AmmoType.MedMagazine, 8, 1, new int[]{12, 20}, 16, 600, 0.06, 9.0f, false));
        data.put(4, new GunData("Basic Revolver", GunType.Pistol, PISTOL, Rarity.Common, GunManufacturer.NONE, AmmoType.LowAmmo, 6, 6, new int[]{8, 14}, 12, 200, 0.15, 4.5f, true));
        data.put(5, new GunData("Hunting Rifle", GunType.Sniper, SNIPER, Rarity.Common, GunManufacturer.NONE, AmmoType.HighAmmo, 1, 1, new int[]{16, 24}, 40, 150, 0.02, 18.0f, true));
        data.put(6, new GunData("Handmade Rifle", GunType.Rifle, AR, Rarity.Common, GunManufacturer.NONE, AmmoType.MedAmmo, 8, 8, new int[]{6, 14}, 14, 250, 0.1, 6.f, true));
        data.put(7, new GunData("Nocturnal Assault Rifle", GunType.Rifle, AR, Rarity.Legendary, GunManufacturer.UNKNOWN, AmmoType.MedMagazine, 8, 1, new int[]{14, 20}, 8, 1000, 0.1, 8.f, false));
        data.put(8, new GunData("Heartshatter", GunType.Pistol, PISTOL, Rarity.Legendary, GunManufacturer.UNKNOWN, AmmoType.LowMagazine, 8, 1, new int[]{12, 24}, 10, 1500, 0.1, 8.f, false));
        data.put(9, new GunData("Basic Submachine Gun", GunType.SMG, SMG, Rarity.Common, GunManufacturer.NONE, AmmoType.LowAmmo, 8, 8, new int[]{4, 9}, 8, 300, 0.15, 5.f, true));
        data.put(10, new GunData("Greg Army Pistol", GunType.Pistol, SMG, Rarity.Legendary, GunManufacturer.GTI, AmmoType.LowMagazine, 8, 1, new int[]{12, 16}, 8, 800, 0.1, 8.f, false));
        data.put(11, new GunData("Silenced Pistol", GunType.Pistol, SILENCED, Rarity.SuperRare, GunManufacturer.KBI, AmmoType.LowMagazine, 8, 1, new int[]{8, 12}, 9, 600, 0.15, 6.f, false));
        data.put(12, new GunData("Silenced Submachine Gun", GunType.SMG, SILENCED, Rarity.SuperRare, GunManufacturer.KBI, AmmoType.LowMagazine, 8, 1, new int[]{5, 8}, 6, 750, 0.25, 6.f, false));
        data.put(13, new GunData("Silenced Rifle", GunType.Rifle, SILENCED, Rarity.SuperRare, GunManufacturer.KBI, AmmoType.MedMagazine, 8, 1, new int[]{6, 12}, 12, 650, 0.1, 8.f, false));
        data.put(14, new GunData("Greg Army Sniper", GunType.Sniper, SNIPER, Rarity.Legendary, GunManufacturer.GTI, AmmoType.HighMagazine, 8, 1, new int[]{20, 32}, 30, 600, 0.03, 72.f, false));
        data.put(15, new GunData("Greg Army Sniper (Scoped)", GunType.Sniper, SNIPER, Rarity.Legendary, GunManufacturer.GTI, AmmoType.HighMagazine, 8, 1, new int[]{20, 32}, 30, 650, 0, 72.f, false));
        data.put(16, new GunData("Prototype Greg Army Assault Rifle v0.6.9", GunType.Rifle, HEAVYAR, Rarity.SuperRare, GunManufacturer.GTI, AmmoType.MedMagazine, 8, 1, new int[]{12, 16}, 14, 500, 0.15, 8.f, false));
        data.put(17, new GunData("Destroyer Of Worlds", GunType.SMG, MINIGUN, Rarity.Legendary, GunManufacturer.GTI, AmmoType.LowAmmo, 64, 64, new int[]{4, 6}, 3, 1200, 0.35, 8.f, false));
        data.put(18, new GunData("Advanced Submachine Gun", GunType.SMG, SMG, Rarity.Rare, GunManufacturer.ST, AmmoType.LowMagazine, 8, 1, new int[]{5, 11}, 7, 700, 0.125, 6.5f, false));
        data.put(19, new GunData("Advanced Revolver", GunType.Pistol, PISTOL, Rarity.Rare, GunManufacturer.ST, AmmoType.LowMagazine, 8, 1, new int[]{12, 16}, 14, 400, 0.1, 6.f, false));
        data.put(20, new GunData("Advanced Sniper", GunType.Sniper, SNIPER, Rarity.Rare, GunManufacturer.ST, AmmoType.HighMagazine, 8, 1, new int[]{18, 26}, 35, 400, 0.02, 20.f, false));
        data.put(21, new GunData("Advanced Assault Rifle", GunType.Rifle, AR, Rarity.Rare, GunManufacturer.ST, AmmoType.MedMagazine, 8, 1, new int[]{10, 16}, 12, 500, 0.1, 10.f, false));
        data.put(22, new GunData("Intricate Sniper", GunType.Sniper, SNIPER, Rarity.SuperRare, GunManufacturer.ST, AmmoType.HighMagazine, 8, 1, new int[]{18, 28}, 30, 600, 0.01, 22.f, false));
        data.put(23, new GunData("Intricate Pistol", GunType.Pistol, PISTOL, Rarity.SuperRare, GunManufacturer.ST, AmmoType.LowMagazine, 8, 1, new int[]{14, 18}, 12, 600, 0.1, 7.f, false));
        data.put(24, new GunData("Intricate Assault Rifle", GunType.Rifle, HEAVYAR, Rarity.SuperRare, GunManufacturer.ST, AmmoType.MedMagazine, 8, 1, new int[]{10, 16}, 11, 700, 0.075, 11.f, false));
        data.put(25, new GunData("Intricate Submachine Gun", GunType.SMG, SMG, Rarity.SuperRare, GunManufacturer.ST, AmmoType.LowMagazine, 8, 1, new int[]{7, 13}, 6, 800, 0.11, 7.5f, false));
        data.put(26, new GunData("Savanna Eagle", GunType.Pistol, HEAVYPISTOL, Rarity.SuperRare, GunManufacturer.ST, AmmoType.HighMagazine, 8, 1, new int[]{14, 20}, 18, 500, 0.05, 15.f, false));
        data.put(27, new GunData("Improved Rifle", GunType.Rifle, AR, Rarity.Uncommon, GunManufacturer.NONE, AmmoType.MedMagazine, 8, 1, new int[]{8, 16}, 13, 350, 0.075, 7.f, true));
        data.put(28, new GunData("Ender Assault Rifle", GunType.Rifle, AR, Rarity.SuperRare, GunManufacturer.UNKNOWN, AmmoType.MedMagazine, 8, 1, new int[]{12, 16}, 12, 450, 0.075, 60.f, false));
        data.put(29, new GunData("Improved Pistol", GunType.Pistol, PISTOL, Rarity.Uncommon, GunManufacturer.UNKNOWN, AmmoType.LowMagazine, 8, 1, new int[]{8, 12}, 10, 400, 0.1, 7.f, true));
    }

    //patches:
    //Hunting Rifle Rarity: Uncommon -> Common
    //Hunting Rifle Durability: 250 -> 150
    //Hunting Rifle Fire Rate: 1.1s -> 2s
    //Quickshot Durability: 1000 -> 750
    //Revolver Durability: 300 -> 200
}
