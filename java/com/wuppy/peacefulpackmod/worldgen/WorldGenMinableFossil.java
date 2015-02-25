package com.wuppy.peacefulpackmod.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.google.common.base.Predicate;

public class WorldGenMinableFossil extends WorldGenerator
{
    private final IBlockState oreBlock;
    private final int numberOfBlocks;
    private final Predicate field_175919_c;
    private static final String __OBFID = "CL_00000426";

    public WorldGenMinableFossil(IBlockState p_i45630_1_, int p_i45630_2_)
    {
        this(p_i45630_1_, p_i45630_2_, BlockHelper.forBlock(Blocks.stone));
    }

    public WorldGenMinableFossil(IBlockState p_i45631_1_, int p_i45631_2_, Predicate p_i45631_3_)
    {
        this.oreBlock = p_i45631_1_;
        this.numberOfBlocks = p_i45631_2_;
        this.field_175919_c = p_i45631_3_;
    }

    @Override
    public boolean generate(World worldIn, Random p_180709_2_, BlockPos p_180709_3_)
    {
        float f = p_180709_2_.nextFloat() * (float)Math.PI;
        double d0 = (double)((float)(p_180709_3_.getX() + 8) + MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0F);
        double d1 = (double)((float)(p_180709_3_.getX() + 8) - MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0F);
        double d2 = (double)((float)(p_180709_3_.getZ() + 8) + MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0F);
        double d3 = (double)((float)(p_180709_3_.getZ() + 8) - MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0F);
        double d4 = (double)(p_180709_3_.getY() + p_180709_2_.nextInt(3) - 2);
        double d5 = (double)(p_180709_3_.getY() + p_180709_2_.nextInt(3) - 2);

        for (int i = 0; i < this.numberOfBlocks; ++i)
        {
            float f1 = (float)i / (float)this.numberOfBlocks;
            double d6 = d0 + (d1 - d0) * (double)f1;
            double d7 = d4 + (d5 - d4) * (double)f1;
            double d8 = d2 + (d3 - d2) * (double)f1;
            double d9 = p_180709_2_.nextDouble() * (double)this.numberOfBlocks / 16.0D;
            double d10 = (double)(MathHelper.sin((float)Math.PI * f1) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.sin((float)Math.PI * f1) + 1.0F) * d9 + 1.0D;
            int j = MathHelper.floor_double(d6 - d10 / 2.0D);
            int k = MathHelper.floor_double(d7 - d11 / 2.0D);
            int l = MathHelper.floor_double(d8 - d10 / 2.0D);
            int i1 = MathHelper.floor_double(d6 + d10 / 2.0D);
            int j1 = MathHelper.floor_double(d7 + d11 / 2.0D);
            int k1 = MathHelper.floor_double(d8 + d10 / 2.0D);

            for (int l1 = j; l1 <= i1; ++l1)
            {
                double d12 = ((double)l1 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D)
                {
                    for (int i2 = k; i2 <= j1; ++i2)
                    {
                        double d13 = ((double)i2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D)
                        {
                            for (int j2 = l; j2 <= k1; ++j2)
                            {
                                double d14 = ((double)j2 + 0.5D - d8) / (d10 / 2.0D);

                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D)
                                {
                                    BlockPos blockpos1 = new BlockPos(l1, i2, j2);

                                    if (worldIn.getBlockState(blockpos1).getBlock().isReplaceableOreGen(worldIn, blockpos1, this.field_175919_c))
                                    {
                                    	//TODO, add random 3 metadata
                                        worldIn.setBlockState(blockpos1, this.oreBlock, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}