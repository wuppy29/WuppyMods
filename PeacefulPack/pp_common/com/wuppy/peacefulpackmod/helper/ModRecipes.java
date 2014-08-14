package com.wuppy.peacefulpackmod.helper;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public static void init()
	{
		// smelting recipes
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(ModItems.cookedflesh, 1), 1F);

		// recipes
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slimeslab, 1), new Object[] { "XX", "XX", 'X', Items.slime_ball });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 2), new Object[] { new ItemStack(ModItems.sulphDust), new ItemStack(ModItems.niterDust), new ItemStack(Items.coal) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 2), new Object[] { new ItemStack(ModItems.sulphDust), new ItemStack(ModItems.niterDust), new ItemStack(Items.coal, 1) });
		GameRegistry.addRecipe(new ItemStack(Blocks.torch, 4), new Object[] { "X", "Z", 'X', ModItems.sulphDust, 'Z', Items.stick });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 15), new Object[] { new ItemStack(Items.dye, 1, 15), new ItemStack(ModItems.niterDust) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 2), new Object[] { new ItemStack(ModItems.flaxfibre), new ItemStack(ModItems.flaxfibre) });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.flaxseed, 3), new Object[] { new ItemStack(ModItems.flaxfibre) });
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 0), new Object[] { new ItemStack(ModItems.cloth), new ItemStack(ModItems.cloth) });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cloth, 1), new Object[] { new ItemStack(Items.string), new ItemStack(Items.string) });
		GameRegistry.addRecipe(new ItemStack(ModItems.chain, 6), new Object[] { "XXX", "XXX", "XXX", 'X', Blocks.iron_bars });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.book), new Object[] { new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(ModItems.cloth) });

		// leather armor
		GameRegistry.addRecipe(new ItemStack(Items.leather_helmet, 1), new Object[] { "XXX", "X X", 'X', ModItems.cloth });
		GameRegistry.addRecipe(new ItemStack(Items.leather_chestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', ModItems.cloth });
		GameRegistry.addRecipe(new ItemStack(Items.leather_boots, 1), new Object[] { "X X", "X X", 'X', ModItems.cloth });
		GameRegistry.addRecipe(new ItemStack(Items.leather_leggings, 1), new Object[] { "XXX", "X X", "X X", 'X', ModItems.cloth });

		// chain armor
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet, 1), new Object[] { "XXX", "X X", 'X', ModItems.chain });
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', ModItems.chain });
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots, 1), new Object[] { "X X", "X X", 'X', ModItems.chain });
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings, 1), new Object[] { "XXX", "X X", "X X", 'X', ModItems.chain });

		GameRegistry.addRecipe(new ItemStack(Items.ghast_tear, 4), new Object[] { "XXX", "XZX", "XXX", 'Z', Items.lava_bucket, 'X', ModBlocks.ghastore });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather), new Object[] { new ItemStack(ModItems.cookedflesh), new ItemStack(ModItems.cookedflesh) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.writable_book, 1), new Object[] { new ItemStack(Items.book), new ItemStack(ModItems.niterDust), new ItemStack(Items.feather) });
	}
}