package com.wuppy.slimedungeons.blocks;

import com.wuppy.slimedungeons.SlimeDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSlimeCobble extends Block {
	private String name = "slimecobble";

	public BlockSlimeCobble() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);
		setUnlocalizedName(SlimeDungeon.MODID + "_" + name);
	}

	public String getName() {
		return name;
	}
}