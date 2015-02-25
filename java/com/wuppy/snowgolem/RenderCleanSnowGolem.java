package com.wuppy.snowgolem;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCleanSnowGolem extends RenderLiving {
	private static final ResourceLocation snowManTextures = new ResourceLocation("textures/entity/snowman.png");

	public RenderCleanSnowGolem(RenderManager p_i46140_1_) {
		super(p_i46140_1_, new ModelSnowMan(), 0.5F);
	}

	protected ResourceLocation func_180587_a(EntitySnowman p_180587_1_) {
		return snowManTextures;
	}

	public ModelSnowMan func_177123_g() {
		return (ModelSnowMan) super.getMainModel();
	}

	@Override
	public ModelBase getMainModel() {
		return this.func_177123_g();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.func_180587_a((EntitySnowman) p_110775_1_);
	}
}