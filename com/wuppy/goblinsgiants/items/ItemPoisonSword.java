package com.wuppy.goblinsgiants.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPoisonSword extends ItemSword
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	private Item dropped;

	public ItemPoisonSword(ToolMaterial enumToolMaterial, Item drop)
	{
		super(enumToolMaterial);
		this.dropped = drop;
		this.maxStackSize = 1;
		this.setMaxDamage(enumToolMaterial.getMaxUses());
		this.setCreativeTab(ModTabs.ggWeaponsTab);
	}
	
	@Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        
        if(par1ItemStack.getItemDamage() > 59)
        {
        	par3EntityLivingBase.dropItem(dropped, 1);
        	par1ItemStack.damageItem(1, par3EntityLivingBase);
        }
        
        return true;
    }


	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[6];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + " " + (i + 1));
		}
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		if (par1 >= 50)
		{
			return icons[0];
		}
		if (par1 >= 40)
		{
			return icons[1];
		}
		if (par1 >= 30)
		{
			return icons[2];
		}
		if (par1 >= 20)
		{
			return icons[3];
		}
		if (par1 >= 10)
		{
			return icons[4];
		}
		if (par1 >= 0)
		{
			return icons[5];
		}
		else
			return icons[0];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 6; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4 * 10));
		}
	}
}