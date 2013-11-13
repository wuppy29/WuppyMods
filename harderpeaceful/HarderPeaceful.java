package harderpeaceful;

import java.io.IOException;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = HarderPeaceful.modid, name = "Harder Peaceful", version = "1.6.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HarderPeaceful
{
	public static final String modid = "wuppy29_harderpeaceful";
	
	EventManager manager = new EventManager();
	
	public static final int VERSION = 1;
	public static String updates = "";
	public static boolean outdated = false;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		try
		{
			UpdateChecker.checkForUpdates();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(manager);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		GameRegistry.registerPlayerTracker(new HarderPeacefulLogin());
	}
}
