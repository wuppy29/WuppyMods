package slimedungeons;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSlimeDungeon extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        byte var6 = 3;
        int var7 = par2Random.nextInt(2) + 2;
        int var8 = par2Random.nextInt(2) + 2;
        int var9 = 0;
        int var10;
        int var11;
        int var12;

        for (var10 = par3 - var7 - 1; var10 <= par3 + var7 + 1; ++var10)
        {
            for (var11 = par4 - 1; var11 <= par4 + var6 + 1; ++var11)
            {
                for (var12 = par5 - var8 - 1; var12 <= par5 + var8 + 1; ++var12)
                {
                    Material var13 = par1World.getBlockMaterial(var10, var11, var12);

                    if (var11 == par4 - 1 && !var13.isSolid())
                    {
                        return false;
                    }

                    if (var11 == par4 + var6 + 1 && !var13.isSolid())
                    {
                        return false;
                    }

                    if ((var10 == par3 - var7 - 1 || var10 == par3 + var7 + 1 || var12 == par5 - var8 - 1 || var12 == par5 + var8 + 1) && var11 == par4 && par1World.isAirBlock(var10, var11, var12) && par1World.isAirBlock(var10, var11 + 1, var12))
                    {
                        ++var9;
                    }
                }
            }
        }

        if (var9 >= 1 && var9 <= 5)
        {
            for (var10 = par3 - var7 - 1; var10 <= par3 + var7 + 1; ++var10)
            {
                for (var11 = par4 + var6; var11 >= par4 - 1; --var11)
                {
                    for (var12 = par5 - var8 - 1; var12 <= par5 + var8 + 1; ++var12)
                    {
                        if (var10 != par3 - var7 - 1 && var11 != par4 - 1 && var12 != par5 - var8 - 1 && var10 != par3 + var7 + 1 && var11 != par4 + var6 + 1 && var12 != par5 + var8 + 1)
                        {
                            par1World.setBlockToAir(var10, var11, var12);
                        }
                        else if (var11 >= 0 && !par1World.getBlockMaterial(var10, var11 - 1, var12).isSolid())
                        {
                            par1World.setBlockToAir(var10, var11, var12);
                        }
                        else if (par1World.getBlockMaterial(var10, var11, var12).isSolid())
                        {
                            if (var11 == par4 - 1 && par2Random.nextInt(4) != 0)
                            {
                                par1World.setBlock(var10, var11, var12, SlimeDungeon.SlimeBlock.blockID);
                            }
                            else
                            {
                                par1World.setBlock(var10, var11, var12, SlimeDungeon.SlimeCobble.blockID);
                            }
                        }
                    }
                }
            }

            var10 = 0;

            while (var10 < 2)
            {
                var11 = 0;

                while (true)
                {
                    if (var11 < 3)
                    {
                        label210:
                        {
                            var12 = par3 + par2Random.nextInt(var7 * 2 + 1) - var7;
                            int var14 = par5 + par2Random.nextInt(var8 * 2 + 1) - var8;

                            if (par1World.isAirBlock(var12, par4, var14))
                            {
                                int var15 = 0;

                                if (par1World.getBlockMaterial(var12 - 1, par4, var14).isSolid())
                                {
                                    ++var15;
                                }

                                if (par1World.getBlockMaterial(var12 + 1, par4, var14).isSolid())
                                {
                                    ++var15;
                                }

                                if (par1World.getBlockMaterial(var12, par4, var14 - 1).isSolid())
                                {
                                    ++var15;
                                }

                                if (par1World.getBlockMaterial(var12, par4, var14 + 1).isSolid())
                                {
                                    ++var15;
                                }

                                if (var15 == 1)
                                {
                                    par1World.setBlock(var12, par4, var14, Block.chest.blockID);
                                    TileEntityChest var16 = (TileEntityChest)par1World.getBlockTileEntity(var12, par4, var14);

                                    if (var16 != null)
                                    {
                                        for (int var17 = 0; var17 < 12; ++var17)
                                        {
                                            ItemStack var18 = this.pickCheckLootItem(par2Random);

                                            if (var18 != null)
                                            {
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

            par1World.setBlock(par3, par4, par5, Block.mobSpawner.blockID);
            TileEntityMobSpawner var19 = (TileEntityMobSpawner)par1World.getBlockTileEntity(par3, par4, par5);

            if (var19 != null)
            {
                var19.getSpawnerLogic().setMobID("SlimeZombie");
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    private ItemStack pickCheckLootItem(Random par1Random)
    {
        int var2 = par1Random.nextInt(11);
        if(var2 == 5 && par1Random.nextInt(4) == 1)
        	return new ItemStack(Item.ingotIron);
        if(var2 == 6 && par1Random.nextInt(7) == 1)
        	return new ItemStack(Item.ingotGold);
        if(var2 == 7 && par1Random.nextInt(14) == 1)
        	return new ItemStack(Item.diamond);
        if(var2 == 8)
        	return new ItemStack(Item.saddle);
        if(var2 == 9)
        	return new ItemStack(Item.redstone, 1 + par1Random.nextInt(5));
        if(var2 == 10)
        	return new ItemStack(Item.gunpowder);
        else
        	return new ItemStack(Item.slimeBall);
    }
}