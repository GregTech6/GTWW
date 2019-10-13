package supercoder79.gtweapons.api.data.gun;

public enum AmmoType {
    //Guns that use magazines
    LowMagazine("gtweaponsMagazineLC", 0),
    MedMagazine("gtweaponsMagazineMC", 1),
    HighMagazine("gtweaponsMagazineHC", 2),
    //guns that use plain bullets
    LowAmmo("bulletGtSmall", 0),
    MedAmmo("bulletGtMedium", 1),
    HighAmmo("bulletGtLarge", 2),
    //Shotgun ammo
    BlunderbussShot("gtweaponsMagazineSG", 0), //0 is temporary
    ShotgunShells("WIP", 0),
    //other ammo types
    PowerCell("WIP", 0),
    PlasmaCell("WIP", 0);

    public String name;
    public int meta; //meta of ejected bullet

    AmmoType(String name, int meta) {
        this.name = name;
        this.meta = meta;
    }
}
