package com.wuppy.peacefulpackmod.block;

import net.minecraft.block.BlockLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.peacefulpackmod.PeacefulPack;

public class BlockBlazeLog extends BlockLog
{
	private final String name = "blazeLog";
	
	public BlockBlazeLog()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);
		
		setCreativeTab(PeacefulPack.ppBlocksTab);
	}
	
	public String getName()
	{
		return name;
	}

	/*@SideOnly(Side.CLIENT)
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
	}*/
}