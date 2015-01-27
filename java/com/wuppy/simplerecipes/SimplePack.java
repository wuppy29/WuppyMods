package com.wuppy.simplerecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SimplePack.modid, name = "Simple Recipes", version = "1.9.0")
public class SimplePack 
{
	public static final String modid = "wuppy29_simplerecipes";
	
	public static final int VERSION = 5;
	public static String updates = "";
	public static boolean outdated = false;
	
	public static boolean checkForUpdates = true;
	
	public static boolean craftClay = true;
	public static boolean craftMossyC = true;
	public static boolean craftWeb = true;
	public static boolean craftObsidian = true;
	public static boolean craftGravel = true;
	public static boolean craftSponge = true;
	public static boolean craftIce = true;
	public static boolean craftStoneBrickMossy = true;
	public static boolean craftGrass = true;
	public static boolean craftBone = true;
	public static boolean craftStoneBrickCracked = true;
	public static boolean craftRedstone = true;
	public static boolean craftGlowstone = true;
	public static boolean craftBook = true;
	public static boolean craftDye = true;
	public static boolean craftArrow = true;
	public static boolean craftString = true;
	public static boolean craftMycelium = true;
	public static boolean craftPackedIce = true;
	public static boolean craftLead = true;
	public static boolean craftSaddle = true;
	public static boolean craftGrass2 = true;
	public static boolean craftNetherBrick = true;
	public static boolean craftStoneBrick3 = true;
	public static boolean craftLeather = true;
	public static boolean craftFlint = true;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		checkForUpdates = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);
		
		craftClay = config.get(Configuration.CATEGORY_GENERAL, "craftClay", true).getBoolean(true);
		craftMossyC = config.get(Configuration.CATEGORY_GENERAL, "craftMossyC", true).getBoolean(true);
		craftWeb = config.get(Configuration.CATEGORY_GENERAL, "craftWeb", true).getBoolean(true);
		craftObsidian = config.get(Configuration.CATEGORY_GENERAL, "craftObsidian", true).getBoolean(true);
		craftGravel = config.get(Configuration.CATEGORY_GENERAL, "craftGravel", true).getBoolean(true);
		craftSponge = config.get(Configuration.CATEGORY_GENERAL, "craftSponge", true).getBoolean(true);
		craftIce = config.get(Configuration.CATEGORY_GENERAL, "craftIce", true).getBoolean(true);
		craftStoneBrickMossy = config.get(Configuration.CATEGORY_GENERAL, "craftStoneBrickMossy", true).getBoolean(true);
		craftGrass = config.get(Configuration.CATEGORY_GENERAL, "craftGrass", true).getBoolean(true);
		craftBone = config.get(Configuration.CATEGORY_GENERAL, "craftBone", true).getBoolean(true);
		craftStoneBrickCracked = config.get(Configuration.CATEGORY_GENERAL, "craftStoneBrickCracked", true).getBoolean(true);
		craftRedstone = config.get(Configuration.CATEGORY_GENERAL, "craftRedstone", true).getBoolean(true);
		craftGlowstone = config.get(Configuration.CATEGORY_GENERAL, "craftGlowstone", true).getBoolean(true);
		craftBook = config.get(Configuration.CATEGORY_GENERAL, "craftBook", true).getBoolean(true);
		craftDye = config.get(Configuration.CATEGORY_GENERAL, "craftDye", true).getBoolean(true);
		craftArrow = config.get(Configuration.CATEGORY_GENERAL, "craftArrow", true).getBoolean(true);
		craftString = config.get(Configuration.CATEGORY_GENERAL, "craftString", true).getBoolean(true);
		craftMycelium = config.get(Configuration.CATEGORY_GENERAL, "craftMycelium", true).getBoolean(true);
		craftPackedIce = config.get(Configuration.CATEGORY_GENERAL, "craftPackedIce", true).getBoolean(true);
		craftLead = config.get(Configuration.CATEGORY_GENERAL, "craftLead", true).getBoolean(true);
		craftSaddle = config.get(Configuration.CATEGORY_GENERAL, "craftSaddle", true).getBoolean(true);
		craftGrass2 = config.get(Configuration.CATEGORY_GENERAL, "craftGrass2", true).getBoolean(true);
		craftNetherBrick = config.get(Configuration.CATEGORY_GENERAL, "craftNetherBrick", true).getBoolean(true);
		craftStoneBrick3 = config.get(Configuration.CATEGORY_GENERAL, "craftStoneBrick3", true).getBoolean(true);
		craftLeather = config.get(Configuration.CATEGORY_GENERAL, "craftLeather", true).getBoolean(true);
		craftFlint = config.get(Configuration.CATEGORY_GENERAL, "craftFlint", true).getBoolean(true);

		config.save();

		if (checkForUpdates)
			UpdateChecker.checkForUpdates();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		if(craftClay)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.clay, 4), new Object[]
			{
				"ZXZ", "XCX", "ZXZ", 'Z', new ItemStack(Items.dye, 1, 15), 'C', Items.water_bucket, 'X', Blocks.sand
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.clay, 4), new Object[]
			{
				"ZXZ", "XCX", "ZXZ", 'Z', Blocks.sand, 'C', Items.water_bucket, 'X', new ItemStack(Items.dye, 1, 15)
			});
		}
		if(craftMossyC)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1), new Object[]
			{
				" X ", "XZX", " X ", 'Z', Blocks.cobblestone, 'X', Blocks.vine
			});
		}
		if(craftWeb)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.web, 5), new Object[]
			{
				"X X", " X ", "X X", 'X', Items.string
			});
		}
		if(craftObsidian)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 1), new Object[]
			{
				new ItemStack(Items.water_bucket), new ItemStack(Items.lava_bucket)
			});
		}
		if(craftGravel)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gravel, 2), new Object[]
			{
				new ItemStack(Items.flint), new ItemStack(Blocks.cobblestone)
			});
		}
		if(craftSponge)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.sponge, 4), new Object[]
			{
				" X ", "XZX", " X ", 'X', new ItemStack(Blocks.wool, 1, 4), 'Z', Items.water_bucket
			});
		}
		if(craftIce)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.ice, 1), new Object[]
			{
				" X ", "XZX", " X ", 'X', Items.snowball, 'Z', Items.water_bucket
			});
		}
		if(craftStoneBrickMossy)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new Object[]
			{
				" X ", "XZX", " X ", 'Z', new ItemStack(Blocks.stonebrick, 1, 0), 'X', Blocks.vine
			});
		}
		if(craftGrass)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass), new Object[]
			{
				new ItemStack(Blocks.dirt), new ItemStack(Blocks.vine)
			});
		}
		if(craftBone)
		{
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
		}
		if(craftStoneBrickCracked)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 2), new Object[]
			{
				new ItemStack(Items.flint), new ItemStack(Blocks.stonebrick)
			});
		}
		if(craftRedstone)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone, 2), new Object[]
			{
				new ItemStack(Items.glowstone_dust), new ItemStack(Items.dye, 1, 1)
			});
		}
		if(craftGlowstone)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust, 2), new Object[]
			{
				new ItemStack(Items.redstone), new ItemStack(Items.dye, 1, 11)
			});
		}
		if(craftBook)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.book, 1), new Object[] 
			{
				new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Blocks.wool)
			});
		}
		if(craftDye)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 0), new Object[]
			{
				new ItemStack(Items.coal)
			});
		}
		if(craftArrow)
		{
			GameRegistry.addRecipe(new ItemStack(Items.arrow, 2), new Object[]
			{
				"XCX",
				" V ",
				" B ",
				'X', Blocks.leaves, 'C', Items.string, 'V', Items.stick, 'B', Items.flint
			});
		}
		if(craftString)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new Object[]
			{
				Blocks.wool
			});
		}
		if(craftMycelium)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mycelium), new Object[]
			{
				Blocks.brown_mushroom, Blocks.red_mushroom, Blocks.dirt
			});
		}
		if(craftPackedIce)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.packed_ice), new Object[]
			{
				Blocks.ice, Blocks.ice, Blocks.ice, Blocks.ice
			});
		}
		if(craftLead)
		{
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
		}
		if(craftSaddle)
		{
			GameRegistry.addRecipe(new ItemStack(Items.saddle), new Object[]
			{
				"XYX",
				"X X",
				"X X",
				'X', Items.leather, 'Y', Items.iron_ingot
			});
		}
		if(craftGrass2)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dirt, 1, 2), new Object[]
			{
				Blocks.dirt, Blocks.leaves
			});
		}
		if(craftNetherBrick)
			GameRegistry.addSmelting(Blocks.netherrack, new ItemStack(Blocks.nether_brick), 0.1F);
		if(craftStoneBrick3)
			GameRegistry.addSmelting(Blocks.stonebrick, new ItemStack(Blocks.stonebrick, 1, 3), 0.1F);
		if(craftLeather)
			GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1F);
		if(craftFlint)
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