package com.wuppy.frozen.proxies;

import static org.lwjgl.opengl.GL11.*;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.entities.render.models.ModelOlaf;

public class RenderOlaf extends Render
{
	ModelOlaf model = new ModelOlaf();
	
	@Override
	public void doRender(Entity entity, double par2, double par3, double par4, float par5, float par6)
	{
		glPushMatrix();
		
		bindEntityTexture(entity);
		
		model.renderAll();
		
		glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return new ResourceLocation(FrozenCraft.modid + ":" + "models/entities/olaf.png");
	}
}