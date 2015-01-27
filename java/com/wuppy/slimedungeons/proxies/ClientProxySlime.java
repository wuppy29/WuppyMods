package com.wuppy.slimedungeons.proxies;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.wuppy.slimedungeons.entity.EntitySlimeZombie;
import com.wuppy.slimedungeons.entity.RenderSlimeZombie;

public class ClientProxySlime extends CommonProxySlime
{
    @Override
    public void registerRenderThings()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntitySlimeZombie.class, new RenderSlimeZombie(new ModelBiped(), 0.5F));
    }
}
