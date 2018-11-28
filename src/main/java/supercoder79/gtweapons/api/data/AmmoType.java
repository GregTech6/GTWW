package supercoder79.gtweapons.api.data;

public enum AmmoType {
    //Guns that use magazines
    LowMagazine("gtweaponsMagazineLC"),
    MedMagazine("gtweaponsMagazineMC"),
    HighMagazine("gtweaponsMagazineHC"),
    //guns that use plain bullets
    LowAmmo("bulletGtSmall"),
    MedAmmo("bulletGtMedium"),
    HighAmmo("bulletGtLarge"),
    //Shotgun ammo
    BlunderbussShot("gtweaponsMagazineLC"),
    ShotgunShells("WIP"),
    //other ammo types
    PowerCell("WIP"),
    PlasmaCell("WIP");

    public String name;

    AmmoType(String name) {
        this.name = name;
    }
}
