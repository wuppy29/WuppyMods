package com.wuppy.nethereye;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyNetherEye extends CommonProxyNetherEye
{
	public void registerEntityRender() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherEye.class, new RenderNetherEye(NetherEye.nethereye));
	}
}
