package com.wuppy.magicalexp.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.wuppy.magicalexp.entity.EntityFirebottle;

public class ItemFireStaff extends ItemSword
{
    public ItemFireStaff(ToolMaterial enumToolMaterial)
    {
        super(enumToolMaterial);
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par2World.spawnEntityInWorld(new EntityFirebottle(par2World, par3EntityPlayer));
        par1ItemStack.damageItem(1, par3EntityPlayer);
        return par1ItemStack;
    }
}