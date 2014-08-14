package com.wuppy.slimedungeons;

import com.wuppy.slimedungeons.blocks.ModBlocks;
import com.wuppy.slimedungeons.entity.ModEntities;
import com.wuppy.slimedungeons.generation.SlimeGenerator;
import com.wuppy.slimedungeons.helpers.Config;
import com.wuppy.slimedungeons.helpers.ModEvents;
import com.wuppy.slimedungeons.helpers.ModRecipes;
import com.wuppy.slimedungeons.helpers.UpdateChecker;
import com.wuppy.slimedungeons.proxies.CommonProxySlime;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SlimeDungeon.MODID, name = "Slime Dungeons", version = "1.6.1")
public class SlimeDungeon
{
	public static final String MODID = "wuppy29_slimedungeon";

	public static final int VERSION = 3;
	public static String updates = "";
	public static boolean outdated = false;

	@SidedProxy(clientSide = "com.wuppy.slimedungeons.proxies.ClientProxySlime", serverSide = "com.wuppy.slimedungeons.proxies.CommonProxySlime")
	public static CommonProxySlime proxy;

	ModEvents events = new ModEvents();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(events);
		
		Config.loadConfig(event);
		
		if (Config.checkForUpdates)
			UpdateChecker.checkForUpdates();
		
		proxy.registerRenderThings();
		
		ModBlocks.init();
		ModRecipes.init();
		ModEntities.init(this);
		
		GameRegistry.registerWorldGenerator(new SlimeGenerator(), 1);
	}
}