package com.wuppy.peacefulpackmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPeacefulOresblock extends ItemBlock
{
	public ItemPeacefulOresblock(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name;
		switch (itemstack.getItemDamage())
		{
		case 0:
		{
			name = "sulphur";
			break;
		}
		case 1:
		{
			name = "niter";
			break;
		}
		case 2:
		{
			name = "fossil";
			break;
		}
		case 3:
		{
			name = "fossil";
			break;
		}
		case 4:
		{
			name = "fossil";
			break;
		}
		default:
			name = "sulphur";
		}
		return getUnlocalizedName() + "." + name;
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
}