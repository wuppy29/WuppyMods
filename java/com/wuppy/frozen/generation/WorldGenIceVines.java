package com.wuppy.frozen.generation;

import com.wuppy.frozen.blocks.BlockIceVine;
import com.wuppy.frozen.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenIceVines extends WorldGenerator {
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		for (; pos.getY() < 128; pos = pos.up()) {
			if (worldIn.isAirBlock(pos)) {
				EnumFacing[] aenumfacing = EnumFacing.Plane.HORIZONTAL.facings();

				for (EnumFacing enumfacing : aenumfacing) {
					if (ModBlocks.iceVine.canPlaceBlockOnSide(worldIn, pos, enumfacing) && worldIn.getBiomeGenForCoords(pos).getTempCategory() == BiomeGenBase.TempCategory.COLD) {
						IBlockState iblockstate = ModBlocks.iceVine.getDefaultState().withProperty(BlockIceVine.SOUTH, enumfacing == EnumFacing.NORTH).withProperty(BlockIceVine.WEST, enumfacing == EnumFacing.EAST).withProperty(BlockIceVine.NORTH, enumfacing == EnumFacing.SOUTH).withProperty(BlockIceVine.EAST, enumfacing == EnumFacing.WEST);
						worldIn.setBlockState(pos, iblockstate, 2);
						break;
					}
				}
			} else {
				pos = pos.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			}
		}

		return true;
	}
}