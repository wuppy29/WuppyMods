package com.wuppy.magicalexp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;

import com.wuppy.magicalexp.blocks.ModBlocks;
import com.wuppy.magicalexp.entity.ModEntities;
import com.wuppy.magicalexp.items.ModItems;
import com.wuppy.magicalexp.proxies.CommonProxyMagic;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MagicalExperience.modid, name = "Magical Experience", version = "1.1.5.0")
public class MagicalExperience
{
	public static final String modid = "wuppy29_magicalexperience";

	public static final int VERSION = 5;
	public static String updates = "";
	public static boolean outdated = false;

	@SidedProxy(clientSide = "com.wuppy.magicalexp.proxies.ClientProxyMagic", serverSide = "com.wuppy.magicalexp.proxies.CommonProxyMagic")
	public static CommonProxyMagic proxy;

	public static boolean checkForUpdates = true;
	
	public static CreativeTabs meBlocks = new MagicalExperienceTab(CreativeTabs.getNextID(), "me_blocks");
	public static CreativeTabs meMaterials = new MagicalExperienceTab(CreativeTabs.getNextID(), "me_materials");
	public static CreativeTabs meUsables = new MagicalExperienceTab(CreativeTabs.getNextID(), "me_usables");
	
	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "Check Updates", true).getBoolean(true);

		config.save();

		if (checkForUpdates)
			UpdateChecker.checkForUpdates();

		FMLCommonHandler.instance().bus().register(this);

		proxy.registerEntityRender();

		GameRegistry.registerFuelHandler(new MagicFuel());

		GameRegistry.registerWorldGenerator(new MagicGenerater(), 0);

		ModBlocks.loadBlocks();

		ModItems.loadItems();

		ModEntities.loadEntities(this);

		//recipes
		new MagicalRecipes();

		proxy.registerItemRender();
	}

	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Magical Experience is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}
