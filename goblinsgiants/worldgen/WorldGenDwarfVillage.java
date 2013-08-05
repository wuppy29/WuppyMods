package goblinsgiants.worldgen;

import goblinsgiants.entity.EntityDwarf;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
			int stone = Block.stone.blockID;

			while (par1World.isAirBlock(par3, par4, par5))
	        {
				if(par4 > 15)
				{
					--par4;
				}
	        }

			if(par1World.getBlockId(par3, par4 + 1, par5) == Block.waterStill.blockID || par1World.getBlockId(par3, par4 + 1, par5) == Block.waterMoving.blockID)
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
					par1World.setBlock(par3 - 3, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 - 2, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 - 1, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 + 1, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 + 2, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 + 3, par4 + air, par5 + floor, 0);
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
					par1World.setBlock(par3 + floor, par4 + air, par5 - 2, 0);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 3, 0);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 4, 0);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 5, 0);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 6, 0);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 7, 0);
					par1World.setBlock(par3 + floor, par4 + air, par5 - 8, 0);
				}
			}

			//house 1
			int brick = Block.stoneBrick.blockID;
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
				par1World.setBlock(par3, par4 + 3, par5 + 2, Block.glowStone.blockID);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 2, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 2, brick);

				par1World.setBlock(par3 + 2, par4 + wall, par5 + 3, brick);
				par1World.setBlock(par3 + 1, par4 + 3, par5 + 3, brick);
				par1World.setBlock(par3, par4 + 3, par5 + 3, brick);
				par1World.setBlock(par3 - 1, par4 + 3, par5 + 3, brick);
				par1World.setBlock(par3 - 2, par4 + wall, par5 + 3, brick);

				par1World.setBlock(par3 + 1, par4 + 1, par5 + 2, Block.stairsWoodOak.blockID);
				par1World.setBlock(par3 + 1, par4 + 1, par5 + 3, Block.stairsWoodOak.blockID);

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
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 8, Block.fenceIron.blockID);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 8, Block.fenceIron.blockID);
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 9, Block.fenceIron.blockID);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 9, Block.fenceIron.blockID);
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 10, Block.fenceIron.blockID);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 10, Block.fenceIron.blockID);
			par1World.setBlock(par3 + 2, par4 + 2, par5 + 11, Block.fenceIron.blockID);
			par1World.setBlock(par3 - 2, par4 + 2, par5 + 11, Block.fenceIron.blockID);

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

			par1World.setBlock(par3, par4 + 4, par5 + 11, Block.web.blockID);
			par1World.setBlock(par3, par4 - 1, par5 + 11, stone);
			par1World.setBlock(par3, par4, par5 + 11, Block.lavaStill.blockID);

			int dwarf = 0;
			if (dwarf == 0)
			{
				EntityDwarf entitydwarf = new EntityDwarf(par1World);
	            entitydwarf.setPosition(par3, par4 + 1, par5);
	            par1World.spawnEntityInWorld(entitydwarf);
	            dwarf++;
			}

			par1World.setBlock(par3 + 2, par4 + 1, par5 + 5, Block.chest.blockID, 0, 2);
            TileEntityChest var16 = (TileEntityChest)par1World.getBlockTileEntity(par3 + 2, par4 + 1, par5 + 5);
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
            par1World.setBlock(par3, par4 + 4, par5 -6, Block.lavaMoving.blockID);

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

            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 4, Block.cobblestone.blockID);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 4, Block.cobblestone.blockID);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 5, Block.cobblestone.blockID);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 5, Block.cobblestone.blockID);
            par1World.setBlock(par3 + 5 + par2Random.nextInt(3), par4 + 3, par5 - 6, Block.cobblestone.blockID);

            //dungeon

            for(int shaft = -1; shaft <= 3; shaft++)
            {
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 6, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 5, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 6, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 5, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 6, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 5, par4 - shaft, par5 - 4, 0);
            }

            for(int shaft = 1; shaft <= 3; shaft++)
            {
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 3, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 7, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 7, par4 - shaft, par5 - 8, Block.cobblestone.blockID);

            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 3, 0);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 7, 0);
            	par1World.setBlock(par3 + 8, par4 - shaft, par5 - 8, Block.cobblestone.blockID);

            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 3, 0);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 7, 0);
            	par1World.setBlock(par3 + 9, par4 - shaft, par5 - 8, Block.cobblestone.blockID);

            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 3, 0);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 7, 0);
            	par1World.setBlock(par3 + 10, par4 - shaft, par5 - 8, Block.cobblestone.blockID);

            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 3, 0);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 7, 0);
            	par1World.setBlock(par3 + 11, par4 - shaft, par5 - 8, Block.cobblestone.blockID);

            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 3, 0);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 4, 0);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 5, 0);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 6, 0);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 7, 0);
            	par1World.setBlock(par3 + 12, par4 - shaft, par5 - 8, Block.cobblestone.blockID);

            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 2, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 3, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 4, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 5, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 6, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 7, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + 13, par4 - shaft, par5 - 8, Block.cobblestone.blockID);
            }

            //spawner
            par1World.setBlock(par3 + 10, par4 - 3, par5 - 5, Block.mobSpawner.blockID, 0, 2);
            TileEntityMobSpawner spawner = (TileEntityMobSpawner)par1World.getBlockTileEntity(par3 + 10, par4 - 3, par5 - 5);

            if (spawner != null)
            {
                spawner.getSpawnerLogic().setMobID(this.pickMobSpawner(par2Random));
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
            }

            //chests
            int xChest = par2Random.nextInt(5);

            par1World.setBlock(par3 + 8 + xChest, par4 - 3, par5 - 3, Block.chest.blockID, 0, 2);
            TileEntityChest chest = (TileEntityChest)par1World.getBlockTileEntity(par3 + 8 + xChest, par4 - 3, par5 - 3);
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
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 3, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 4, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 5, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 6, Block.cobblestone.blockID);
            	par1World.setBlock(par3 + floor, par4 - 4, par5 - 7, Block.cobblestone.blockID);
            }
            for(int mossy = 0; mossy <= 15; mossy++)
            {
            	par1World.setBlock(par3 + 7 + par2Random.nextInt(7), par4 - 4, par5 - 3 - par2Random.nextInt(5), Block.cobblestoneMossy.blockID);
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

				par1World.setBlock(par3 - 10, par4 + 2, par5 - 5, Block.glowStone.blockID);
				par1World.setBlock(par3 - 6, par4 + 1, par5 - 4, Block.planks.blockID);
				par1World.setBlock(par3 - 7, par4 + 1, par5 - 4, Block.planks.blockID);
				par1World.setBlock(par3 - 8, par4 + 1, par5 - 4, Block.planks.blockID);
				par1World.setBlock(par3 - 9, par4 + 1, par5 - 4, Block.fenceGate.blockID);

				par1World.setBlock(par3 - 7, par4 + 1, par5 - 7, Block.stairsWoodOak.blockID, 3, 2);
				par1World.setBlock(par3 - 8, par4 + 1, par5 - 7, Block.stairsWoodOak.blockID, 3, 2);
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
            return new ItemStack(Item.ingotIron, par1Random.nextInt(4) + 1);
        }

        if (i == 1)
        {
            return new ItemStack(Item.ingotGold, par1Random.nextInt(2) + 1);
        }

        if (i == 2 && par1Random.nextInt(7)==0)
        {
            return new ItemStack(Item.diamond);
        }

        if (i == 3)
        {
            return new ItemStack(Item.pickaxeStone);
        }

        if (i == 4)
        {
            return new ItemStack(Item.pickaxeStone);
        }

        if (i == 5 && par1Random.nextInt(5)==0)
        {
            return new ItemStack(Item.pickaxeIron);
        }

        if (i == 6 && par1Random.nextInt(15)==0)
        {
            return new ItemStack(Item.pickaxeGold);
        }

        if (i == 7 && par1Random.nextInt(40) == 0)
        {
            return new ItemStack(Item.pickaxeDiamond);
        }

        if (i == 8)
        {
            return new ItemStack(Item.redstone, par1Random.nextInt(4) + 1);
        }

        if (i == 9)
        {
            return new ItemStack(Item.coal, par1Random.nextInt(4) + 1);
        }

        if (i == 10)
        {
            return new ItemStack(Item.dyePowder, par1Random.nextInt(3) + 1, 4);
        }
        else
        {
            return null;
        }
    }

	private ItemStack pickDungeonLootItem(Random par1Random)
    {
        int var2 = par1Random.nextInt(11);
        return var2 == 0 ? new ItemStack(Item.saddle) : (var2 == 1 ? new ItemStack(Item.ingotIron, par1Random.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(Item.bread) : (var2 == 3 ? new ItemStack(Item.wheat, par1Random.nextInt(4) + 1) : (var2 == 4 ? new ItemStack(Item.gunpowder, par1Random.nextInt(4) + 1) : (var2 == 5 ? new ItemStack(Item.silk, par1Random.nextInt(4) + 1) : (var2 == 6 ? new ItemStack(Item.bucketEmpty) : (var2 == 7 && par1Random.nextInt(100) == 0 ? new ItemStack(Item.appleGold) : (var2 == 8 && par1Random.nextInt(2) == 0 ? new ItemStack(Item.redstone, par1Random.nextInt(4) + 1) : (var2 == 9 && par1Random.nextInt(10) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + par1Random.nextInt(2)]) : (var2 == 10 ? new ItemStack(Item.dyePowder, 1, 3) : null))))))))));
    }

	private String pickMobSpawner(Random par1Random)
    {
        int var2 = par1Random.nextInt(4);
        return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : "")));
    }
}
