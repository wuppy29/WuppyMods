package peacefulpackmod.block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockGhastOre extends Block
{
	public BlockGhastOre()
	{
		super(Material.field_151576_e);
		this.func_149647_a(CreativeTabs.tabBlock);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

		if (brokenByPlayer)
		{
			if(lavaAround)
			{
				ret.add(new ItemStack(Items.ghast_tear));
			}
			else
				ret.add(new ItemStack(this));
		}

		return ret;
	}

	boolean brokenByPlayer = false;
	boolean lavaAround = false;

	List<Block> surroundingBlocks;

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l)
	{
		brokenByPlayer = true;
		surroundingBlocks = null;
		surroundingBlocks = Arrays.asList(world.func_147439_a(x + 1, y, z), world.func_147439_a(x - 1, y, z), world.func_147439_a(x, y, z + 1), world.func_147439_a(x, y, z - 1), world.func_147439_a(x, y + 1, z), world.func_147439_a(x, y - 1, z));

		for (Block i : surroundingBlocks)
		{
			if (i == Blocks.flowing_lava || i == Blocks.lava)
			{
				lavaAround = true;
				int var8 = 0;

				var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);

				this.func_149657_c(world, x, y, z, var8);
			}
		}
	}

	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
}