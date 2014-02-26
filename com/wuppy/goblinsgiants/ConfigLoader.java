package com.wuppy.goblinsgiants;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader
{
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		GoblinGiant.dimension = config.get("Dimension ID", Configuration.CATEGORY_GENERAL, 12).getInt();
		
		//Spawn config
		GoblinGiant.spawnVampire = config.get(Configuration.CATEGORY_GENERAL, "spawnVampire", true).getBoolean(true);
		GoblinGiant.spawnDwarf = config.get(Configuration.CATEGORY_GENERAL, "spawnDwarf", true).getBoolean(true);
		GoblinGiant.spawnWerewolf = config.get(Configuration.CATEGORY_GENERAL, "spawnWerewolf", true).getBoolean(true);
		GoblinGiant.spawnPigman = config.get(Configuration.CATEGORY_GENERAL, "spawnPigman", true).getBoolean(true);
		GoblinGiant.spawnGoblin = config.get(Configuration.CATEGORY_GENERAL, "spawnGoblin", true).getBoolean(true);
		GoblinGiant.spawnGiant = config.get(Configuration.CATEGORY_GENERAL, "spawnGiant", true).getBoolean(true);
		GoblinGiant.spawnUruk = config.get(Configuration.CATEGORY_GENERAL, "spawnOrc", true).getBoolean(true);
		GoblinGiant.spawnRedCreeper = config.get(Configuration.CATEGORY_GENERAL, "spawnRedCreeper", true).getBoolean(true);
		
		config.save();
	}
}
