package com.wuppy.peacefulpackmod.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.wuppy.peacefulpackmod.PeacefulPack;

public class ItemPeacefulMaterial extends Item
{
	private final String name = "peacefulMaterial";
	private final String[] metaNames = new String[]{"sulphdust", "niterdust", "flaxfibre", "cloth", "chain"};
	
    public ItemPeacefulMaterial()
    {
    	GameRegistry.registerItem(this, name);
    	setUnlocalizedName(PeacefulPack.modid + "_" + name);
    	
        setCreativeTab(PeacefulPack.ppMaterialTab);
    }
    
    public String getNameFromDamage(int damage)
    {
    	return metaNames[damage];
    }
    
    @Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return super.getUnlocalizedName() + "." + metaNames[par1ItemStack.getItemDamage()];
	}
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
    {
        for (int i = 0; i < 5; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
    
    /*@SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }*/
}