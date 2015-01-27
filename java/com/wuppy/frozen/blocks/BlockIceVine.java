package com.wuppy.frozen.blocks;

import com.wuppy.frozen.FrozenCraft;

import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIceVine extends BlockVine
{
	private final String name = "iceVine";
	
	protected BlockIceVine()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setHardness(0.2F);
		setStepSound(soundTypeGrass);
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 16777215;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state)
    {
        return 16777215;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return 16777215;
    }
}