package supercoder79.gtweapons.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import supercoder79.gtweapons.block.blocks.BlockSpawner;
import supercoder79.gtweapons.block.blocks.BlockTurret;

import java.util.ArrayList;

public class ModBlocks {
    public static ArrayList<BlockTurret> teslas = new ArrayList<>();
    public static ArrayList<BlockSpawner> spawners = new ArrayList<>();
    public static void init() {
        teslas.add(0, new BlockTurret(0));
        teslas.add(1, new BlockTurret(1));
        teslas.add(2, new BlockTurret(2));
        teslas.add(3, new BlockTurret(3));
        GameRegistry.registerBlock(teslas.get(0), "tesla_0");
        GameRegistry.registerBlock(teslas.get(1), "tesla_1");
        GameRegistry.registerBlock(teslas.get(2), "tesla_2");
        GameRegistry.registerBlock(teslas.get(3), "tesla_3");
        spawners.add(0, new BlockSpawner(0));
        spawners.add(0, new BlockSpawner(1));
        spawners.add(0, new BlockSpawner(2));
        spawners.add(0, new BlockSpawner(3));
        spawners.add(0, new BlockSpawner(4));
        spawners.add(0, new BlockSpawner(5));
        GameRegistry.registerBlock(spawners.get(0), "spawner_0");
        GameRegistry.registerBlock(spawners.get(1), "spawner_1");
        GameRegistry.registerBlock(spawners.get(2), "spawner_2");
        GameRegistry.registerBlock(spawners.get(3), "spawner_3");
        GameRegistry.registerBlock(spawners.get(4), "spawner_4");
        GameRegistry.registerBlock(spawners.get(5), "spawner_5");
    }
}
