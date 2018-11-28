package supercoder79.gtweapons.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.tile.tiles.TileTurret;

public class BlockTurret extends Block implements ITileEntityProvider {
    public BlockTurret() {
        super(Material.iron);
        this.setBlockName("turret");
        this.setBlockTextureName(GregTechWeaponWorks.MOD_ID+":turret");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(10);
        this.setResistance(30);
    }

//    @Override
//    public TileEntity createTileEntity(World world, int metadata) {
//        return new TileTurret();
//    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileTurret();
    }
}
