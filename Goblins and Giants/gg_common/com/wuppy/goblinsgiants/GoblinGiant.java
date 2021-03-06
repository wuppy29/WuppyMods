package com.wuppy.goblinsgiants;

import com.wuppy.goblinsgiants.blocks.ModBlocks;
import com.wuppy.goblinsgiants.config.Config;
import com.wuppy.goblinsgiants.entity.ModEntities;
import com.wuppy.goblinsgiants.helpers.ModEvents;
import com.wuppy.goblinsgiants.helpers.UpdateChecker;
import com.wuppy.goblinsgiants.items.ModItems;
import com.wuppy.goblinsgiants.items.ModMaterials;
import com.wuppy.goblinsgiants.proxies.CommonProxyGoblin;
import com.wuppy.goblinsgiants.recipes.ModRecipes;
import com.wuppy.goblinsgiants.tabs.ModTabs;
import com.wuppy.goblinsgiants.worldgen.ModGeneration;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GoblinGiant.modid, name = "Goblins and Giants", version = "1.0.5.0")
public class GoblinGiant
{
	/*
	 * - Added translations for: all Spanish languages (5), French, Japanese and Russian. 
	 */
	
	public static final int VERSION = 6;

	public static final String modid = "wuppy29_goblingiant";

	@SidedProxy(clientSide = "com.wuppy.goblinsgiants.proxies.ClientProxyGoblin", serverSide = "com.wuppy.goblinsgiants.proxies.CommonProxyGoblin")
	public static CommonProxyGoblin proxy;

	ModEvents events = new ModEvents();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(events);

		Config.loadConfig(event);
		
		if(Config.checkForUpdates)
			UpdateChecker.checkForUpdates();

		new ModMaterials();
		new ModTabs();
		
		ModBlocks.init();
		
		ModItems.init();
		
		ModEntities.init(this);
		
		ModGeneration.init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		ModRecipes.init();
	}
}