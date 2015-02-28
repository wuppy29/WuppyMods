package com.wuppy.peacefulpackmod.helper;

import com.wuppy.peacefulpackmod.block.ModBlocks;
import com.wuppy.peacefulpackmod.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public static void init()
	{
		// smelting recipes
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(ModItems.cookedFlesh, 1), 1F);

		// recipes
		GameRegistry.addRecipe(new ItemStack(ModBlocks.slimeSlab, 1), "XX", "XX", 'X', Items.slime_ball);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 2), new ItemStack(ModItems.peacefulMaterial), new ItemStack(ModItems.peacefulMaterial, 1, 1), new ItemStack(Items.coal));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder, 2), new ItemStack(ModItems.peacefulMaterial), new ItemStack(ModItems.peacefulMaterial, 1, 1), new ItemStack(Items.coal, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.torch, 4), "X", "Z", 'X', ModItems.peacefulMaterial, 'Z', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(ModItems.peacefulMaterial, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 2), new ItemStack(ModItems.peacefulMaterial, 1, 2), new ItemStack(ModItems.peacefulMaterial, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.flaxSeed, 3), new ItemStack(ModItems.peacefulMaterial, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 0), new ItemStack(ModItems.peacefulMaterial, 1, 3), new ItemStack(ModItems.peacefulMaterial, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.peacefulMaterial, 1, 3), new ItemStack(Items.string), new ItemStack(Items.string));
		GameRegistry.addRecipe(new ItemStack(ModItems.peacefulMaterial, 4, 6), "XXX", "XXX", "XXX", 'X', Blocks.iron_bars);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.book), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(ModItems.peacefulMaterial, 1, 3));

		// leather armor
		GameRegistry.addRecipe(new ItemStack(Items.leather_helmet, 1), "XXX", "X X", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Items.leather_chestplate, 1), "X X", "XXX", "XXX", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Items.leather_boots, 1), "X X", "X X", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 3));
		GameRegistry.addRecipe(new ItemStack(Items.leather_leggings, 1), "XXX", "X X", "X X", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 3));

		// chainmail armor
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet, 1), "XXX", "X X", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate, 1), "X X", "XXX", "XXX", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots, 1), "X X", "X X", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 4));
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings, 1), "XXX", "X X", "X X", 'X', new ItemStack(ModItems.peacefulMaterial, 1, 4));

		GameRegistry.addRecipe(new ItemStack(Items.ghast_tear, 4), "XXX", "XZX", "XXX", 'Z', Items.lava_bucket, 'X', ModBlocks.ghastOre);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather), new ItemStack(ModItems.cookedFlesh), new ItemStack(ModItems.cookedFlesh));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.writable_book, 1), new ItemStack(Items.book), new ItemStack(ModItems.peacefulMaterial, 1, 1), new ItemStack(Items.feather));
	}
}