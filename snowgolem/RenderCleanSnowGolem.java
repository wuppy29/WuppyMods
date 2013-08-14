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
public class RenderCleanSnowGolem extends RenderLiving
{
    private static final ResourceLocation field_110895_a = new ResourceLocation("textures/entity/snowman.png");

    /** A reference to the Snowman model in RenderSnowMan. */
    private ModelSnowMan snowmanModel;

    public RenderCleanSnowGolem()
    {
        super(new ModelSnowMan(), 0.5F);
        this.snowmanModel = (ModelSnowMan)super.mainModel;
        this.setRenderPassModel(this.snowmanModel);
    }

    protected ResourceLocation func_110894_a(EntitySnowman par1EntitySnowman)
    {
        return field_110895_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110894_a((EntitySnowman)par1Entity);
    }
}
