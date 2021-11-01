package supercoder79.gtweapons.api.data.gun;

public class GunData {
	public int[] damage;
	public int fireRate;
	public int durability;
	public int ammoAmt; //total ammo capacity
	public int useAmt; //how much ammo each reload uses
	public double bulletSpread;
	public float bulletSpeed;
	public boolean craftable;
	public String name;
	public String sound;
	public GunType type;
	public Rarity rarity;
	public AmmoType ammo;
	public GunManufacturer manufacturer;

	public GunData(String name, GunType type, String sound, Rarity rarity, GunManufacturer manufacturer, AmmoType ammo, int ammoAmt, int useFromInvAmt, int[] damage, int fireRate, int durability, double bulletSpread, float bulletSpeed, boolean craftable) {
		this.damage = damage;
		this.fireRate = fireRate;
		this.durability = durability;
		this.name = name;
		this.type = type;
		this.rarity = rarity;
		this.ammo = ammo;
		this.manufacturer = manufacturer;
		this.bulletSpread = bulletSpread;
		this.bulletSpeed = bulletSpeed;
		this.craftable = craftable;
		this.ammoAmt = ammoAmt;
		this.useAmt = useFromInvAmt;
		this.sound = sound;
	}
}
