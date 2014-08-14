package com.wuppy.frozen.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.wuppy.frozen.FrozenCraft;

public class ItemElsaGlove extends Item
{
	// long lastUse = 0;

	public ItemElsaGlove()
	{
		super();
		setUnlocalizedName("elsaGlove");
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxDamage(1000);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		/*
		 * if(lastUse == 0) par2World.getWorldTime();
		 */

		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote/* && lastUse + 4 < par2World.getWorldTime() */)
		{
			par2World.spawnEntityInWorld(new EntitySnowball(par2World, par3EntityPlayer));
			// lastUse = par2World.getWorldTime();
		}

		par1ItemStack.damageItem(1, par3EntityPlayer);

		return par1ItemStack;
	}
}