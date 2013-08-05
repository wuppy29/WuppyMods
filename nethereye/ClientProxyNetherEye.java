package nethereye;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyNetherEye extends CommonProxyNetherEye
{
	public void registerEntityRender() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherEye.class, new RenderNetherEye(NetherEye.nethereye));
	}
}
