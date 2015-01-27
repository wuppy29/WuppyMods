package com.wuppy.jellycubes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = JellyCube.modid, name = "Jelly Cubes", version = "1.13.2")
public class JellyCube
{
	public static final String modid = "wuppy29_jellycubes";

	public static final int VERSION = 4;
	public static String updates = "";
	public static boolean outdated = false;

	public static Item jellycube;
	
	public static boolean checkForUpdates = true;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);

		config.save();

		if (checkForUpdates)
			UpdateChecker.checkForUpdates();

		// item registry
		jellycube = new ItemFood(4, 6, false).setUnlocalizedName("jelly cube");
		GameRegistry.registerItem(jellycube, jellycube.getUnlocalizedName());
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.addShapelessRecipe(new ItemStack(jellycube, 1), new Object[] { new ItemStack(Items.slime_ball), new ItemStack(Items.slime_ball) });
	}

	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Jelly Cubes is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		if(event.getSide() == Side.CLIENT)
		{
	        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

	        renderItem.getItemModelMesher().register(jellycube, 0, new ModelResourceLocation(modid + ":item.jelly cube", "inventory"));
		}
    }
}
