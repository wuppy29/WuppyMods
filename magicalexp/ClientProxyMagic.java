package magicalexp;

import magicalexp.entity.EntityBonemealBottle;
import magicalexp.entity.EntityClusterBottle;
import magicalexp.entity.EntityDirtBottle;
import magicalexp.entity.EntityExpBottlexl;
import magicalexp.entity.EntityFirebottle;
import magicalexp.entity.EntityMagicThunder;
import magicalexp.entity.EntityThunderbottle;
import magicalexp.entity.EntityTntbottle;
import net.minecraftforge.client.MinecraftForgeClient;
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