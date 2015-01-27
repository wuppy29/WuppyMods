package com.wuppy.slimedungeons.helpers;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.slimedungeons.blocks.ModBlocks;

public class ModRecipes
{
	public static void init()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.slimeCobble), 
			new ItemStack(Blocks.cobblestone), new ItemStack(Items.slime_ball)
		);

		GameRegistry.addRecipe(new ItemStack(ModBlocks.slimeBlock, 2), 
			"XXX", 
			"XXX", 
			"XXX", 
			'X', Items.slime_ball
		);

		GameRegistry.addSmelting(ModBlocks.slimeCobble, new ItemStack(Items.slime_ball), 0.2F);
	}
}
