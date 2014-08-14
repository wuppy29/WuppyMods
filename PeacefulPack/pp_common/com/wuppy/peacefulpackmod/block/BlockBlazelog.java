package com.wuppy.peacefulpackmod.block;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.wuppy.peacefulpackmod.PeacefulPack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlazelog extends BlockLog
{
	public BlockBlazelog()
	{
		super();
		setResistance(1.0F);
		setBlockName("blazelog");
		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		iconArray = new IIcon[2];
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	protected IIcon getTopIcon(int p_150161_1_)
	{
		return iconArray[1];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	protected IIcon getSideIcon(int p_150163_1_)
	{
		return iconArray[0];
	}
}