package peacefulpackmod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEnderclam extends Block
{
	public BlockEnderclam(int id)
    {
        super(id, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return Item.enderPearl.itemID;
    }
    
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
		iconArray = new Icon[4];
		for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
        }
    }
	
	public Icon getIcon(int par1, int par2)
    {
        if(par1 == 0)
        	return iconArray[0];
        else if(par1 == 1)
        	return iconArray[3];
        else if(par1 == 2 || par1 == 3)
        	return iconArray[1];
        else
        	return iconArray[2];
    }
	
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        
        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
        	int var8 = 0;
        	
        	var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
        	
        	this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
}
