package peacefulpackmod.block;

import java.util.List;
import java.util.Random;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPeacefulOres extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockPeacefulOres(int id)
    {
        super(id, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        return this.icons[par2];
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		icons = new Icon[5];
		
		for(int i = 0; i < icons.length; i++)
		{
			if(i == 0)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":sulphur");
			if(i == 1)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":niter");
			if(i == 2)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 1");
			if(i == 3)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 2");
			if(i == 4)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 3");
		}
    }
	
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        
        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
        	int var8 = 0;
        	
        	var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 1, 3);
        	
        	this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
		if (par1 == 0)
		{
			return PeacefulPack.sulphDust.itemID;
		}
		if (par1 == 1)
		{
			return PeacefulPack.niterDust.itemID;
		}
		if (par1 == 2)
		{
			return Item.bone.itemID;
		}
		if (par1 == 3)
		{
			return Item.bone.itemID;
		}
		if (par1 == 4)
		{
			return Item.bone.itemID;
		}
		return 0;
    }
	
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 5; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
