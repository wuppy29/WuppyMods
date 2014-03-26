package com.wuppy.magicalexp;

import com.wuppy.magicalexp.entity.EntityBonemealBottle;
import com.wuppy.magicalexp.entity.EntityClusterBottle;
import com.wuppy.magicalexp.entity.EntityDirtBottle;
import com.wuppy.magicalexp.entity.EntityExpBottlexl;
import com.wuppy.magicalexp.entity.EntityFirebottle;
import com.wuppy.magicalexp.entity.EntityMagicThunder;
import com.wuppy.magicalexp.entity.EntityThunderbottle;
import com.wuppy.magicalexp.entity.EntityTntbottle;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyMagic extends CommonProxyMagic
{
    public void registerEntityRender() 
	{
    	RenderingRegistry.registerEntityRenderingHandler(EntityMagicThunder.class, new RenderMagicThunder());
	}

	public void registerItemRender() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityExpBottlexl.class, new RenderMagicalBottle(MagicalExperience.xpbottlexl));
    	RenderingRegistry.registerEntityRenderingHandler(EntityThunderbottle.class, new RenderMagicalBottle(MagicalExperience.thunderbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTntbottle.class, new RenderMagicalBottle(MagicalExperience.tntbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityClusterBottle.class, new RenderMagicalBottle(MagicalExperience.clusterbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityFirebottle.class, new RenderMagicalBottle(MagicalExperience.firebottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityDirtBottle.class, new RenderMagicalBottle(MagicalExperience.dirtbottle));
    	RenderingRegistry.registerEntityRenderingHandler(EntityBonemealBottle.class, new RenderMagicalBottle(MagicalExperience.bonebottle));
	}
}