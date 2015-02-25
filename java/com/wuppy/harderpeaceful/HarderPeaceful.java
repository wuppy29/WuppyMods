package com.wuppy.harderpeaceful;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HarderPeaceful.modid, name = "Harder Peaceful", version = "1.8.0")
public class HarderPeaceful {
	public static final String modid = "wuppy29_harderpeaceful";

	EventManager manager = new EventManager();

	public static final int VERSION = 5;
	public static String updates = "";
	public static boolean outdated = false;

	public static boolean starveToDeath = false;
	public static boolean checkForUpdates = true;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		starveToDeath = config.get(Configuration.CATEGORY_GENERAL, "starveToDeath", false).getBoolean(false);
		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);

		config.save();

		if (checkForUpdates)
			UpdateChecker.checkForUpdates();

		MinecraftForge.EVENT_BUS.register(manager);
		FMLCommonHandler.instance().bus().register(manager);
	}
}