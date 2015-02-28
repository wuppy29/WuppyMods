package com.wuppy.peacefulpackmod.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityDropParticleFX.LavaFactory;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.config.Config;

public class BlockGhastOre extends Block
{
	private final String name = "ghastOre";

	public BlockGhastOre()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	public String getName()
	{
		return name;
	}

	boolean brokenByPlayer = false;
	boolean lavaAround = false;

	List<Block> surroundingBlocks;

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
	{
		brokenByPlayer = true;
		surroundingBlocks = null;
		surroundingBlocks = Arrays.asList(world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).getBlock(), world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).getBlock(), world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).getBlock(), world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).getBlock(), world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock(), world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock());

		for (Block i : surroundingBlocks)
		{
			if (i.getMaterial() == Material.lava)
			{
				lavaAround = true;

				int var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);

				this.dropXpOnBlockBreak(world, pos, var8);
			}
		}
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

		Random rand = world instanceof World ? ((World) world).rand : RANDOM;
		System.out.println(brokenByPlayer + " " + lavaAround + " " + Config.lavaForGhastOres);
		if (brokenByPlayer)
		{
			if(lavaAround || !Config.lavaForGhastOres)
			{
				System.out.println("ghast tear");
				int i;
				
				if(fortune > 0)
					i = rand.nextInt(fortune);
				else
					i = 0;
				
				ret.add(new ItemStack(Items.ghast_tear, 1 + i));
			}
			else
				ret.add(new ItemStack(this));
		}

		return ret;
	}
}