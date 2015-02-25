package com.wuppy.frozen.items;

import com.wuppy.frozen.FrozenCraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemElsaGlove extends Item {
	private final String name = "elsaGlove";

	public ItemElsaGlove() {
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxDamage(1000);
	}

	public String getName() {
		return name;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote) {
			par2World.spawnEntityInWorld(new EntitySnowball(par2World, par3EntityPlayer));
		}

		par1ItemStack.damageItem(1, par3EntityPlayer);

		return par1ItemStack;
	}
}