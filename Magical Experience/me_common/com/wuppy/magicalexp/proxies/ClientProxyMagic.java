package com.wuppy.magicalexp.proxies;

import com.wuppy.magicalexp.RenderMagicThunder;
import com.wuppy.magicalexp.RenderMagicalBottle;
import com.wuppy.magicalexp.entity.EntityBonemealBottle;
import com.wuppy.magicalexp.entity.EntityClusterBottle;
import com.wuppy.magicalexp.entity.EntityDirtBottle;
import com.wuppy.magicalexp.entity.EntityExpBottlexl;
import com.wuppy.magicalexp.entity.EntityFirebottle;
import com.wuppy.magicalexp.entity.EntityMagicThunder;
import com.wuppy.magicalexp.entity.EntityThunderbottle;
import com.wuppy.magicalexp.entity.EntityTntbottle;
import com.wuppy.magicalexp.items.ModItems;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyMagic extends CommonProxyMagic
{
    public void registerEntityRender() 
	{
    	RenderingRegistry.registerEntityRenderingHandler(EntityMagicThunder.class, new RenderMagicThunder());
	}

	public void registerItemRender() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityExpBottlexl.class, new RenderMagicalBottle(ModItems.xpbottlexl));
    	RenderingRegistry.registerEntityRenderingHandler(EntityThunderbottle.class, new RenderMagicalBottle(ModItems.thunderbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTntbottle.class, new RenderMagicalBottle(ModItems.tntbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityClusterBottle.class, new RenderMagicalBottle(ModItems.clusterbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityFirebottle.class, new RenderMagicalBottle(ModItems.firebottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityDirtBottle.class, new RenderMagicalBottle(ModItems.dirtbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityBonemealBottle.class, new RenderMagicalBottle(ModItems.bonebottle));
	}
}