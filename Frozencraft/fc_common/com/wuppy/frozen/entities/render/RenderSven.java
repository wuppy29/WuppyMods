package com.wuppy.frozen.entities.render;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslated;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.entities.render.models.ModelSven;

public class RenderSven extends Render
{
	ModelSven model = new ModelSven();

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		glPushMatrix();

		// standing
		glTranslated(x, y + 1.38D, z);
		glRotatef(90F, 1F, 0F, 0F);
		
		//looking
		glRotatef(yaw, 0F, 0F, 1F);

		// scale
		float scale = 0.4F;
		glScalef(scale, scale, scale);

		// render
		bindEntityTexture(entity);
		model.renderAll();

		glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return new ResourceLocation(FrozenCraft.modid + ":" + "models/entities/sven.png");
	}
}