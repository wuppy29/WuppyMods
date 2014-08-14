package com.wuppy.goblinsgiants.worldgen;


import java.util.Random;

import com.wuppy.goblinsgiants.entity.EntityDwarf;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDwarfVillage extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		if(par1World.getBiomeGenForCoords(par3, par5) == BiomeGenBase.ocean)
		{
			return false;
		}

		int chestitemshouse = 0;
		int chestitemsdungeon = 0;

		if (par4 < 45 && par2Random.nextInt(20)==0 && par4 > 15)
		{
			Block stone = Blocks.stone;

			while (par1World.isAirBlock(par3, par4, par5))
	        {
				if(par4 > 15)
				{
					--par4;
				}
	        }

			if(par1World.getBlock(par3, par4 + 1, par5) == Blocks.water || par1World.getBlock(par3, par4 + 1, par5) == Blocks.flowing_water)
			{
				return false;
			}

			//floor

			for (int floor = -8; floor <= 12; floor++)
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

			//floor links-rechts
            for (int floor = -10; floor <= 12; floor++)
			{
				par1World.setBlock(par3 + floor, par4, par5 - 2, stone);
				par1World.setBlock(par3 + floor, par4, par5 - 3, stone);
				par1World.setBlock(par3 + floor, par4, par5 - 4, stone);
				par1World.setBlock(par3 + floor, par4, par5 - 5, stone);
				par1World.setBlock(par3 + floor, par4, par5 - 6, stone);
				par1World.setBlock(par3 + floor, par4, par5 - 7, stone);
				par1World.setBlock(par3 + floor, par4, par5 - 8, stone);

				//air
				for (int air = 1; air <= 4; air++)
				{
					par1World.setBlock(par3 + floor, par4 + air, par5 - 2, Blocks.air);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 3, Blocks.air);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 4, Blocks.air);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 5, Blocks.air);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 6, Blocks.air);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 7, Blocks.air);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 8, Blocks.air);
				}
			}

			//house 1
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
            	while (chestitemshouse < 12)
                {
                    ItemStack itemstack = pickHouseLootItem(par2Random);

                    	if (itemstack != null)
                    	{
                    		var16.setInventorySlotContents(par2Random.nextInt(var16.getSizeInventory()), itemstack);
                    	}
                    chestitemshouse++;
                 }
            }
            if(var16 == null)
            {
            	System.err.println("Broken chest in dwarf house.");
            }

            //fountain

            //middle
            par1World.setBlock(par3, par4 + 1, par5 - 6, brick);
            par1World.setBlock(par3, par4 + 2, par5 - 6, brick);
            par1World.setBlock(par3, par4 + 3, par5 - 6, brick);
            par1World.setBlock(par3, par4 + 4, par5 -6, Blocks.flowing_lava);

            //sides
            par1World.setBlock(par3 + 2, par4 + 1, par5 - 4, brick, 3, 2);
            par1World.setBlock(par3 + 1, par4 + 1, par5 - 4, brick);
            par1World.setBlock(par3, par4 + 1, par5 - 4, brick);
            par1World.setBlock(par3 - 1, par4 + 1, par5 - 4, brick);
            par1World.setBlock(par3 - 2, par4 + 1, par5 - 4, brick, 3, 2);

            par1World.setBlock(par3 - 2, par4 + 1, par5 - 5, brick);
            par1World.setBlock(par3 + 2, par4 + 1, par5 - 5, brick);

            par1World.setBlock(par3 - 2, par4 + 1, par5 - 6, brick);
            par1World.setBlock(par3 + 2, par4 + 1, par5 - 6, brick);

            par1World.setBlock(par3 - 2, par4 + 1, par5 - 7, brick);
            par1World.setBlock(par3 + 2, par4 + 1, par5 - 7, brick);

            par1World.setBlock(par3 + 2, par4 + 1, par5 - 8, brick, 3, 2);
            par1World.setBlock(par3 + 1, par4 + 1, par5 - 8, brick);
            par1World.setBlock(par3, par4 + 1, par5 - 8, brick);
            par1World.setBlock(par3 - 1, par4 + 1, par5 - 8, brick);
            par1World.setBlock(par3 - 2, par4 + 1, par5 - 8, brick, 3, 2);

            //dungeon entrance
            par1World.setBlock(par3 + 5, par4 + 1, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 5, par4 + 2, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 5, par4 + 3, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 6, par4 + 1, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 6, par4 + 2, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 6, par4 + 3, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 7, par4 + 1, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 7, par4 + 2, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 7, par4 + 3, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 1, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 2, par5 - 3, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 3, par5 - 3, brick, par2Random.nextInt(3), 2);

            par1World.setBlock(par3 + 5, par4 + 1, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 5, par4 + 2, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 5, par4 + 3, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 6, par4 + 1, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 6, par4 + 2, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 6, par4 + 3, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 7, par4 + 1, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 7, par4 + 2, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 7, par4 + 3, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 1, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 2, par5 - 7, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 3, par5 - 7, brick, par2Random.nextInt(3), 2);

            par1World.setBlock(par3 + 8, par4 + 1, par5 - 4, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 2, par5 - 4, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 3, par5 - 4, brick, par2Random.nextInt(3), 2);

            par1World.setBlock(par3 + 8, par4 + 1, par5 - 5, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 2, par5 - 5, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 3, par5 - 5, brick, par2Random.nextInt(3), 2);

            par1World.setBlock(par3 + 8, par4 + 1, par5 - 6, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 2, par5 - 6, brick, par2Random.nextInt(3), 2);
            par1World.setBlock(par3 + 8, par4 + 3, par5 - 6, brick, par2Random.nextInt(3), 2);

            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 4, Blocks.cobblestone);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 4, Blocks.cobblestone);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 5, Blocks.cobblestone);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 5, Blocks.cobblestone);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 6, Blocks.cobblestone);

            //dungeon

            for(int shaft = -1; shaft <= 3; shaft++)
            {
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 6, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 5, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 6, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 5, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 6, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 5, par4 - shaft, par5 - 4, Blocks.air);
            }

            for(int shaft = 1; shaft <= 3; shaft++)
            {
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 3, Blocks.cobblestone);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 7, Blocks.cobblestone);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 8, Blocks.cobblestone);

            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 3, Blocks.air);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 7, Blocks.air);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 8, Blocks.cobblestone);

            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 3, Blocks.air);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 7, Blocks.air);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 8, Blocks.cobblestone);

            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 3, Blocks.air);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 7, Blocks.air);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 8, Blocks.cobblestone);

            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 3, Blocks.air);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 7, Blocks.air);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 8, Blocks.cobblestone);

            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 3, Blocks.air);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 4, Blocks.air);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 5, Blocks.air);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 6, Blocks.air);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 7, Blocks.air);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 8, Blocks.cobblestone);

            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 2, Blocks.cobblestone);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 3, Blocks.cobblestone);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 4, Blocks.cobblestone);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 5, Blocks.cobblestone);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 6, Blocks.cobblestone);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 7, Blocks.cobblestone);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 8, Blocks.cobblestone);
            }

            //spawner
            par1World.setBlock(par3 + 10, par4 - 3, par5 - 5, Blocks.mob_spawner, 0, 2);
            TileEntityMobSpawner spawner = (TileEntityMobSpawner)par1World.getTileEntity(par3 + 10, par4 - 3, par5 - 5);

            if (spawner != null)
            {
            	spawner.func_145881_a().setEntityName(this.pickMobSpawner(par2Random));
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
            }

            //chests
            int xChest = par2Random.nextInt(5);

            par1World.setBlock(par3 + 8 + xChest, par4 - 3, par5 - 3, Blocks.chest, 0, 2);
            TileEntityChest chest = (TileEntityChest)par1World.getTileEntity(par3 + 8 + xChest, par4 - 3, par5 - 3);
            if (chest != null)
            {
            	while (chestitemsdungeon < 12)
                {
                    ItemStack itemstack = pickDungeonLootItem(par2Random);

                    	if (itemstack != null)
                    	{
                    		chest.setInventorySlotContents(par2Random.nextInt(chest.getSizeInventory()), itemstack);
                    	}
                    chestitemsdungeon++;
                 }
            }

            if(chest == null)
            {
            	System.err.println("Broken chest in dwarf city.");
            }

            //floor
            for(int floor = 7; floor <= 13; floor++)
            {
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 3, Blocks.cobblestone);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 4, Blocks.cobblestone);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 5, Blocks.cobblestone);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 6, Blocks.cobblestone);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 7, Blocks.cobblestone);
            }
            for(int mossy = 0; mossy <= 15; mossy++)
            {
            	par1World.setBlock(par3 + 7 + par2Random.nextInt(7), par4 - 4, par5 - 3 - par2Random.nextInt(5), Blocks.mossy_cobblestone);
            }

            //house 2
            for(int wall = 1; wall <= 4; wall++)
			{
				par1World.setBlock(par3 - 4, par4 + wall, par5 - 4, brick);
				par1World.setBlock(par3 - 4, par4 + wall, par5 - 6, brick);

				par1World.setBlock(par3 - 5, par4 + wall, par5 - 2, brick);
				par1World.setBlock(par3 - 5, par4 + wall, par5 - 3, brick);
				par1World.setBlock(par3 - 5, par4 + wall, par5 - 4, brick);
				par1World.setBlock(par3 - 5, par4 + wall, par5 - 6, brick);
				par1World.setBlock(par3 - 5, par4 + wall, par5 - 7, brick);
				par1World.setBlock(par3 - 5, par4 + wall, par5 - 8, brick);

				par1World.setBlock(par3 - 6, par4 + wall, par5 - 2, brick);
				par1World.setBlock(par3 - 6, par4 + wall, par5 - 8, brick);
				par1World.setBlock(par3 - 7, par4 + wall, par5 - 2, brick);
				par1World.setBlock(par3 - 7, par4 + wall, par5 - 8, brick);
				par1World.setBlock(par3 - 8, par4 + wall, par5 - 2, brick);
				par1World.setBlock(par3 - 8, par4 + wall, par5 - 8, brick);
				par1World.setBlock(par3 - 9, par4 + wall, par5 - 2, brick);
				par1World.setBlock(par3 - 9, par4 + wall, par5 - 8, brick);

				par1World.setBlock(par3 - 10, par4 + wall, par5 - 2, brick);
				par1World.setBlock(par3 - 10, par4 + wall, par5 - 3, brick);
				par1World.setBlock(par3 - 10, par4 + wall, par5 - 4, brick);
				par1World.setBlock(par3 - 10, par4 + wall, par5 - 5, brick);
				par1World.setBlock(par3 - 10, par4 + wall, par5 - 6, brick);
				par1World.setBlock(par3 - 10, par4 + wall, par5 - 7, brick);
				par1World.setBlock(par3 - 10, par4 + wall, par5 - 8, brick);

				par1World.setBlock(par3 - 4, par4 + 3, par5 - 5, brick);
				par1World.setBlock(par3 - 4, par4 + 4, par5 - 5, brick);

				par1World.setBlock(par3 - 5, par4 + 4, par5 - 2, brick);
				par1World.setBlock(par3 - 5, par4 + 4, par5 - 3, brick);
				par1World.setBlock(par3 - 5, par4 + 4, par5 - 4, brick);
				par1World.setBlock(par3 - 5, par4 + 4, par5 - 5, brick);
				par1World.setBlock(par3 - 5, par4 + 4, par5 - 6, brick);
				par1World.setBlock(par3 - 5, par4 + 4, par5 - 7, brick);
				par1World.setBlock(par3 - 5, par4 + 4, par5 - 8, brick);

				par1World.setBlock(par3 - 6, par4 + 4, par5 - 2, brick);
				par1World.setBlock(par3 - 6, par4 + 4, par5 - 3, brick);
				par1World.setBlock(par3 - 6, par4 + 4, par5 - 4, brick);
				par1World.setBlock(par3 - 6, par4 + 4, par5 - 5, brick);
				par1World.setBlock(par3 - 6, par4 + 4, par5 - 6, brick);
				par1World.setBlock(par3 - 6, par4 + 4, par5 - 7, brick);
				par1World.setBlock(par3 - 6, par4 + 4, par5 - 8, brick);

				par1World.setBlock(par3 - 7, par4 + 4, par5 - 2, brick);
				par1World.setBlock(par3 - 7, par4 + 4, par5 - 3, brick);
				par1World.setBlock(par3 - 7, par4 + 4, par5 - 4, brick);
				par1World.setBlock(par3 - 7, par4 + 4, par5 - 5, brick);
				par1World.setBlock(par3 - 7, par4 + 4, par5 - 6, brick);
				par1World.setBlock(par3 - 7, par4 + 4, par5 - 7, brick);
				par1World.setBlock(par3 - 7, par4 + 4, par5 - 8, brick);

				par1World.setBlock(par3 - 8, par4 + 4, par5 - 2, brick);
				par1World.setBlock(par3 - 8, par4 + 4, par5 - 3, brick);
				par1World.setBlock(par3 - 8, par4 + 4, par5 - 4, brick);
				par1World.setBlock(par3 - 8, par4 + 4, par5 - 5, brick);
				par1World.setBlock(par3 - 8, par4 + 4, par5 - 6, brick);
				par1World.setBlock(par3 - 8, par4 + 4, par5 - 7, brick);
				par1World.setBlock(par3 - 8, par4 + 4, par5 - 8, brick);

				par1World.setBlock(par3 - 9, par4 + 4, par5 - 2, brick);
				par1World.setBlock(par3 - 9, par4 + 4, par5 - 3, brick);
				par1World.setBlock(par3 - 9, par4 + 4, par5 - 4, brick);
				par1World.setBlock(par3 - 9, par4 + 4, par5 - 5, brick);
				par1World.setBlock(par3 - 9, par4 + 4, par5 - 6, brick);
				par1World.setBlock(par3 - 9, par4 + 4, par5 - 7, brick);
				par1World.setBlock(par3 - 9, par4 + 4, par5 - 8, brick);

				par1World.setBlock(par3 - 10, par4 + 2, par5 - 5, Blocks.glowstone);
				par1World.setBlock(par3 - 6, par4 + 1, par5 - 4, Blocks.planks);
				par1World.setBlock(par3 - 7, par4 + 1, par5 - 4, Blocks.planks);
				par1World.setBlock(par3 - 8, par4 + 1, par5 - 4, Blocks.planks);
				par1World.setBlock(par3 - 9, par4 + 1, par5 - 4, Blocks.fence_gate);

				par1World.setBlock(par3 - 7, par4 + 1, par5 - 7, Blocks.oak_stairs, 3, 2);
				par1World.setBlock(par3 - 8, par4 + 1, par5 - 7, Blocks.oak_stairs, 3, 2);
			}

            int dwarf2 = 0;
			if (dwarf2 == 0)
			{
				EntityDwarf entitydwarf = new EntityDwarf(par1World);
	            entitydwarf.setPosition(par3 - 7, par4 + 2, par5 - 5);
	            par1World.spawnEntityInWorld(entitydwarf);
	            dwarf2++;
			}

	        return true;
		}
		else
			return false;
	}

	private ItemStack pickHouseLootItem(Random par1Random)
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

	private ItemStack pickDungeonLootItem(Random par1Random)
    {
        int var2 = par1Random.nextInt(11);
        return var2 == 0 ? new ItemStack(Items.saddle) : (var2 == 1 ? new ItemStack(Items.iron_ingot, par1Random.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(Items.bread) : (var2 == 3 ? new ItemStack(Items.wheat, par1Random.nextInt(4) + 1) : (var2 == 4 ? new ItemStack(Items.gunpowder, par1Random.nextInt(4) + 1) : (var2 == 5 ? new ItemStack(Items.string, par1Random.nextInt(4) + 1) : (var2 == 6 ? new ItemStack(Items.bucket) : (var2 == 7 && par1Random.nextInt(100) == 0 ? new ItemStack(Items.golden_apple) : (var2 == 8 && par1Random.nextInt(2) == 0 ? new ItemStack(Items.redstone, par1Random.nextInt(4) + 1) : (var2 == 9 && par1Random.nextInt(10) == 0 ? new ItemStack(Items.record_13) : (var2 == 10 ? new ItemStack(Items.dye, 1, 3) : null))))))))));
    }

	private String pickMobSpawner(Random par1Random)
    {
        int var2 = par1Random.nextInt(4);
        return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : "")));
    }
}
