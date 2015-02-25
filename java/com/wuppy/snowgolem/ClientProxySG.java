package com.wuppy.snowgolem;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxySG extends CommonProxySG
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityCleanSnowGolem.class, new RenderCleanSnowGolem(Minecraft.getMinecraft().getRenderManager()));
	}
}