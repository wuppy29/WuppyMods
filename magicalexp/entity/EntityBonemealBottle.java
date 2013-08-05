package magicalexp.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityBonemealBottle extends EntityThrowable
{
    public EntityBonemealBottle(World par1World)
    {
        super(par1World);
    }

    public EntityBonemealBottle(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityBonemealBottle(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    protected float func_40075_e()
    {
        return 0.07F;
    }

    protected float func_40077_c()
    {
        return 0.7F;
    }

    protected float func_40074_d()
    {
        return -20F;
    }

    /**
     * Called when the throwable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (!worldObj.isRemote)
        {
            worldObj.playAuxSFX(2002, (int)Math.round(posX), (int)Math.round(posY), (int)Math.round(posZ), 0);
            
            int i1 = MathHelper.floor_double(posX);
            int j1 = MathHelper.floor_double(posY) - 1;
            int k1 = MathHelper.floor_double(posZ);
            
            int loc1;
            loc1 = worldObj.getBlockId(i1, j1, k1);
            
            if (loc1 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1, j1, k1, worldObj.rand);
                }
            }

            if (loc1 == Block.mushroomBrown.blockID || loc1 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc1]).fertilizeMushroom(worldObj, i1, j1, k1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc1 == Block.melonStem.blockID || loc1 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc1]).fertilizeStem(worldObj, i1, j1, k1);
            }

            if (loc1 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1, j1, k1);
            }

            if (loc1 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1;
                      int var11 = j1 + 1;
                      int var12 = k1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                          }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc2;
            loc2 = worldObj.getBlockId(i1 + 1, j1, k1);
            
            if (loc2 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1 + 1, j1, k1, worldObj.rand);
                }
            }

            if (loc2 == Block.mushroomBrown.blockID || loc2 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc2]).fertilizeMushroom(worldObj, i1 + 1, j1, k1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc2 == Block.melonStem.blockID || loc2 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc2]).fertilizeStem(worldObj, i1 + 1, j1, k1);
            }

            if (loc2 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1 + 1, j1, k1);
            }

            if (loc2 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1 + 1;
                      int var11 = j1 + 1;
                      int var12 = k1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc3;
            loc3 = worldObj.getBlockId(i1 - 1, j1, k1);
            
            if (loc3 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1 - 1, j1, k1, worldObj.rand);
                }
            }

            if (loc3 == Block.mushroomBrown.blockID || loc3 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc3]).fertilizeMushroom(worldObj, i1 - 1, j1, k1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc3 == Block.melonStem.blockID || loc3 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc3]).fertilizeStem(worldObj, i1 - 1, j1, k1);
            }

            if (loc3 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1 - 1, j1, k1);
            }

            if (loc3 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1 - 1;
                      int var11 = j1 + 1;
                      int var12 = k1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc4;
            loc4 = worldObj.getBlockId(i1, j1, k1 + 1);
            
            if (loc4 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1, j1, k1 + 1, worldObj.rand);
                }
            }

            if (loc4 == Block.mushroomBrown.blockID || loc4 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc4]).fertilizeMushroom(worldObj, i1, j1, k1 + 1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc4 == Block.melonStem.blockID || loc4 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc4]).fertilizeStem(worldObj, i1, j1, k1 + 1);
            }

            if (loc4 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1, j1, k1 + 1);
            }

            if (loc4 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1;
                      int var11 = j1 + 1;
                      int var12 = k1 + 1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc5;
            loc5 = worldObj.getBlockId(i1, j1, k1 - 1);
            
            if (loc5 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1, j1, k1 - 1, worldObj.rand);
                }
            }

            if (loc5 == Block.mushroomBrown.blockID || loc5 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc5]).fertilizeMushroom(worldObj, i1, j1, k1 - 1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc5 == Block.melonStem.blockID || loc5 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc5]).fertilizeStem(worldObj, i1, j1, k1 - 1);
            }

            if (loc5 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1, j1, k1 - 1);
            }

            if (loc5 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1;
                      int var11 = j1 + 1;
                      int var12 = k1 - 1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc6;
            loc6 = worldObj.getBlockId(i1 - 1, j1, k1 - 1);
            
            if (loc6 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1 - 1, j1, k1 - 1, worldObj.rand);
                }
            }

            if (loc6 == Block.mushroomBrown.blockID || loc6 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc6]).fertilizeMushroom(worldObj, i1 - 1, j1, k1 - 1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc6 == Block.melonStem.blockID || loc6 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc6]).fertilizeStem(worldObj, i1 - 1, j1, k1 - 1);
            }

            if (loc6 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1 - 1, j1, k1 - 1);
            }

            if (loc6 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1 - 1;
                      int var11 = j1 + 1;
                      int var12 = k1 - 1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc7;
            loc7 = worldObj.getBlockId(i1 + 1, j1, k1 - 1);
            
            if (loc7 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1 + 1, j1, k1 - 1, worldObj.rand);
                }
            }

            if (loc7 == Block.mushroomBrown.blockID || loc7 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc7]).fertilizeMushroom(worldObj, i1 + 1, j1, k1 - 1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc7 == Block.melonStem.blockID || loc7 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc7]).fertilizeStem(worldObj, i1 + 1, j1, k1 - 1);
            }

            if (loc7 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1 + 1, j1, k1 - 1);
            }

            if (loc7 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1 + 1;
                      int var11 = j1 + 1;
                      int var12 = k1 - 1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc8;
            loc8 = worldObj.getBlockId(i1 - 1, j1, k1 + 1);
            
            if (loc8 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1 - 1, j1, k1 + 1, worldObj.rand);
                }
            }

            if (loc8 == Block.mushroomBrown.blockID || loc8 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc8]).fertilizeMushroom(worldObj, i1 - 1, j1, k1 + 1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc8 == Block.melonStem.blockID || loc8 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc8]).fertilizeStem(worldObj, i1 - 1, j1, k1 + 1);
            }

            if (loc8 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1 - 1, j1, k1 + 1);
            }

            if (loc8 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1 - 1;
                      int var11 = j1 + 1;
                      int var12 = k1 + 1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            int loc9;
            loc9 = worldObj.getBlockId(i1 + 1, j1, k1 + 1);
            
            if (loc9 == Block.sapling.blockID)
            {
            	if (!worldObj.isRemote)
                {
                    ((BlockSapling)Block.sapling).growTree(worldObj, i1 + 1, j1, k1 + 1, worldObj.rand);
                }
            }

            if (loc9 == Block.mushroomBrown.blockID || loc9 == Block.mushroomRed.blockID)
            {
                if (!worldObj.isRemote && ((BlockMushroom)Block.blocksList[loc9]).fertilizeMushroom(worldObj, i1 + 1, j1, k1 + 1, worldObj.rand))
                {
                    ;
                }
            }

            if (loc9 == Block.melonStem.blockID || loc9 == Block.pumpkinStem.blockID)
            {
                ((BlockStem)Block.blocksList[loc9]).fertilizeStem(worldObj, i1 + 1, j1, k1 + 1);
            }

            if (loc9 == Block.crops.blockID)
            {
                ((BlockCrops)Block.crops).fertilize(worldObj, i1 + 1, j1, k1 + 1);
            }

            if (loc9 == Block.grass.blockID)
            {
                 label73:

                 for (int var9 = 0; var9 < 128; ++var9)
                 {
                      int var10 = i1 + 1;
                      int var11 = j1 + 1;
                      int var12 = k1 + 1;

                      for (int var13 = 0; var13 < var9 / 16; ++var13)
                      {
                          var10 += rand.nextInt(3) - 1;
                          var11 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                          var12 += rand.nextInt(3) - 1;

                          if (worldObj.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || worldObj.isBlockNormalCube(var10, var11, var12))
                          {
                               continue label73;
                           }
                       }

                       if (worldObj.getBlockId(var10, var11, var12) == 0)
                       {
                            if (rand.nextInt(10) != 0)
                            {
                                worldObj.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                            }
                            else
                            {
                                ForgeHooks.plantGrass(worldObj, var10, var11, var12);
                            }
                        }
                 }
            }
            
            setDead();
        }
    }
}
