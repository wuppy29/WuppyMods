package com.wuppy.improvedmobspawn;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	public static boolean checkForUpdates = true;
	
	public static int blazeSpawnChance = 1;
	public static int magmaCubeSpawnChance = 2;
	public static int witherSkeletonSpawnChance = 3;
	
	public static int silverFishStoneGenChance = 5;
	
	public static int spiderJockeySpawnChance = 5;

	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);
		blazeSpawnChance = config.get(Configuration.CATEGORY_GENERAL, "blazeSpawnChance", 1).getInt();
		magmaCubeSpawnChance = config.get(Configuration.CATEGORY_GENERAL, "magmaCubeSpawnChance", 2).getInt();
		witherSkeletonSpawnChance = config.get(Configuration.CATEGORY_GENERAL, "witherSkeletonSpawnChance", 3).getInt();
		
		silverFishStoneGenChance = config.get(Configuration.CATEGORY_GENERAL, "silverFishStoneGenChance", 5).getInt();
		
		spiderJockeySpawnChance = config.get(Configuration.CATEGORY_GENERAL, "spiderJockeySpawnChance", 5).getInt();

		config.save();
	}
}