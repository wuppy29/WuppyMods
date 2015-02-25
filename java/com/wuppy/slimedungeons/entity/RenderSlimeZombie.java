package com.wuppy.slimedungeons.entity;

import com.wuppy.slimedungeons.SlimeDungeon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSlimeZombie extends RenderLiving {
	private static ResourceLocation texture = new ResourceLocation(SlimeDungeon.MODID, "textures/models/slime zombie.png");

	public RenderSlimeZombie(ModelBase par1ModelBase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(), par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}