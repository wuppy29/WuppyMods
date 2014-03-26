package com.wuppy.improvedmobspawn;

import net.minecraft.client.renderer.entity.RenderSpider;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyIMP extends CommonProxyIMP
{
	@Override
    public void registerRenderThings()
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderCustom.class, new RenderSpider());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiderCustom.class, new RenderSpider());
    }
}