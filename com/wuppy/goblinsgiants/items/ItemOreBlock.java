package com.wuppy.goblinsgiants.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOreBlock extends ItemBlock
{
	public ItemOreBlock(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
			case 0:
			{
				name = "yellow";
				break;
			}
			case 1:
			{
				name = "blue";
				break;
			}
			case 2:
			{
				name = "white";
				break;
			}
			case 3:
			{
				name = "gray";
				break;
			}
			case 4:
			{
				name = "light blue";
				break;
			}
			case 5:
			{
				name = "brown";
				break;
			}
			case 6:
			{
				name = "red";
				break;
			}
			default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}

	public int getMetadata(int par1)
    {
        return par1;
    }
}
