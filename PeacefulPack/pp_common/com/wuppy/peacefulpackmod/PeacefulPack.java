package com.wuppy.peacefulpackmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.config.Config;
import com.wuppy.peacefulpackmod.helper.ModRecipes;
import com.wuppy.peacefulpackmod.helper.PeacefulEvent;
import com.wuppy.peacefulpackmod.helper.PeacefulFuel;
import com.wuppy.peacefulpackmod.helper.PeacefulTab;
import com.wuppy.peacefulpackmod.helper.UpdateChecker;
import com.wuppy.peacefulpackmod.item.ModItems;
import com.wuppy.peacefulpackmod.worldgen.PeacefulGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = PeacefulPack.modid, name = "Peacefulpack", version = "1.1.8.4")
public class PeacefulPack
{
	/*
	 * - Fixed blaze sapling planting issue
	 * - Added 5 new spanish translations and the Portuguese translation
	 */
	
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

		ModBlocks.init();

		ModItems.init();

		GameRegistry.registerWorldGenerator(new PeacefulGenerator(), 0);

		GameRegistry.registerFuelHandler(new PeacefulFuel());
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		ModRecipes.init();
	}
}