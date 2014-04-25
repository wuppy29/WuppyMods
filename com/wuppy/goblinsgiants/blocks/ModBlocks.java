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
		
		goblinportal = new BlockGoblinPortal().setHardness(-1F).setStepSound(Block.soundTypeGrass).setLightLevel(0.75F).setBlockName("savportal");
		redcactus = new BlockRedCactus().setHardness(0.4F).setStepSound(Block.soundTypeCloth).setBlockName("red cactus");
		oreblock = new BlockOreBlock().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("oreblock");
		customstone = new BlockCustomStone().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("customstone");
		savannahtnt = new BlockSavannahTNT().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("savannahtnt");
		customWood = new BlockCustomWood().setHardness(2.0F).setStepSound(Block.soundTypeWood).setBlockName("customwood");

		GameRegistry.registerBlock(goblinportal, "Wuppy29_GoblinPortal");
		GameRegistry.registerBlock(redcactus, "Wuppy29_RedCactus");
		GameRegistry.registerBlock(oreblock, ItemOreBlock.class, "Wuppy29_OreBlock");
		GameRegistry.registerBlock(customstone, ItemCustomStone.class, "Wuppy29_customstone");
		GameRegistry.registerBlock(savannahtnt, "Wuppy29_SavannahTnt");
		GameRegistry.registerBlock(customWood, "Wuppy29_customWood");
	}
}