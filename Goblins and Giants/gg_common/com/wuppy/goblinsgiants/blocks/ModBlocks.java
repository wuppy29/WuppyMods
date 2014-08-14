package com.wuppy.goblinsgiants.blocks;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.items.ItemCustomStone;
import com.wuppy.goblinsgiants.items.ItemOreBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks
{
	public static Block goblinportal;
	public static Block redcactus;
	public static Block oreblock;
	public static Block customstone;
	public static Block savannahtnt;
	public static Block customWood;

	public static void init()
	{
		GoblinGiant.proxy.registerBlockRenders();
		
		goblinportal = new BlockGoblinPortal();
		redcactus = new BlockRedCactus();
		oreblock = new BlockOreBlock();
		customstone = new BlockCustomStone();
		savannahtnt = new BlockSavannahTNT();
		customWood = new BlockCustomWood();

		GameRegistry.registerBlock(goblinportal, "Wuppy29_GoblinPortal");
		GameRegistry.registerBlock(redcactus, "Wuppy29_RedCactus");
		GameRegistry.registerBlock(oreblock, ItemOreBlock.class, "Wuppy29_OreBlock");
		GameRegistry.registerBlock(customstone, ItemCustomStone.class, "Wuppy29_customstone");
		GameRegistry.registerBlock(savannahtnt, "Wuppy29_SavannahTnt");
		GameRegistry.registerBlock(customWood, "Wuppy29_customWood");
	}
}