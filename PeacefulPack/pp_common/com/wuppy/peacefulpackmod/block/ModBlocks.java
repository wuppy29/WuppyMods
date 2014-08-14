package com.wuppy.peacefulpackmod.block;

import net.minecraft.block.Block;

import com.wuppy.peacefulpackmod.item.ItemPeacefulOresblock;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block oreblock;
	public static Block flax;
	public static Block slimeslab;
	public static Block rottenplant;
	public static Block blazelog;
	public static Block blazeleaves;
	public static Block ghastore;
	public static Block enderclam;
	public static Block blazeSapling;
	public static Block remains;

	public static void init()
	{
		oreblock = new BlockPeacefulOres();
		flax = new Blockflax();
		slimeslab = new Blockslime();
		rottenplant = new BlockRottenPlant();
		blazelog = new BlockBlazelog();
		blazeleaves = new BlockBlazeleaves("blazeleaves");
		ghastore = new BlockGhastOre();
		enderclam = new BlockEnderclam();
		blazeSapling = new BlockBlazeSapling();
		remains = new BlockBuriedRemains();

		GameRegistry.registerBlock(oreblock, ItemPeacefulOresblock.class, "Wuppy29_OreBlocks");
		GameRegistry.registerBlock(flax, "Wuppy29_Flax");
		GameRegistry.registerBlock(slimeslab, "Wuppy29_SlimeSlab");
		GameRegistry.registerBlock(rottenplant, "Wuppy29_ RottenPlant");
		GameRegistry.registerBlock(blazelog, "Wuppy29_BlazeLog");
		GameRegistry.registerBlock(blazeleaves, "Wuppy29_BlazeLeaves");
		GameRegistry.registerBlock(ghastore, "Wuppy29_GhastOre");
		GameRegistry.registerBlock(enderclam, "Wuppy29_EnderClam");
		GameRegistry.registerBlock(blazeSapling, "Wuppy29_BlazeSapling");
		GameRegistry.registerBlock(remains, "Wuppy29_Remains");
	}
}