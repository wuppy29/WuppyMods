package com.wuppy.frozen.generation;

import java.util.Random;

import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wuppy.frozen.blocks.BlockIceVine;
import com.wuppy.frozen.blocks.ModBlocks;

public class WorldGenIceVines extends WorldGenerator
{
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
        for (; pos.getY() < 128; pos = pos.up())
        {
            if (worldIn.isAirBlock(pos))
            {
                EnumFacing[] aenumfacing = EnumFacing.Plane.HORIZONTAL.facings();
                int i = aenumfacing.length;

                for (int j = 0; j < i; ++j)
                {
                    EnumFacing enumfacing = aenumfacing[j];

                    if (ModBlocks.iceVine.canPlaceBlockOnSide(worldIn, pos, enumfacing) && worldIn.getBiomeGenForCoords(pos).getTempCategory() == BiomeGenBase.TempCategory.COLD)
                    {
                        IBlockState iblockstate = ModBlocks.iceVine.getDefaultState().withProperty(BlockIceVine.SOUTH, Boolean.valueOf(enumfacing == EnumFacing.NORTH)).withProperty(BlockIceVine.WEST, Boolean.valueOf(enumfacing == EnumFacing.EAST)).withProperty(BlockIceVine.NORTH, Boolean.valueOf(enumfacing == EnumFacing.SOUTH)).withProperty(BlockIceVine.EAST, Boolean.valueOf(enumfacing == EnumFacing.WEST));
                        worldIn.setBlockState(pos, iblockstate, 2);
                        break;
                    }
                }
            }
            else
            {
                pos = pos.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
            }
        }

        return true;
    }
}