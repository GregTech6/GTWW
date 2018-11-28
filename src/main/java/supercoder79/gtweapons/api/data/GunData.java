package supercoder79.gtweapons.api.data;

public class GunData {
    public int[] damage;
    public int fireRate;
    public int durability;
    public double bulletSpread;
    public float bulletSpeed;
    public boolean craftable;
    public String name;
    public String sound;
    public GunType type;
    public Rarity rarity;
    public AmmoType ammo;

    public GunData( String name, GunType type, Rarity rarity, AmmoType ammo, int[] damage, int fireRate, int durability, double bulletSpread, float bulletSpeed, boolean craftable) {
        this.damage = damage;
        this.fireRate = fireRate;
        this.durability = durability;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.ammo = ammo;
        this.bulletSpread = bulletSpread;
        this.bulletSpeed = bulletSpeed;
        this.craftable = craftable;

        switch (type) {
            case Pistol:
                sound = "gtweapons:pistol";
                break;
            case SMG:
                sound = "gtweapons:smg";
                break;
            case Sniper:
                sound = "gtweapons:sniper";
                break;
            case Shotgun:
                sound = "gtweapons:blunderbuss";
                break;
            case Rifle:
                sound = "gtweapons:ar";
                break;
            case BurstRiffle4:
                sound = "gtweapons:burst";
                break;
        }
    }
}
