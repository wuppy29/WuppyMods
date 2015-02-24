package com.wuppy.frozen.entities.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.wuppy.frozen.FrozenCraft;

public class RenderBipedFrozenCraft extends RenderBiped
{
	private ResourceLocation texture;
	
	public RenderBipedFrozenCraft(ModelBiped par1ModelBiped, float par2, String string)
	{
		super(Minecraft.getMinecraft().getRenderManager(), par1ModelBiped, par2);
		texture = new ResourceLocation(FrozenCraft.modid, string);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}