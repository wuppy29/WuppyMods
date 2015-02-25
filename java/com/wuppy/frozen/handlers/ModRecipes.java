package com.wuppy.frozen.handlers;

import com.wuppy.frozen.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void loadRecipes() {
		//Standard Items
		GameRegistry.addRecipe(new ItemStack(ModItems.iceSaw),
				"  Z",
				" XC",
				"XC ",
				'Z', Blocks.planks, 'X', Items.iron_ingot, 'C', Items.quartz
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.elsaGlove),
				"ZXZ",
				"XCX",
				"Z Z",
				'Z', Items.diamond, 'X', Items.snowball, 'C', Items.leather
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.hansSword),
				" Z ",
				"XZX",
				" C ",
				'Z', Items.iron_ingot, 'X', Items.gold_ingot, 'C', Items.stick
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.kristoffPickaxe),
				"ZXZ",
				" CZ",
				" C ",
				'Z', Items.iron_ingot, 'X', Blocks.snow, 'C', Items.stick
		);

		//Elsa Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.elsaTiara),
				" Z ",
				"XCX",
				"XXX",
				'Z', Blocks.ice, 'X', Items.gold_ingot, 'C', Items.diamond
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.elsaBodice),
				"ZZZ",
				"XCX",
				"XXX",
				'Z', Items.diamond, 'X', Blocks.ice, 'C', ModItems.frozenHeart
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.elsaSkirt),
				"ZXZ",
				"X X",
				"X X",
				'Z', Items.diamond, 'X', Blocks.ice
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.elsaHeels),
				"Z Z",
				"X X",
				'Z', Items.diamond, 'X', Blocks.ice
		);

		//Anna Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.annaCap),
				"ZXZ",
				"ZCZ",
				'Z', new ItemStack(Blocks.wool, 1, 2), 'X', new ItemStack(Blocks.wool, 1, 0), 'C', Items.diamond
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.annaBodice),
				"Z Z",
				"XCX",
				"VXV",
				'Z', new ItemStack(Blocks.wool, 1, 2), 'X', Items.diamond, 'C', ModItems.frozenHeart, 'V', new ItemStack(Blocks.wool, 1, 11)
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.annaSkirt),
				"ZXZ",
				"Z Z",
				"C C",
				'Z', new ItemStack(Blocks.wool, 1, 11), 'X', new ItemStack(Blocks.wool, 1, 12), 'C', Items.diamond
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.annaBoots),
				"Z Z",
				"X X",
				"C C",
				'Z', Items.leather, 'X', new ItemStack(Blocks.wool, 1, 15), 'C', Items.diamond
		);

		//Kristoff Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.kristoffCap),
				" Z ",
				"XCX",
				"VVV",
				'Z', new ItemStack(Blocks.wool, 1, 15), 'X', new ItemStack(Blocks.wool, 1, 7), 'C', Items.diamond, 'V', new ItemStack(Blocks.wool, 1, 8)
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.kristoffJacket),
				"Z Z",
				"XZX",
				"CCC",
				'Z', new ItemStack(Blocks.wool, 1, 7), 'X', Items.diamond, 'C', new ItemStack(Blocks.wool, 1, 14)
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.kristoffPants),
				"ZZZ",
				"X X",
				"C C",
				'Z', new ItemStack(Blocks.wool, 1, 8), 'X', new ItemStack(Blocks.wool, 1, 7), 'C', Items.diamond
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.kristoffBoots),
				"Z Z",
				"X X",
				'Z', Items.diamond, 'X', new ItemStack(Blocks.wool, 1, 7)
		);

		//Hans Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.hansHair),
				"ZZZ",
				"ZXZ",
				'Z', new ItemStack(Blocks.wool, 1, 1), 'X', Items.diamond
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.hansTop),
				"Z Z",
				"XCX",
				"CZC",
				'Z', new ItemStack(Blocks.wool, 1, 0), 'X', new ItemStack(Blocks.wool, 1, 15), 'C', Items.diamond
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.hansPants),
				"ZZZ",
				"X X",
				"C C",
				'Z', new ItemStack(Blocks.wool, 1, 15), 'X', Items.diamond, 'C', new ItemStack(Blocks.wool, 1, 9)
		);
		GameRegistry.addRecipe(new ItemStack(ModItems.hansBoots),
				"Z Z",
				"X X",
				"X X",
				'Z', Items.diamond, 'X', new ItemStack(Blocks.wool, 1, 15)
		);
	}
}