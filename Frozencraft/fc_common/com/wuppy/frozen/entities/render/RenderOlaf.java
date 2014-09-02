package com.wuppy.frozen.entities.render;

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
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		glPushMatrix();

		// standing
		glTranslated(x, y + 0.6D, z);
		glRotatef(90F, 1F, 0F, 0F);
		
		//System.out.println(yaw);
		
		//looking
		glRotatef(yaw, 0F, 0F, 1F);

		// scale
		float scale = 0.15F;
		glScalef(scale, scale, scale);

		// render
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