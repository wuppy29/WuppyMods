package goblinsgiants.blocks;


import goblinsgiants.GoblinGiant;

import java.util.List;
import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreBlock extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockOreBlock(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		icons = new Icon[9];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
    }
    
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		switch (par2)
		{
		case 0:
			if(par1 == 1)
				return icons[1];
			if(par1 == 0)
				return icons[0];
			else
				return icons[2];
		case 1:
			return icons[3];
		case 2:
			return icons[4];
		case 3:
			return icons[5];
		case 4:
			return icons[6];
		case 5:
			return icons[7];
		case 6:
			return icons[8];
		default:
			return icons[0];
		}
	}

	public int idDropped(int par1, Random par2Random, int par3)
    {
		return GoblinGiant.gem.itemID;
    }

	public int damageDropped(int par1)
    {
        return par1;
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 7; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
