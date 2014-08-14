package com.wuppy.peacefulpackmod.item;

import com.wuppy.peacefulpackmod.block.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ModItems
{
	public static Item sulphDust;
	public static Item niterDust;
	public static Item flaxfibre;
	public static Item cloth;
	public static Item flaxseed;
	public static Item cookedflesh;
	public static Item chain;
	public static Item rottenseed;

	public static void init()
	{
		sulphDust = new ItemDust("sulphdust");
		niterDust = new ItemDust("niterdust");
		flaxfibre = new ItemDust("flaxfibre");
		cloth = new ItemDust("cloth");
		flaxseed = new ItemPeaceufulSeed(ModBlocks.flax, Blocks.grass, "flaxseed");
		cookedflesh = new ItemCookedFlesh(4, 5, true);
		chain = new ItemDust("chain");
		rottenseed = new ItemPeaceufulSeed(ModBlocks.rottenplant, Blocks.netherrack, "rottenseed");

		GameRegistry.registerItem(sulphDust, "Wuppy29_SulphDust");
		GameRegistry.registerItem(niterDust, "Wuppy29_NiterDust");
		GameRegistry.registerItem(flaxfibre, "Wuppy29_FlaxFibre");
		GameRegistry.registerItem(cloth, "Wuppy29_Cloth");
		GameRegistry.registerItem(flaxseed, "Wuppy29_FlaxSeed");
		GameRegistry.registerItem(cookedflesh, "Wuppy29_CookedFlesh");
		GameRegistry.registerItem(chain, "Wuppy29_Chain");
		GameRegistry.registerItem(rottenseed, "Wuppy29_RottenSeed");
	}
}