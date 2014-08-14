package com.wuppy.frozen.blocks;

import com.wuppy.frozen.handlers.RegisterHelper;

import net.minecraft.block.Block;

public class ModBlocks
{
	public static Block iceVine;
	public static Block boltObsidian;
	public static Block hardIce;
	
	public static void loadBlocks()
	{
		iceVine = new BlockIceVine();
		boltObsidian = new BlockBoltObsidian();
		hardIce = new BlockHardIce();
		
		RegisterHelper.registerBlock(iceVine);
		RegisterHelper.registerBlock(boltObsidian);
		RegisterHelper.registerBlock(hardIce);
	}
}