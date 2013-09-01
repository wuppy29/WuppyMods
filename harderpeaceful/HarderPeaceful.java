package harderpeaceful;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = HarderPeaceful.modid, name = "Harder Peaceful", version = "1.6.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HarderPeaceful 
{
	public static final String modid = "wuppy29_harderpeaceful";
	
	EventManager manager = new EventManager();
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(manager);
	}
}
