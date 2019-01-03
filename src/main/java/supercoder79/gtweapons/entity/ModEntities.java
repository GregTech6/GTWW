package supercoder79.gtweapons.entity;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.data.MT;
import gregapi.data.OP;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import supercoder79.gtweapons.GregTechWeaponWorks;
import supercoder79.gtweapons.api.render.RenderBullet;
import supercoder79.gtweapons.entity.entities.EntityBullet;
import supercoder79.gtweapons.entity.entities.EntityGrenade;
import supercoder79.gtweapons.item.ModItems;

/**
 * @author SuperCoder79.
 */
public class ModEntities {

    public static void init(){
        EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 0, GregTechWeaponWorks.INSTANCE, 64, 10, true);
        EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 1, GregTechWeaponWorks.INSTANCE, 64, 10, true);
    }

    @SideOnly(Side.CLIENT)
    public static void render(){
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet(OP.round.mat(MT.Steel, 1).getItem())); //<- Man, GT5u breaks everything...
        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(new ItemStack(ModItems.grenade, 1).getItem()));
    }
}
