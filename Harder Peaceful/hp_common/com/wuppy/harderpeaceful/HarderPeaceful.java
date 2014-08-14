package com.wuppy.harderpeaceful;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HarderPeaceful.modid, name = "Harder Peaceful", version = "1.7.3")
public class HarderPeaceful
{
	public static final String modid = "wuppy29_harderpeaceful";
	
	EventManager manager = new EventManager();
	
	public static final int VERSION = 4;
	public static String updates = "";
	public static boolean outdated = false;
	
	public static boolean starveToDeath = false;
	public static boolean checkForUpdates = true;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		starveToDeath = config.get(Configuration.CATEGORY_GENERAL, "starveToDeath", false).getBoolean(false);
		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);
		
		config.save();
		
		if(checkForUpdates)
			UpdateChecker.checkForUpdates();
		
		MinecraftForge.EVENT_BUS.register(manager);
	}
}