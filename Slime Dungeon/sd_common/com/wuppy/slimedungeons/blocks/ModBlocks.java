package com.wuppy.slimedungeons.blocks;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block slimeCobble;
	public static Block slimeBlock;
	
	public static void init()
	{
		slimeCobble = new BlockSlimeCobble();
		slimeBlock = new BlockSlimeBlock();

		GameRegistry.registerBlock(slimeBlock, "SlimeBlock");
		GameRegistry.registerBlock(slimeCobble, "SlimeCobble");
	}
}