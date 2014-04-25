package com.wuppy.goblinsgiants.recipes;

import com.wuppy.goblinsgiants.blocks.ModBlocks;
import com.wuppy.goblinsgiants.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public static void init()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone, 1), new Object[] { new ItemStack(ModItems.component, 1, 0) });

		// bonespear
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.component, 1, 3), new Object[] { new ItemStack(ModItems.component, 1, 0), new ItemStack(ModItems.component, 1, 2) });

		GameRegistry.addRecipe(new ItemStack(ModItems.bonespear, 8), new Object[] { "X", "Z", "C", 'X', new ItemStack(ModItems.component, 1, 1), 'Z', new ItemStack(ModItems.component, 1, 3), 'C', Items.feather });

		// Poison bottle
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.component, 2, 4), new Object[] { new ItemStack(Items.spider_eye), new ItemStack(Items.potionitem, 1, 0), new ItemStack(ModItems.component, 1, 0) });

		//tnt
		GameRegistry.addRecipe(new ItemStack(ModBlocks.savannahtnt), new Object[] { "XCX", "CXC", "XCX", 'X', Blocks.sand, 'C', new ItemStack(ModItems.component, 1, 5) });

		new PoisonSwordRecipeAdder();
	}
}
