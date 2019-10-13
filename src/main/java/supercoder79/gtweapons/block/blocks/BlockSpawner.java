package supercoder79.gtweapons.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.tile.tiles.TileSpawner;

public class BlockSpawner extends Block implements ITileEntityProvider {
    public int tier;
    public BlockSpawner(int tier) {
        super(Material.iron);
        this.setBlockName("spawner_"+tier);
        this.setBlockTextureName(GregTechWeaponWorks.MOD_ID+":spawner/spawner_"+tier);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setHardness(2.5f);
        this.setResistance(4);
        this.tier = tier;
    }
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileSpawner(this.tier);
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        /*
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof TileSpawner) {
            TileSpawner spawner = (TileSpawner)te;
            spawner.rightClicked(world, x, y, z, player);
        }
        */
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof TileSpawner) {
            TileSpawner spawner = (TileSpawner)te;
            spawner.rightClicked(world, x, y, z, player);
        }
        return true;
    }
}
