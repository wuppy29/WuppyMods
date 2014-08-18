package com.wuppy.improvedmobspawn.proxies;

import com.wuppy.improvedmobspawn.entity.EntityCaveSpiderCustom;
import com.wuppy.improvedmobspawn.entity.EntitySpiderCustom;
import com.wuppy.improvedmobspawn.entity.EntityWitherSkeleton;

import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderSpider;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyIMP extends CommonProxyIMP
{
	@Override
    public void registerRenderThings()
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderCustom.class, new RenderSpider());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiderCustom.class, new RenderSpider());
		RenderingRegistry.registerEntityRenderingHandler(EntityWitherSkeleton.class, new RenderSkeleton());
    }
}