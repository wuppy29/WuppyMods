package com.wuppy.goblinsgiants.worldgen;


import java.util.Random;

import com.wuppy.goblinsgiants.entity.EntityDwarf;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDwarfHouse extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		int var17 = 0;

		if(par1World.getBiomeGenForCoords(par3, par5) == BiomeGenBase.ocean)
		{
			return false;
		}

		if (par4 < 45 && par2Random.nextInt(20)==0 && par4 > 10)
		{
			Block stone = Blocks.stone;

			while (par1World.isAirBlock(par3, par4, par5))
	        {
				if(par4 > 10)
				{
					--par4;
				}
	        }

			if(par1World.getBlock(par3, par4 + 1, par5) == Blocks.water || par1World.getBlock(par3, par4 + 1, par5) == Blocks.flowing_water)
			{
				return false;
			}

			//floor
			for (int floor = -1; floor <= 12; floor++)
			{
				par1World.setBlock(par3 - 3, par4, par5 + floor, stone);
				par1World.setBlock(par3 - 2, par4, par5 + floor, stone);
				par1World.setBlock(par3 - 1, par4, par5 + floor, stone);
				par1World.setBlock(par3, par4, par5 + floor, stone);
				par1World.setBlock(par3 + 1, par4, par5 + floor, stone);
				par1World.setBlock(par3 + 2, par4, par5 + floor, stone);
				par1World.setBlock(par3 + 3, par4, par5 + floor, stone);

				//air
				for (int air = 1; air <= 4; air++)
				{
					par1World.setBlock(par3 - 3, par4 + air, par5 + floor, Blocks.air);
					par1World.setBlock(par3 - 2, par4 + air, par5 + floor, Blocks.air);
					par1World.setBlock(par3 - 1, par4 + air, par5 + floor, Blocks.air);
					par1World.setBlock(par3, par4 + air, par5 + floor, Blocks.air);
					par1World.setBlock(par3 + 1, par4 + air, par5 + floor, Blocks.air);
					par1World.setBlock(par3 + 2, par4 + air, par5 + floor, Blocks.air);
					par1World.setBlock(par3 + 3, par4 + air, par5 + floor, Blocks.air);
				}
			}

			//house
			Block brick = Blocks.stonebrick;
			
			for(int wall = 1; wall <= 3; wall++)
			{
				par1World.setBlock(par3 + 1, par4 + wall, par5, brick);
				par1World.setBlock(par3, par4 + 3, par5, brick);
				par1World.setBlock(par3 - 1, par4 + wall, par5, brick);

				par1World.setBlock(par3 + 1, par4 + wall, par5 + 1, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 1, brick);
				par1World.setBlock(par3 - 1, par4 + wall, par5 + 1, brick);

				par1World.setBlock(par3 + 2, par4 + wall, par5 + 2, brick);
				par1World.setBlock(par3 + 1, par4 + 3, par5 + 2, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 2, Blocks.glowstone);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 2, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 2, brick);

				par1World.setBlock(par3 + 2, par4 + wall, par5 + 3, brick);
				par1World.setBlock(par3 + 1, par4 + 3, par5 + 3, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 3, brick);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 3, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 3, brick);

				par1World.setBlock(par3 + 1, par4 + 1, par5 + 2, Blocks.oak_stairs);
				par1World.setBlock(par3 + 1, par4 + 1, par5 + 3, Blocks.oak_stairs);

				par1World.setBlock(par3 + 3, par4 + wall, par5 + 4, brick);
				par1World.setBlock(par3 + 2, par4 + wall, par5 + 4, brick);
				par1World.setBlock(par3 + 1, par4 + 3, par5 + 4, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 4, brick);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 4, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 4, brick);

				par1World.setBlock(par3 + 3, par4 + wall, par5 + 5, brick);
				par1World.setBlock(par3 + 2, par4 + 3, par5 + 5, brick);
				par1World.setBlock(par3 + 1, par4 + 3, par5 + 5, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 5, brick);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 5, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 5, brick);

				par1World.setBlock(par3 + 3, par4 + wall, par5 + 6, brick);
				par1World.setBlock(par3 + 2, par4 + wall, par5 + 6, brick);
				par1World.setBlock(par3 + 1, par4 + wall, par5 + 6, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 6, brick);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 6, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 6, brick);

				par1World.setBlock(par3 + 1, par4 + wall, par5 + 7, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 7, brick);
				par1World.setBlock(par3 - 1, par4 + wall, par5 + 7, brick);

				par1World.setBlock(par3 + 1, par4 + wall, par5 + 8, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 8, brick);
				par1World.setBlock(par3 - 1, par4 + wall, par5 + 8, brick);
			}

			//windows
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 8, Blocks.iron_bars);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 8, Blocks.iron_bars);
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 9, Blocks.iron_bars);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 9, Blocks.iron_bars);
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 10, Blocks.iron_bars);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 10, Blocks.iron_bars);
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 11, Blocks.iron_bars);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 11, Blocks.iron_bars);

			par1World.setBlock(par3 + 2, par4 + 1, par5 + 9, brick);
			par1World.setBlock(par3 - 2, par4 + 1, par5 + 9, brick);
			par1World.setBlock(par3 + 2, par4 + 1, par5 + 10, brick);
			par1World.setBlock(par3 - 2, par4 + 1, par5 + 10, brick);

			par1World.setBlock(par3 + 2, par4 + 3, par5 + 9, brick);
			par1World.setBlock(par3 - 2, par4 + 3, par5 + 9, brick);
			par1World.setBlock(par3 + 2, par4 + 3, par5 + 10, brick);
			par1World.setBlock(par3 - 2, par4 + 3, par5 + 10, brick);

			par1World.setBlock(par3, par4 + 3, par5 + 9, brick);
			par1World.setBlock(par3 + 1, par4 + 3, par5 + 9, brick);
			par1World.setBlock(par3 - 1, par4 + 3, par5 + 9, brick);

			par1World.setBlock(par3, par4 + 3, par5 + 10, brick);
			par1World.setBlock(par3 + 1, par4 + 3, par5 + 10, brick);
			par1World.setBlock(par3 - 1, par4 + 3, par5 + 10, brick);

			par1World.setBlock(par3, par4 + 4, par5 + 10, brick);
			par1World.setBlock(par3, par4 + 5, par5 + 10, brick);

			par1World.setBlock(par3, par4 + 1, par5 + 12, brick);
			par1World.setBlock(par3, par4 + 2, par5 + 12, brick);
			par1World.setBlock(par3, par4 + 3, par5 + 12, brick);
			par1World.setBlock(par3, par4 + 4, par5 + 12, brick);
			par1World.setBlock(par3, par4 + 5, par5 + 12, brick);

			par1World.setBlock(par3 + 1, par4 + 1, par5 + 11, brick);
			par1World.setBlock(par3 + 1, par4 + 2, par5 + 11, brick);
			par1World.setBlock(par3 + 1, par4 + 3, par5 + 11, brick);
			par1World.setBlock(par3 + 1, par4 + 4, par5 + 11, brick);
			par1World.setBlock(par3 + 1, par4 + 5, par5 + 11, brick);

			par1World.setBlock(par3 - 1, par4 + 1, par5 + 11, brick);
			par1World.setBlock(par3 - 1, par4 + 2, par5 + 11, brick);
			par1World.setBlock(par3 - 1, par4 + 3, par5 + 11, brick);
			par1World.setBlock(par3 - 1, par4 + 4, par5 + 11, brick);
			par1World.setBlock(par3 - 1, par4 + 5, par5 + 11, brick);

			par1World.setBlock(par3, par4 + 4, par5 + 11, Blocks.web);
			par1World.setBlock(par3, par4 - 1, par5 + 11, stone);
			par1World.setBlock(par3, par4, par5 + 11, Blocks.lava);

			int dwarf = 0;
			if (dwarf == 0)
			{
				EntityDwarf entitydwarf = new EntityDwarf(par1World);
	            entitydwarf.setPosition(par3, par4 + 1, par5);
	            par1World.spawnEntityInWorld(entitydwarf);
	            dwarf++;
			}

			par1World.setBlock(par3 + 2, par4 + 1, par5 + 5, Blocks.chest, 0, 2);
            TileEntityChest var16 = (TileEntityChest)par1World.getTileEntity(par3 + 2, par4 + 1, par5 + 5);
            if (var16 != null)
            {
            	while (var17 < 12)
                {
                    ItemStack itemstack = pickCheckLootItem(par2Random);

                    	if (itemstack != null)
                    	{
                    		var16.setInventorySlotContents(par2Random.nextInt(var16.getSizeInventory()), itemstack);
                    	}
                    var17++;
                 }
            }
            if(var16 == null)
            {
            	System.err.println("Broken chest in dwarf house.");
            }

	        return true;
		}
		else
			return false;
	}

	private ItemStack pickCheckLootItem(Random par1Random)
    {
        int i = par1Random.nextInt(11);

        if (i == 0)
        {
            return new ItemStack(Items.iron_ingot, par1Random.nextInt(4) + 1);
        }

        if (i == 1)
        {
            return new ItemStack(Items.gold_ingot, par1Random.nextInt(2) + 1);
        }

        if (i == 2 && par1Random.nextInt(7)==0)
        {
            return new ItemStack(Items.diamond);
        }

        if (i == 3)
        {
            return new ItemStack(Items.stone_pickaxe);
        }

        if (i == 4)
        {
            return new ItemStack(Items.stone_pickaxe);
        }

        if (i == 5 && par1Random.nextInt(5)==0)
        {
            return new ItemStack(Items.iron_pickaxe);
        }

        if (i == 6 && par1Random.nextInt(15)==0)
        {
            return new ItemStack(Items.golden_pickaxe);
        }

        if (i == 7 && par1Random.nextInt(40) == 0)
        {
            return new ItemStack(Items.diamond_pickaxe);
        }

        if (i == 8)
        {
            return new ItemStack(Items.redstone, par1Random.nextInt(4) + 1);
        }

        if (i == 9)
        {
            return new ItemStack(Items.coal, par1Random.nextInt(4) + 1);
        }

        if (i == 10)
        {
            return new ItemStack(Items.dye, par1Random.nextInt(3) + 1, 4);
        }
        else
        {
            return null;
        }
    }
}
