package com.wuppy.slimedungeons.proxies;

import com.wuppy.slimedungeons.entity.EntitySlimeZombie;
import com.wuppy.slimedungeons.entity.RenderSlimeZombie;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxySlime extends CommonProxySlime
{
	@Override
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySlimeZombie.class, new RenderSlimeZombie(new ModelBiped(), 0.5F));
	}
}
