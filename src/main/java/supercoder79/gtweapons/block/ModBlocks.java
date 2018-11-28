package supercoder79.gtweapons.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import supercoder79.gtweapons.block.blocks.BlockTurret;

public class ModBlocks {
    public static Block turret;

    public static void init() {
        GameRegistry.registerBlock(turret = new BlockTurret(), "turret");
    }
}
