package com.wuppy.nethereye;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = NetherEye.modid, name = "Nether Eye", version = "1.4.2")
public class NetherEye
{
	public static final String modid = "wuppy29_nethereye";

	public static final int VERSION = 4;
	public static String updates = "";
	public static boolean outdated = false;

	public static Item nethereye;

	@SidedProxy(clientSide = "com.wuppy.nethereye.ClientProxyNetherEye", serverSide = "com.wuppy.nethereye.CommonProxyNetherEye")
	public static CommonProxyNetherEye proxy;

	public static boolean checkForUpdates = true;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);

		// setup config file
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "Check Updates", true).getBoolean(true);
		config.save();

		// check for updates
		if (checkForUpdates)
			UpdateChecker.checkForUpdates();

		// items
		nethereye = new ItemNetherEye();

		// entities
		EntityRegistry.registerModEntity(EntityNetherEye.class, "Nether Eye", 44, this, 40, 1, true);

		// dimensions
		DimensionManager.unregisterProviderType(-1);
		DimensionManager.registerProviderType(-1, WorldProviderCustomHell.class, false);
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerEntityRender();

		// recipes
		GameRegistry.addShapelessRecipe(new ItemStack(nethereye, 1), new ItemStack(Items.ender_pearl), new ItemStack(Items.magma_cream));
		GameRegistry.addRecipe(new ItemStack(nethereye, 1), " X ", "CVC", " X ", 'X', Items.gold_nugget, 'C', Items.glowstone_dust, 'V', Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(nethereye, 1), " X ", "CVC", " X ", 'C', Items.gold_nugget, 'X', Items.glowstone_dust, 'V', Items.ender_pearl);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if (event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			renderItem.getItemModelMesher().register(nethereye, 0, new ModelResourceLocation(modid + ":" + ((ItemNetherEye) nethereye).getName(), "inventory"));
		}
	}

	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Nether Eye is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}