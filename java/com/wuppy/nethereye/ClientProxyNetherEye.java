package com.wuppy.nethereye;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxyNetherEye extends CommonProxyNetherEye
{
	public void registerEntityRender() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherEye.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), NetherEye.nethereye, Minecraft.getMinecraft().getRenderItem()));
	}
}
