package com.wuppy.slimedungeons.generation;

import com.wuppy.slimedungeons.SlimeDungeon;
import com.wuppy.slimedungeons.blocks.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSlimeDungeon extends WorldGenerator {
	@Override
	public boolean generate(World par1World, Random par2Random, BlockPos position) {
		byte var6 = 3;
		int var7 = par2Random.nextInt(2) + 2;
		int var8 = par2Random.nextInt(2) + 2;
		int var9 = 0;
		int var10;
		int var11;
		int var12;

		for (var10 = position.getX() - var7 - 1; var10 <= position.getX() + var7 + 1; ++var10) {
			for (var11 = position.getY() - 1; var11 <= position.getY() + var6 + 1; ++var11) {
				for (var12 = position.getZ() - var8 - 1; var12 <= position.getZ() + var8 + 1; ++var12) {
					Material var13 = par1World.getBlockState(position).getBlock().getMaterial();

					if (var11 == position.getY() - 1 && !var13.isSolid()) {
						return false;
					}

					if (var11 == position.getY() + var6 + 1 && !var13.isSolid()) {
						return false;
					}

					if ((var10 == position.getX() - var7 - 1 || var10 == position.getX() + var7 + 1 || var12 == position.getZ() - var8 - 1 || var12 == position.getZ() + var8 + 1) && var11 == position.getY() && par1World.isAirBlock(new BlockPos(var10, var11, var12)) && par1World.isAirBlock(new BlockPos(var10, var11 + 1, var12))) {
						++var9;
					}
				}
			}
		}

		if (var9 >= 1 && var9 <= 5) {
			for (var10 = position.getX() - var7 - 1; var10 <= position.getX() + var7 + 1; ++var10) {
				for (var11 = position.getY() + var6; var11 >= position.getY() - 1; --var11) {
					for (var12 = position.getZ() - var8 - 1; var12 <= position.getZ() + var8 + 1; ++var12) {
						if (var10 != position.getX() - var7 - 1 && var11 != position.getY() - 1 && var12 != position.getZ() - var8 - 1 && var10 != position.getX() + var7 + 1 && var11 != position.getY() + var6 + 1 && var12 != position.getZ() + var8 + 1) {
							par1World.setBlockToAir(new BlockPos(var10, var11, var12));
						} else if (var11 >= 0 && !par1World.getBlockState(new BlockPos(var10, var11 - 1, var12)).getBlock().getMaterial().isSolid()) {
							par1World.setBlockToAir(new BlockPos(var10, var11, var12));
						} else if (par1World.getBlockState(new BlockPos(var10, var11, var12)).getBlock().getMaterial().isSolid()) {
							if (var11 == position.getY() - 1 && par2Random.nextInt(4) != 0) {
								par1World.setBlockState(new BlockPos(var10, var11, var12), ModBlocks.slimeBlock.getDefaultState());
							} else {
								par1World.setBlockState(new BlockPos(var10, var11, var12), ModBlocks.slimeCobble.getDefaultState());
							}
						}
					}
				}
			}

			var10 = 0;

			while (var10 < 2) {
				var11 = 0;

				while (true) {
					if (var11 < 3) {
						label210:
						{
							var12 = position.getX() + par2Random.nextInt(var7 * 2 + 1) - var7;
							int var14 = position.getZ() + par2Random.nextInt(var8 * 2 + 1) - var8;

							if (par1World.isAirBlock(new BlockPos(var12, position.getY(), var14))) {
								int var15 = 0;

								if (par1World.getBlockState(new BlockPos(var12 - 1, position.getY(), var14)).getBlock().getMaterial().isSolid()) {
									++var15;
								}

								if (par1World.getBlockState(new BlockPos(var12 + 1, position.getY(), var14)).getBlock().getMaterial().isSolid()) {
									++var15;
								}

								if (par1World.getBlockState(new BlockPos(var12, position.getY(), var14 - 1)).getBlock().getMaterial().isSolid()) {
									++var15;
								}

								if (par1World.getBlockState(new BlockPos(var12, position.getY(), var14 + 1)).getBlock().getMaterial().isSolid()) {
									++var15;
								}

								if (var15 == 1) {
									par1World.setBlockState(new BlockPos(var12, position.getY(), var14), Blocks.chest.getDefaultState());
									TileEntityChest var16 = (TileEntityChest) par1World.getTileEntity(new BlockPos(var12, position.getY(), var14));

									if (var16 != null) {
										for (int var17 = 0; var17 < 12; ++var17) {
											ItemStack var18 = this.pickCheckLootItem(par2Random);

											if (var18 != null) {
												var16.setInventorySlotContents(par2Random.nextInt(var16.getSizeInventory()), var18);
											}
										}
									}

									break label210;
								}
							}

							++var11;
							continue;
						}
					}

					++var10;
					break;
				}
			}

			par1World.setBlockState(new BlockPos(position.getX(), position.getY(), position.getZ()), Blocks.mob_spawner.getDefaultState());
			TileEntityMobSpawner spawner = (TileEntityMobSpawner) par1World.getTileEntity(position);

			if (spawner != null) {
				spawner.getSpawnerBaseLogic().setEntityName(SlimeDungeon.MODID + "." + "SlimeZombie");
			} else {
				System.err.println("Failed to fetch mob spawner entity at (" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")");
			}

			return true;
		} else {
			return false;
		}
	}

	private ItemStack pickCheckLootItem(Random par1Random) {
		int var2 = par1Random.nextInt(11);
		if (var2 == 5 && par1Random.nextInt(4) == 1)
			return new ItemStack(Items.iron_ingot);
		if (var2 == 6 && par1Random.nextInt(7) == 1)
			return new ItemStack(Items.gold_ingot);
		if (var2 == 7 && par1Random.nextInt(14) == 1)
			return new ItemStack(Items.diamond);
		if (var2 == 8)
			return new ItemStack(Items.saddle);
		if (var2 == 9)
			return new ItemStack(Items.redstone, 1 + par1Random.nextInt(5));
		if (var2 == 10)
			return new ItemStack(Items.gunpowder);
		else
			return new ItemStack(Items.slime_ball);
	}
}