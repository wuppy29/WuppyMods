package com.wuppy.snowgolem;

import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCleanSnowGolem extends RenderLiving
{
    private static final ResourceLocation texture = new ResourceLocation("textures/entity/snowman.png");

    /** A reference to the Snowman model in RenderSnowMan. */
    private ModelSnowMan snowmanModel;

    public RenderCleanSnowGolem()
    {
        super(new ModelSnowMan(), 0.5F);
        this.snowmanModel = (ModelSnowMan)super.mainModel;
        this.setRenderPassModel(this.snowmanModel);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}
