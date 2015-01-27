package com.wuppy.slimedungeons.helpers;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	public static boolean checkForUpdates = true;
	
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "Check Updates", true).getBoolean(true);

		config.save();
	}
}
