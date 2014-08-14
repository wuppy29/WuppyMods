package com.wuppy.frozen.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

import com.wuppy.frozen.FrozenCraft;
import com.wuppy.frozen.items.ModItems;

public class BlockHardIce extends Block
{
	public BlockHardIce()
	{
		super(Material.ice);
		setBlockName("hardIce");
		setBlockTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(500F);
		setLightOpacity(3);
		setStepSound(soundTypeGlass);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		if(rand.nextInt(20) == 0)
			return ModItems.frozenHeart;
		else
			return null;
	}
	
	public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
		if(player.getHeldItem().getItem() == ModItems.iceSaw)
			return true;
		else
			return false;
    }
}