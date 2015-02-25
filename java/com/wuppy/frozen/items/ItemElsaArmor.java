package com.wuppy.frozen.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.wuppy.frozen.FrozenCraft;

public class ItemElsaArmor extends ItemArmor
{
	private int armorType;

	private String name;
	
	public ItemElsaArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		this.name = name;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		this.armorType = armorType;
		setCreativeTab(FrozenCraft.fcArmor);
	}
	
	public String getName()
	{
		return name;
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
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (itemStack.getItem() instanceof ItemElsaArmor)
		{
			if (armorType == 3)
			{
				int x = (int) player.posX;
				int y = (int) player.posY - 1;
				int z = (int) player.posZ;

				Block block = world.getBlockState(new BlockPos(new BlockPos(x, y, z))).getBlock();

				// water
				if (block == Blocks.water || block == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x, y, z), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() ==  Blocks.water || world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() ==  Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x + 1, y, z), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() ==  Blocks.water || world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x - 1, y, z), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x, y, z + 1), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x, y, z - 1), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 2, y, z)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x + 2, y, z)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x + 2, y, z), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 2, y, z)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x - 2, y, z)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x - 2, y, z), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z + 2)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x, y, z + 2)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x, y, z + 2), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z - 2)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x, y, z - 2)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x, y, z - 2), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 1, y, z + 1)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x + 1, y, z + 1)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x + 1, y, z + 1), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 1, y, z + 1)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x - 1, y, z + 1)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x - 1, y, z + 1), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 1, y, z - 1)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x + 1, y, z - 1)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x + 1, y, z - 1), Blocks.ice.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 1, y, z - 1)).getBlock() == Blocks.water || world.getBlockState(new BlockPos(x - 1, y, z - 1)).getBlock() == Blocks.flowing_water)
				{
					world.setBlockState(new BlockPos(x - 1, y, z - 1), Blocks.ice.getDefaultState());
				}

				// lava
				if (block == Blocks.lava || block == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x, y, z), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x + 1, y, z), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x - 1, y, z), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x, y, z + 1), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x, y, z - 1), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 2, y, z)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x + 2, y, z)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x + 2, y, z), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 2, y, z)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x - 2, y, z)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x - 2, y, z), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z + 2)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x, y, z + 2)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x, y, z + 2), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x, y, z - 2)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x, y, z - 2)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x, y, z - 2), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 1, y, z + 1)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x + 1, y, z + 1)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x + 1, y, z + 1), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 1, y, z + 1)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x - 1, y, z + 1)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x - 1, y, z + 1), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x + 1, y, z - 1)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x + 1, y, z - 1)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x + 1, y, z - 1), Blocks.obsidian.getDefaultState());
				}
				if (world.getBlockState(new BlockPos(x - 1, y, z - 1)).getBlock() == Blocks.lava || world.getBlockState(new BlockPos(x - 1, y, z - 1)).getBlock() == Blocks.flowing_lava)
				{
					world.setBlockState(new BlockPos(x - 1, y, z - 1), Blocks.obsidian.getDefaultState());
				}
			}
		}
	}
}