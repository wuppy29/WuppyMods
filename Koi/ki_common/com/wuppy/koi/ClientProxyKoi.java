package com.wuppy.koi;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyKoi extends CommonProxyKoi
{
    @Override
    public void registerRenderThings()
    {
    	RenderingRegistry.registerEntityRenderingHandler(Entitykoi.class, new RenderKoi(new ModelKoi(), 0.2F));
    }
}