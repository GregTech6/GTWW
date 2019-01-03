package supercoder79.gtweapons.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import supercoder79.gtweapons.block.blocks.BlockTurret;

import java.util.ArrayList;

public class ModBlocks {
    public static ArrayList<BlockTurret> teslas = new ArrayList<>();
    public static void init() {
        teslas.add(0, new BlockTurret(0));
        teslas.add(1, new BlockTurret(1));
        teslas.add(2, new BlockTurret(2));
        teslas.add(3, new BlockTurret(3));
        GameRegistry.registerBlock(teslas.get(0), "tesla_0");
        GameRegistry.registerBlock(teslas.get(1), "tesla_1");
        GameRegistry.registerBlock(teslas.get(2), "tesla_2");
        GameRegistry.registerBlock(teslas.get(3), "tesla_3");

    }
}
