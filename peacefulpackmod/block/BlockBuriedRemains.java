package peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockBuriedRemains extends Block
{
	public BlockBuriedRemains()
	{
		super(Material.field_151578_c);
		this.func_149647_a(CreativeTabs.tabBlock);
	}

	public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		return Items.rotten_flesh;
	}
}
