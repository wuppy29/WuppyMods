package com.wuppy.nethereye;

import java.io.IOException;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = NetherEye.modid, name = "Nether Eye", version = "1.4.0")
public class NetherEye 
{
	public static final String modid = "wuppy29_nethereye";
	
	public static final int VERSION = 2;
	public static String updates = "";
	public static boolean outdated = false;
	
	public static int NetherEyeID;
	
	public static Item nethereye;
	
	@SidedProxy(clientSide = "com.wuppy.nethereye.ClientProxyNetherEye", serverSide = "com.wuppy.nethereye.CommonProxyNetherEye")
    public static CommonProxyNetherEye proxy;
	
	public static boolean checkForUpdates = true;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "Check Updates", true).getBoolean(true);
		
		config.save();
		
		if (checkForUpdates)
		{
			try
			{
				UpdateChecker.checkForUpdates();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) 
	{
		FMLCommonHandler.instance().bus().register(this);
		
		nethereye = new ItemNetherEye().setUnlocalizedName("nethereye");
		
		GameRegistry.registerItem(nethereye, "Wuppy29_NetherEye");
		
		GameRegistry.addShapelessRecipe(new ItemStack(nethereye, 1), new Object[]
				{
					new ItemStack(Items.ender_pearl), new ItemStack(Items.magma_cream)
				});
		GameRegistry.addRecipe(new ItemStack(nethereye, 1), new Object[]
				{
					" X ", "CVC", " X ", 'X', Items.gold_nugget, 'C', Items.glowstone_dust, 'V', Items.ender_pearl
				});
		GameRegistry.addRecipe(new ItemStack(nethereye, 1), new Object[]
				{
					" X ", "CVC", " X ", 'C', Items.gold_nugget, 'X', Items.glowstone_dust, 'V', Items.ender_pearl
				});
		
		EntityRegistry.registerModEntity(EntityNetherEye.class, "Nether Eye", 44, this, 40, 1, true);
		
		DimensionManager.unregisterProviderType(-1);
		DimensionManager.registerProviderType(-1, WorldProviderCustomHell.class, false);
		
		proxy.registerEntityRender();
	}
	
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Nether Eye is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}