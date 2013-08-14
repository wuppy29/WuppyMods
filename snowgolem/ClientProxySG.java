package snowgolem;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxySG extends CommonProxySG
{
	public void registerRenderThings() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityCleanSnowGolem.class, new RenderCleanSnowGolem());
	}
}
