package com.wuppy.goblinsgiants.config;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	public static boolean checkForUpdates = true;
	
	public static boolean spawnVampire = true;
	public static boolean spawnDwarf = true;
	public static boolean spawnWerewolf = true;
	public static boolean spawnPigman = true;
	public static boolean spawnGoblin = true;
	public static boolean spawnGiant = true;
	public static boolean spawnUruk = true;
	public static boolean spawnRedCreeper = true;
	
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		
		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);
		
		//Spawn config
		spawnVampire = config.get(Configuration.CATEGORY_GENERAL, "spawnVampire", true).getBoolean(true);
		spawnDwarf = config.get(Configuration.CATEGORY_GENERAL, "spawnDwarf", true).getBoolean(true);
		spawnWerewolf = config.get(Configuration.CATEGORY_GENERAL, "spawnWerewolf", true).getBoolean(true);
		spawnPigman = config.get(Configuration.CATEGORY_GENERAL, "spawnPigman", true).getBoolean(true);
		spawnGoblin = config.get(Configuration.CATEGORY_GENERAL, "spawnGoblin", true).getBoolean(true);
		spawnGiant = config.get(Configuration.CATEGORY_GENERAL, "spawnGiant", true).getBoolean(true);
		spawnUruk = config.get(Configuration.CATEGORY_GENERAL, "spawnOrc", true).getBoolean(true);
		spawnRedCreeper = config.get(Configuration.CATEGORY_GENERAL, "spawnRedCreeper", true).getBoolean(true);
		
		config.save();
	}
}