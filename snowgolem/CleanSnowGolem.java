package snowgolem;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = CleanSnowGolem.modid, name = "Clean Snow Golem", version = "1.4.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CleanSnowGolem 
{
	public static final String modid = "wuppy29_snowgolem";
	
	@SidedProxy(clientSide = "snowgolem.ClientProxySG", serverSide = "snowgolem.CommonProxySG")
	public static CommonProxySG proxy;
	
	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		proxy.registerRenderThings();
	}
}
