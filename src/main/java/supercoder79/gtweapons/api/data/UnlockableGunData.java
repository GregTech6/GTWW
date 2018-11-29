package supercoder79.gtweapons.api.data;

import java.util.HashMap;
import java.util.Map;

public class UnlockableGunData {
    public static Map<Integer, GunData> data = new HashMap<Integer, GunData>();

    static {
        data.put(0, new GunData("Cyclone", GunType.SMG, Rarity.SuperRare, AmmoType.LowMagazine, 8, new int[]{2, 6}, 6, 800, 0.2, 6.0f, false));
        data.put(1, new GunData("Tsunami", GunType.SMG, Rarity.Legendary, AmmoType.LowMagazine, 8, new int[]{4, 8}, 2, 1200, 0.3, 8.0f, false));
        data.put(2, new GunData("Quickshot", GunType.Rifle, Rarity.Rare, AmmoType.MedMagazine, 8, new int[]{6, 14}, 10, 1000, 0.1, 7.5f, false));
        data.put(3, new GunData("Old Faithful", GunType.Rifle, Rarity.SuperRare, AmmoType.MedMagazine, 8, new int[]{12, 20}, 16, 600, 0.06, 9.0f, false));
        data.put(4, new GunData("Revolver", GunType.Pistol, Rarity.Common, AmmoType.LowAmmo, 6, new int[]{8, 14}, 12, 300, 0.15, 4.5f, true));
        data.put(5, new GunData("Hunting Rifle", GunType.Sniper, Rarity.Uncommon, AmmoType.HighAmmo, 1, new int[]{16, 24}, 22, 250, 0.02, 12.0f, true));
    }
}
