package com.wuppy.goblinsgiants.config;

import com.wuppy.goblinsgiants.worldgen.ModGeneration;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		ModGeneration.dimension = config.get("Dimension ID", Configuration.CATEGORY_GENERAL, 12).getInt();
		
		//Spawn config
		Config.spawnVampire = config.get(Configuration.CATEGORY_GENERAL, "spawnVampire", true).getBoolean(true);
		Config.spawnDwarf = config.get(Configuration.CATEGORY_GENERAL, "spawnDwarf", true).getBoolean(true);
		Config.spawnWerewolf = config.get(Configuration.CATEGORY_GENERAL, "spawnWerewolf", true).getBoolean(true);
		Config.spawnPigman = config.get(Configuration.CATEGORY_GENERAL, "spawnPigman", true).getBoolean(true);
		Config.spawnGoblin = config.get(Configuration.CATEGORY_GENERAL, "spawnGoblin", true).getBoolean(true);
		Config.spawnGiant = config.get(Configuration.CATEGORY_GENERAL, "spawnGiant", true).getBoolean(true);
		Config.spawnUruk = config.get(Configuration.CATEGORY_GENERAL, "spawnOrc", true).getBoolean(true);
		Config.spawnRedCreeper = config.get(Configuration.CATEGORY_GENERAL, "spawnRedCreeper", true).getBoolean(true);
		
		config.save();
	}
}
