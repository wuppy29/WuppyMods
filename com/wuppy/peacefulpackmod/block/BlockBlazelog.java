package com.wuppy.peacefulpackmod.block;
import com.wuppy.peacefulpackmod.PeacefulPack;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlazelog extends BlockLog
{
	public IIcon getIcon(int par1, int par2)
    {
        if(par1 == 0 || par1 == 1)
        	return iconArray[1];
        else
        	return iconArray[0];
    }
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
    {
		iconArray = new IIcon[2];
		for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
        }
    }
}