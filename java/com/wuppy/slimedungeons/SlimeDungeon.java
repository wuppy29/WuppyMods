package com.wuppy.slimedungeons;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.slimedungeons.blocks.ModBlocks;
import com.wuppy.slimedungeons.entity.ModEntities;
import com.wuppy.slimedungeons.generation.SlimeGenerator;
import com.wuppy.slimedungeons.helpers.Config;
import com.wuppy.slimedungeons.helpers.ModEvents;
import com.wuppy.slimedungeons.helpers.ModRecipes;
import com.wuppy.slimedungeons.helpers.UpdateChecker;
import com.wuppy.slimedungeons.proxies.CommonProxySlime;

@Mod(modid = SlimeDungeon.MODID, name = "Slime Dungeons", version = "1.6.3")
public class SlimeDungeon
{
	public static final String MODID = "wuppy29_slimedungeon";

	public static final int VERSION = 5;
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
		
		ModBlocks.init();
		ModRecipes.init();
		ModEntities.init(this);
		
		GameRegistry.registerWorldGenerator(new SlimeGenerator(), 1);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ModBlocks.registerModels(event);
	}
}