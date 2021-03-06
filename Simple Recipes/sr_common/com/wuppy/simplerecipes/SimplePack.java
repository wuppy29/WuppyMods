package com.wuppy.simplerecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SimplePack.modid, name = "Simple Recipes", version = "1.8.2")
public class SimplePack 
{
	public static final String modid = "wuppy29_simplerecipes";
	
	public static final int VERSION = 4;
	public static String updates = "";
	public static boolean outdated = false;
	
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
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.addRecipe(new ItemStack(Blocks.clay, 4), new Object[]
		{
			"ZXZ", "XCX", "ZXZ", 'Z', new ItemStack(Items.dye, 1, 15), 'C', Items.water_bucket, 'X', Blocks.sand
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.clay, 4), new Object[]
		{
			"ZXZ", "XCX", "ZXZ", 'Z', Blocks.sand, 'C', Items.water_bucket, 'X', new ItemStack(Items.dye, 1, 15)
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1), new Object[]
		{
			" X ", "XZX", " X ", 'Z', Blocks.cobblestone, 'X', Blocks.vine
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.web, 5), new Object[]
		{
			"X X", " X ", "X X", 'X', Items.string
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 1), new Object[]
		{
			new ItemStack(Items.water_bucket), new ItemStack(Items.lava_bucket)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gravel, 2), new Object[]
		{
			new ItemStack(Items.flint), new ItemStack(Blocks.cobblestone)
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.sponge, 4), new Object[]
		{
			" X ", "XZX", " X ", 'X', new ItemStack(Blocks.wool, 1, 4), 'Z', Items.water_bucket
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.ice, 1), new Object[]
		{
			" X ", "XZX", " X ", 'X', Items.snowball, 'Z', Items.water_bucket
		});
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new Object[]
		{
			" X ", "XZX", " X ", 'Z', new ItemStack(Blocks.stonebrick, 1, 0), 'X', Blocks.vine
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass), new Object[]
		{
			new ItemStack(Blocks.dirt), new ItemStack(Blocks.vine)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone), new Object[]
		{
			new ItemStack(Items.chicken)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone), new Object[]
		{
			new ItemStack(Items.porkchop)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone), new Object[]
		{
			new ItemStack(Items.beef)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 2), new Object[]
		{
			new ItemStack(Items.flint), new ItemStack(Blocks.stonebrick)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone, 2), new Object[]
		{
			new ItemStack(Items.glowstone_dust), new ItemStack(Items.dye, 1, 1)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust, 2), new Object[]
		{
			new ItemStack(Items.redstone), new ItemStack(Items.dye, 1, 11)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.book, 1), new Object[] 
		{
			new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Blocks.wool)
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 0), new Object[]
		{
			new ItemStack(Items.coal)
		});
		GameRegistry.addRecipe(new ItemStack(Items.arrow, 2), new Object[]
		{
			"XCX",
			" V ",
			" B ",
			'X', Blocks.leaves, 'C', Items.string, 'V', Items.stick, 'B', Items.flint
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new Object[]
		{
			Blocks.wool
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mycelium), new Object[]
		{
			Blocks.brown_mushroom, Blocks.red_mushroom, Blocks.dirt
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.packed_ice), new Object[]
		{
			Blocks.ice, Blocks.ice, Blocks.ice, Blocks.ice
		});
		GameRegistry.addRecipe(new ItemStack(Items.lead), new Object[]
		{
			"X ",
			"X ",
			"XY",
			'X', Items.leather, 'Y', Items.string
		});
		GameRegistry.addRecipe(new ItemStack(Items.lead), new Object[]
		{
			" X",
			" X",
			"YX",
			'X', Items.leather, 'Y', Items.string
		});
		GameRegistry.addRecipe(new ItemStack(Items.saddle), new Object[]
		{
			"XYX",
			"X X",
			"X X",
			'X', Items.leather, 'Y', Items.iron_ingot
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dirt, 1, 2), new Object[]
		{
			Blocks.dirt, Blocks.leaves
		});
		GameRegistry.addSmelting(Blocks.netherrack, new ItemStack(Blocks.nether_brick), 0.1F);
		GameRegistry.addSmelting(Blocks.stonebrick, new ItemStack(Blocks.stonebrick, 1, 3), 0.1F);
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1F);
		GameRegistry.addSmelting(Blocks.gravel, new ItemStack(Items.flint), 0.1F);
	}
	
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(outdated)
		{
			event.player.addChatComponentMessage(new ChatComponentText("Simple Recipes is outdated."));
			event.player.addChatComponentMessage(new ChatComponentText("Changelog: "));
			event.player.addChatComponentMessage(new ChatComponentText(updates));
		}
	}
}