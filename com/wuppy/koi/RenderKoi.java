package com.wuppy.koi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderKoi extends RenderLiving
{
    private static final ResourceLocation texture = new ResourceLocation(Koi.modid, "textures/models/koi.png");

    public RenderKoi(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}
