package supercoder79.gtweapons.block.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.tile.tiles.TileTurret;

import java.util.List;

public class BlockTurret extends Block implements ITileEntityProvider {
    public int tier;

    public BlockTurret(int tier) {
        super(Material.iron);
        this.setBlockName("tesla_"+tier);
        this.setBlockTextureName(GregTechWeaponWorks.MOD_ID+":tesla_"+tier);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(7);
        this.setResistance(5);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
//        System.out.println(tier);
        //fuck this shit i'm out
        return new TileTurret(tier);
    }
}
