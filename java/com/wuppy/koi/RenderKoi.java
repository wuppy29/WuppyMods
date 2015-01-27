package com.wuppy.koi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderKoi extends RenderLiving
{
    private static final ResourceLocation texture = new ResourceLocation(Koi.modid, "textures/models/koi.png");

    public RenderKoi(RenderManager manager, ModelBase modelBase, float size)
    {
        super(manager, modelBase, size);
    }

    @Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}