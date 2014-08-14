package com.wuppy.frozen.items;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.wuppy.frozen.FrozenCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemElsaArmor extends ItemArmor
{
	private int armorType;

	public ItemElsaArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		this.armorType = armorType;
		setCreativeTab(FrozenCraft.fcArmor);
		setUnlocalizedName(name);
		setTextureName(FrozenCraft.modid + ":" + getUnlocalizedName().substring(5));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModItems.elsaTiara)
		{
			return FrozenCraft.modid + ":models/armor/elsaArmorTiara.png";
		}
		else if (stack.getItem() == ModItems.elsaBodice)
		{
			return FrozenCraft.modid + ":models/armor/elsaArmorBodice.png";
		}
		else if (stack.getItem() == ModItems.elsaSkirt)
		{
			return FrozenCraft.modid + ":models/armor/elsaArmorSkirt.png";
		}
		else if (stack.getItem() == ModItems.elsaHeels)
		{
			return FrozenCraft.modid + ":models/armor/elsaArmorHeels.png";
		}
		else
		{
			System.out.println("Invalid Item ItemElsaArmor");
			return null;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		ModelBiped armourModel = null;
		if (itemstack != null)
		{
			if (itemstack.getItem() instanceof ItemElsaArmor)
			{
				float f = 0.12F;

				if (itemstack.getItem() == ModItems.elsaBodice)
					f = 0.15f;

				armourModel = new ModelBiped(f);
				ItemStack itemstack2 = ((EntityPlayer) entityLiving).inventory.getCurrentItem();
				armourModel.heldItemRight = itemstack2 != null ? 1 : 0;
				armourModel.isSneak = entityLiving.isSneaking();
				if (itemstack2 != null && ((EntityPlayer) entityLiving).getItemInUseCount() > 0)
				{
					EnumAction enumaction = itemstack2.getItemUseAction();
					if (enumaction == EnumAction.block)
					{
						armourModel.heldItemRight = 3;
					}
					else if (enumaction == EnumAction.bow)
					{
						armourModel.aimedBow = true;
					}
				}
			}
		}
		return armourModel;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (itemStack.getItem() instanceof ItemElsaArmor)
		{
			if (armorType == 3)
			{
				int x = (int) player.posX;
				int y = (int) player.posY - 1;
				int z = (int) player.posZ;

				Block block = world.getBlock(x, y, z);

				// water
				if (block == Blocks.water || block == Blocks.flowing_water)
				{
					world.setBlock(x, y, z, Blocks.ice);
				}
				if (world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x + 1, y, z) == Blocks.flowing_water)
				{
					world.setBlock(x + 1, y, z, Blocks.ice);
				}
				if (world.getBlock(x - 1, y, z) == Blocks.water || world.getBlock(x - 1, y, z) == Blocks.flowing_water)
				{
					world.setBlock(x - 1, y, z, Blocks.ice);
				}
				if (world.getBlock(x, y, z + 1) == Blocks.water || world.getBlock(x, y, z + 1) == Blocks.flowing_water)
				{
					world.setBlock(x, y, z + 1, Blocks.ice);
				}
				if (world.getBlock(x, y, z - 1) == Blocks.water || world.getBlock(x, y, z - 1) == Blocks.flowing_water)
				{
					world.setBlock(x, y, z - 1, Blocks.ice);
				}
				if (world.getBlock(x + 2, y, z) == Blocks.water || world.getBlock(x + 2, y, z) == Blocks.flowing_water)
				{
					world.setBlock(x + 2, y, z, Blocks.ice);
				}
				if (world.getBlock(x - 2, y, z) == Blocks.water || world.getBlock(x - 2, y, z) == Blocks.flowing_water)
				{
					world.setBlock(x - 2, y, z, Blocks.ice);
				}
				if (world.getBlock(x, y, z + 2) == Blocks.water || world.getBlock(x, y, z + 2) == Blocks.flowing_water)
				{
					world.setBlock(x, y, z + 2, Blocks.ice);
				}
				if (world.getBlock(x, y, z - 2) == Blocks.water || world.getBlock(x, y, z - 2) == Blocks.flowing_water)
				{
					world.setBlock(x, y, z - 2, Blocks.ice);
				}
				if (world.getBlock(x + 1, y, z + 1) == Blocks.water || world.getBlock(x + 1, y, z + 1) == Blocks.flowing_water)
				{
					world.setBlock(x + 1, y, z + 1, Blocks.ice);
				}
				if (world.getBlock(x - 1, y, z + 1) == Blocks.water || world.getBlock(x - 1, y, z + 1) == Blocks.flowing_water)
				{
					world.setBlock(x - 1, y, z + 1, Blocks.ice);
				}
				if (world.getBlock(x + 1, y, z - 1) == Blocks.water || world.getBlock(x + 1, y, z - 1) == Blocks.flowing_water)
				{
					world.setBlock(x + 1, y, z - 1, Blocks.ice);
				}
				if (world.getBlock(x - 1, y, z - 1) == Blocks.water || world.getBlock(x - 1, y, z - 1) == Blocks.flowing_water)
				{
					world.setBlock(x - 1, y, z - 1, Blocks.ice);
				}

				// lava
				if (block == Blocks.lava || block == Blocks.flowing_lava)
				{
					world.setBlock(x, y, z, Blocks.obsidian);
				}
				if (world.getBlock(x + 1, y, z) == Blocks.lava || world.getBlock(x + 1, y, z) == Blocks.flowing_lava)
				{
					world.setBlock(x + 1, y, z, Blocks.obsidian);
				}
				if (world.getBlock(x - 1, y, z) == Blocks.lava || world.getBlock(x - 1, y, z) == Blocks.flowing_lava)
				{
					world.setBlock(x - 1, y, z, Blocks.obsidian);
				}
				if (world.getBlock(x, y, z + 1) == Blocks.lava || world.getBlock(x, y, z + 1) == Blocks.flowing_lava)
				{
					world.setBlock(x, y, z + 1, Blocks.obsidian);
				}
				if (world.getBlock(x, y, z - 1) == Blocks.lava || world.getBlock(x, y, z - 1) == Blocks.flowing_lava)
				{
					world.setBlock(x, y, z - 1, Blocks.obsidian);
				}
				if (world.getBlock(x + 2, y, z) == Blocks.lava || world.getBlock(x + 2, y, z) == Blocks.flowing_lava)
				{
					world.setBlock(x + 2, y, z, Blocks.obsidian);
				}
				if (world.getBlock(x - 2, y, z) == Blocks.lava || world.getBlock(x - 2, y, z) == Blocks.flowing_lava)
				{
					world.setBlock(x - 2, y, z, Blocks.obsidian);
				}
				if (world.getBlock(x, y, z + 2) == Blocks.lava || world.getBlock(x, y, z + 2) == Blocks.flowing_lava)
				{
					world.setBlock(x, y, z + 2, Blocks.obsidian);
				}
				if (world.getBlock(x, y, z - 2) == Blocks.lava || world.getBlock(x, y, z - 2) == Blocks.flowing_lava)
				{
					world.setBlock(x, y, z - 2, Blocks.obsidian);
				}
				if (world.getBlock(x + 1, y, z + 1) == Blocks.lava || world.getBlock(x + 1, y, z + 1) == Blocks.flowing_lava)
				{
					world.setBlock(x + 1, y, z + 1, Blocks.obsidian);
				}
				if (world.getBlock(x - 1, y, z + 1) == Blocks.lava || world.getBlock(x - 1, y, z + 1) == Blocks.flowing_lava)
				{
					world.setBlock(x - 1, y, z + 1, Blocks.obsidian);
				}
				if (world.getBlock(x + 1, y, z - 1) == Blocks.lava || world.getBlock(x + 1, y, z - 1) == Blocks.flowing_lava)
				{
					world.setBlock(x + 1, y, z - 1, Blocks.obsidian);
				}
				if (world.getBlock(x - 1, y, z - 1) == Blocks.lava || world.getBlock(x - 1, y, z - 1) == Blocks.flowing_lava)
				{
					world.setBlock(x - 1, y, z - 1, Blocks.obsidian);
				}
			}
		}
	}
}