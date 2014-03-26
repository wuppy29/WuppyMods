package com.wuppy.magicalexp.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import com.wuppy.magicalexp.MagicalExperience;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicalComponents extends Item
{
	public static final String[] names = new String[] {"magicpowder", "expiron", "magicstick", "magicdirtstick", "ironnugget"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
    public ItemMagicalComponents()
    {
        super();
        this.setHasSubtypes(true);
        maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    public boolean hasEffect(ItemStack par1ItemStack)
    {
    	if (par1ItemStack.getItemDamage() == 4)
    	{
    		return false;
    	}
    	else
    		return true;
    }
    
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[var2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
		icons = new IIcon[names.length];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(MagicalExperience.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
    }
    
    public IIcon getIconFromDamage(int par1)
    {
    	return icons[par1];
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 5; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
