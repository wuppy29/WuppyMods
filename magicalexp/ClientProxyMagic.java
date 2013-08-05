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
		RenderingRegistry.registerEntityRenderingHandler(EntityExpBottlexl.class, new RenderMagicalBottle(MagicalExperience.xpbottlexl, 0, "assets/wuppy29_magicalexperience/textures/items/xpbottlexl.png"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityThunderbottle.class, new RenderMagicalBottle(MagicalExperience.thunderbottle, 0, "assets/wuppy29_magicalexperience/textures/items/thunderbottle.png"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTntbottle.class, new RenderMagicalBottle(MagicalExperience.tntbottle, 0, "assets/wuppy29_magicalexperience/textures/items/Tntbottle.png"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityClusterBottle.class, new RenderMagicalBottle(MagicalExperience.clusterbottle, 0, "assets/wuppy29_magicalexperience/textures/items/clusterbottle.png"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityFirebottle.class, new RenderMagicalBottle(MagicalExperience.firebottle, 0, "assets/wuppy29_magicalexperience/textures/items/firebottle.png"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityDirtBottle.class, new RenderMagicalBottle(MagicalExperience.dirtbottle, 0, "assets/wuppy29_magicalexperience/textures/items/dirtbottle.png"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityBonemealBottle.class, new RenderMagicalBottle(MagicalExperience.bonebottle, 0, "assets/wuppy29_magicalexperience/textures/items/bonebottle.png"));
	}
}