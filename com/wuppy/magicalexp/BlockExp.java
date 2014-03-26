package com.wuppy.magicalexp;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExp extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public BlockExp()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
		icons = new IIcon[2];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(MagicalExperience.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return icons[par2];
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		if (par1 == 0)
		{
			return MagicalExperience.components;
		}
		else
			return null;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote && par5 == 1)
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(par1World);
            entitysilverfish.setLocationAndAngles((double)par2 + 0.5D, par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
            
            for (int i = 3 + par1World.rand.nextInt(5) + par1World.rand.nextInt(5); i > 0;)
            {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                par1World.spawnEntityInWorld(new EntityXPOrb(par1World, par2, par3, par4, j));
            }
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 2; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}