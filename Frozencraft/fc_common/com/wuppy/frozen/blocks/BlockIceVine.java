package com.wuppy.frozen.blocks;

import net.minecraft.block.BlockVine;
import net.minecraft.world.IBlockAccess;

import com.wuppy.frozen.FrozenCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIceVine extends BlockVine
{
	protected BlockIceVine()
	{
		super();
		setBlockName("iceVine");
		setBlockTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
		setHardness(0.2F);
		setStepSound(soundTypeGrass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 16777215;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return 16777215;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return 16777215;
    }
}