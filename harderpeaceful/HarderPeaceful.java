package harderpeaceful;

import java.io.IOException;

import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

@Mod(modid = HarderPeaceful.modid, name = "Harder Peaceful", version = "1.7.1")
public class HarderPeaceful
{
	public static final String modid = "wuppy29_harderpeaceful";
	
	EventManager manager = new EventManager();
	
	public static final int VERSION = 3;
	public static String updates = "";
	public static boolean outdated = false;
	
	public static boolean starveToDeath = false;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		starveToDeath = config.get(Configuration.CATEGORY_GENERAL, "starveToDeath", false).getBoolean(false);
		
		config.save();
		
		try
		{
			UpdateChecker.checkForUpdates();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(manager);
	}
	
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(outdated)
		{
			event.player.func_146105_b(new ChatComponentText("Harder Peaceful is outdated."));
			event.player.func_146105_b(new ChatComponentText("Changelog: "));
			event.player.func_146105_b(new ChatComponentText(updates));
		}
	}
}
