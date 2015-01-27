package com.wuppy.koi;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxyKoi extends CommonProxyKoi
{
    @Override
    public void registerRenderThings()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntityKoi.class, new RenderKoi(Minecraft.getMinecraft().getRenderManager(), new ModelKoi(), 0.2F));
    }
}