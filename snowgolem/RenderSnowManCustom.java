package snowgolem;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSnowManCustom extends RenderLiving
{
    private static final ResourceLocation field_110895_a = new ResourceLocation("textures/entity/snowman.png");

    /** A reference to the Snowman model in RenderSnowMan. */
    private ModelSnowMan snowmanModel;

    public RenderSnowManCustom()
    {
        super(new ModelSnowMan(), 0.5F);
        this.snowmanModel = (ModelSnowMan)super.mainModel;
        this.setRenderPassModel(this.snowmanModel);
    }

    /**
     * Renders this snowman's pumpkin.
     */
    protected void renderSnowmanPumpkin(EntitySnowman par1EntitySnowman, float par2)
    {
        super.renderEquippedItems(par1EntitySnowman, par2);
        ItemStack itemstack = new ItemStack(Block.pumpkin, 1);

        if (itemstack != null && itemstack.getItem() instanceof ItemBlock)
        {
            GL11.glPushMatrix();
            this.snowmanModel.head.postRender(0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

            if (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
            {
                float f1 = 0.625F;
                GL11.glTranslatef(0.0F, -0.34375F, 0.0F);
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            }

            this.renderManager.itemRenderer.renderItem(par1EntitySnowman, itemstack, 0);
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation func_110894_a(EntitySnowman par1EntitySnowman)
    {
        return field_110895_a;
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderSnowmanPumpkin((EntitySnowman)par1EntityLivingBase, par2);
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110894_a((EntitySnowman)par1Entity);
    }
}
