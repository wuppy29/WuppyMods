package com.wuppy.frozen.entities.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.entities.EntityThug;

public class RenderThug extends RenderBiped
{
	public RenderThug()
	{
		super(new ModelBiped(), 0.5F);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		EntityThug thug = (EntityThug) entity;
		
		if(thug.textureType == 1)
			return new ResourceLocation(FrozenCraft.modid, "textures/models/thug1.png");
		else if(thug.textureType == 2)
			return new ResourceLocation(FrozenCraft.modid, "textures/models/thug2.png");
		else
		{
			System.out.println("something has gone wrong getting the texture for a Thug. Contact Wuppy");
			return null;
		}
	}
}