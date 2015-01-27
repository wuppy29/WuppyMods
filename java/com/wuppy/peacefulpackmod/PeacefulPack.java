package com.wuppy.peacefulpackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.config.Config;
import com.wuppy.peacefulpackmod.helper.ModRecipes;
import com.wuppy.peacefulpackmod.helper.PeacefulEvent;
import com.wuppy.peacefulpackmod.helper.PeacefulFuel;
import com.wuppy.peacefulpackmod.helper.PeacefulTab;
import com.wuppy.peacefulpackmod.helper.UpdateChecker;
import com.wuppy.peacefulpackmod.item.ModItems;
import com.wuppy.peacefulpackmod.worldgen.PeacefulGenerator;

@Mod(modid = PeacefulPack.modid, name = "Peacefulpack", version = "1.1.8.5")
public class PeacefulPack
{
	public static final String modid = "wuppy29_peacefulpack";

	public static final int VERSION = 7;
	public static String updates = "";
	public static boolean outdated = false;
	
	public static CreativeTabs ppBlocksTab = new PeacefulTab(CreativeTabs.getNextID(), "pp_blocks");
	public static CreativeTabs ppMaterialTab = new PeacefulTab(CreativeTabs.getNextID(), "pp_materials");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new PeacefulEvent());

		Config.init(event);

		if(Config.checkForUpdates)
			UpdateChecker.checkForUpdates();
		
		ModBlocks.init(event);

		ModItems.init();

		GameRegistry.registerWorldGenerator(new PeacefulGenerator(), 0);

		GameRegistry.registerFuelHandler(new PeacefulFuel());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ModBlocks.postInit(event);
		ModItems.postInit(event);
	}
}