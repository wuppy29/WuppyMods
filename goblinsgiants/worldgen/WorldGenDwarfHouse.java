package goblinsgiants.worldgen;

import goblinsgiants.entity.EntityDwarf;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
			int stone = Block.stone.blockID;

			while (par1World.isAirBlock(par3, par4, par5))
	        {
				if(par4 > 10)
				{
					--par4;
				}
	        }

			if(par1World.getBlockId(par3, par4 + 1, par5) == Block.waterStill.blockID || par1World.getBlockId(par3, par4 + 1, par5) == Block.waterMoving.blockID)
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
					par1World.setBlock(par3 - 3, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 - 2, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 - 1, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 + 1, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 + 2, par4 + air, par5 + floor, 0);
					par1World.setBlock(par3 + 3, par4 + air, par5 + floor, 0);
				}
			}

			//house
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
}
