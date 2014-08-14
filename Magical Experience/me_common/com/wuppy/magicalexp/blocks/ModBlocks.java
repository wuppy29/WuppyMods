package com.wuppy.magicalexp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;

import com.wuppy.magicalexp.items.ItemMagicalOresblock;
import com.wuppy.magicalexp.items.ItemSpellBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block expore;
    public static Block spell;

	public static void loadBlocks()
	{
		expore = new BlockExp();
    	spell = new BlockSpell(BlockPressurePlate.Sensitivity.everything, Material.wood);
		
    	GameRegistry.registerBlock(expore, ItemMagicalOresblock.class, "expore");
    	GameRegistry.registerBlock(spell, ItemSpellBlock.class, "spell");
	}
}