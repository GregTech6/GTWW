package supercoder79.gtweapons.api.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.oredict.OreDictMaterial;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import supercoder79.gtweapons.entity.entities.EntityBullet;

/**
 * @author SuperCoder79.
 * This is mostly copied code from minecraft's shitty rendering system. (THANK YOU SO MUCH FOR MAKING YOUR FUNCTIONS PRIVATE)
 * Don't ask me how it works, I don't know.
 */
@SideOnly(Side.CLIENT)
public class RenderBullet extends Render {
    private Item field_94151_a;
    private int field_94150_f;
    private int material;
    public RenderBullet(Item item, int meta) {
        super();
        this.field_94151_a = item;
        this.field_94150_f = this.material = meta;
    }
    public RenderBullet(Item item) {
        super();
        this.field_94151_a = item;
    }

    @Override
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        EntityBullet bullet = (EntityBullet)p_76986_1_;
        IIcon iicon = this.field_94151_a.getIconFromDamage(bullet.getMaterial());

        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.bindEntityTexture(p_76986_1_);
            Tessellator tessellator = Tessellator.instance;
            //grab colors and color with render
            short[] colors = OreDictMaterial.MATERIAL_ARRAY[bullet.getMaterial()].fRGBaSolid;
            float red = colors[0] / 255.0F;
            float green = colors[1] / 255.0F;
            float blue = colors[2] / 255.0F;
            GL11.glColor3f(red, blue, green);
            this.func_77026_a(tessellator, iicon);
            // finish coloring
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return TextureMap.locationItemsTexture;
    }

    private void func_77026_a(Tessellator p_77026_1_, IIcon p_77026_2_) {
        float f = p_77026_2_.getMinU();
        float f1 = p_77026_2_.getMaxU();
        float f2 = p_77026_2_.getMinV();
        float f3 = p_77026_2_.getMaxV();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        p_77026_1_.startDrawingQuads();
        p_77026_1_.setNormal(0.0F, 1.0F, 0.0F);
        p_77026_1_.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f, (double)f3);
        p_77026_1_.addVertexWithUV((double)(f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
        p_77026_1_.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0D, (double)f1, (double)f2);
        p_77026_1_.addVertexWithUV((double)(0.0F - f5), (double)(f4 - f6), 0.0D, (double)f, (double)f2);
        p_77026_1_.draw();
    }
}
