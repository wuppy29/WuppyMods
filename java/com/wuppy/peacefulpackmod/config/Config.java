package com.wuppy.peacefulpackmod.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	public static boolean checkForUpdates = true;

	public static boolean spawnSulphurNiter = true;
	public static boolean spawnFossils = true;
	public static boolean spawnFlax = true;
	public static boolean spawnSlimePool = true;
	public static boolean spawnRottenPlants = true;
	public static boolean spawnBlazeTrees = true;
	public static boolean spawnGhastOre = true;
	public static boolean spawnEnderClams = true;
	public static boolean spawnRemains = true;
	public static boolean changeWeb = true;

	public static boolean lavaForGhastOres = true;

	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);

		// generation
		spawnSulphurNiter = config.get(Configuration.CATEGORY_GENERAL, "spawnSulphurNiter", true).getBoolean(true);
		spawnFossils = config.get(Configuration.CATEGORY_GENERAL, "spawnFossils", true).getBoolean(true);
		spawnFlax = config.get(Configuration.CATEGORY_GENERAL, "spawnFlax", true).getBoolean(true);
		spawnSlimePool = config.get(Configuration.CATEGORY_GENERAL, "spawnSlimeSlabs", true).getBoolean(true);
		spawnRottenPlants = config.get(Configuration.CATEGORY_GENERAL, "spawnRottenPlants", true).getBoolean(true);
		spawnBlazeTrees = config.get(Configuration.CATEGORY_GENERAL, "spawnBlazeTrees", true).getBoolean(true);
		spawnGhastOre = config.get(Configuration.CATEGORY_GENERAL, "spawnGhastOre", true).getBoolean(true);
		spawnEnderClams = config.get(Configuration.CATEGORY_GENERAL, "spawnEnderClams", true).getBoolean(true);
		spawnRemains = config.get(Configuration.CATEGORY_GENERAL, "spawnRemains", true).getBoolean(true);
		changeWeb = config.get(Configuration.CATEGORY_GENERAL, "changeWeb", true).getBoolean(true);

		lavaForGhastOres = config.get(Configuration.CATEGORY_GENERAL, "lavaForGhastOres", true).getBoolean(true);

		config.save();
	}
}
