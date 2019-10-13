package supercoder79.gtweapons.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import supercoder79.gtweapons.tile.tiles.TileSpawner;
import supercoder79.gtweapons.tile.tiles.TileTurret;

public class ModTiles {
    public static void init(){
        GameRegistry.registerTileEntity(TileTurret.class, "tileturret");
        GameRegistry.registerTileEntity(TileSpawner.class, "tilespawner");
    }
}
