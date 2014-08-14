package com.wuppy.goblinsgiants.dimension.savannah;

import static net.minecraftforge.common.ChestGenHooks.MINESHAFT_CORRIDOR;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;

@SuppressWarnings({"unchecked", "rawtypes"})
public class StructureMineshaftPiecesSavannah
{
    /**
     * List of contents that can generate in Mineshafts.
     */
    public static final WeightedRandomChestContent[] mineshaftChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.dye, 4, 4, 9, 5), new WeightedRandomChestContent(Items.diamond, 0, 1, 2, 3), new WeightedRandomChestContent(Items.coal, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 4, 8, 1), new WeightedRandomChestContent(Items.melon_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.pumpkin_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1)};

    public static void registerStructurePieces()
    {
        MapGenStructureIO.func_143031_a(StructureMineshaftPiecesSavannah.Corridor.class, "MSCorridorSav");
        MapGenStructureIO.func_143031_a(StructureMineshaftPiecesSavannah.Cross.class, "MSCrossingSav");
        MapGenStructureIO.func_143031_a(StructureMineshaftPiecesSavannah.Room.class, "MSRoomSav");
        MapGenStructureIO.func_143031_a(StructureMineshaftPiecesSavannah.Stairs.class, "MSStairsSav");
    }

	private static StructureComponent getRandomComponent(List par0List, Random par1Random, int par2, int par3, int par4, int par5, int par6)
    {
        int j1 = par1Random.nextInt(100);
        StructureBoundingBox structureboundingbox;

        if (j1 >= 80)
        {
            structureboundingbox = StructureMineshaftPiecesSavannah.Cross.findValidPlacement(par0List, par1Random, par2, par3, par4, par5);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPiecesSavannah.Cross(par6, par1Random, structureboundingbox, par5);
            }
        }
        else if (j1 >= 70)
        {
            structureboundingbox = StructureMineshaftPiecesSavannah.Stairs.findValidPlacement(par0List, par1Random, par2, par3, par4, par5);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPiecesSavannah.Stairs(par6, par1Random, structureboundingbox, par5);
            }
        }
        else
        {
            structureboundingbox = StructureMineshaftPiecesSavannah.Corridor.findValidPlacement(par0List, par1Random, par2, par3, par4, par5);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPiecesSavannah.Corridor(par6, par1Random, structureboundingbox, par5);
            }
        }

        return null;
    }
    
	private static StructureComponent getNextMineShaftComponent(StructureComponent par0StructureComponent, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 8)
        {
            return null;
        }
        else if (Math.abs(par3 - par0StructureComponent.getBoundingBox().minX) <= 80 && Math.abs(par5 - par0StructureComponent.getBoundingBox().minZ) <= 80)
        {
            StructureComponent structurecomponent1 = getRandomComponent(par1List, par2Random, par3, par4, par5, par6, par7 + 1);

            if (structurecomponent1 != null)
            {
                par1List.add(structurecomponent1);
                structurecomponent1.buildComponent(par0StructureComponent, par1List, par2Random);
            }

            return structurecomponent1;
        }
        else
        {
            return null;
        }
    }

    public static class Cross extends StructureComponent
        {
            private int corridorDirection;
            private boolean isMultipleFloors;

            public Cross() {}

            protected void func_143012_a(NBTTagCompound par1NBTTagCompound)
            {
                par1NBTTagCompound.setBoolean("tf", this.isMultipleFloors);
                par1NBTTagCompound.setInteger("D", this.corridorDirection);
            }

            protected void func_143011_b(NBTTagCompound par1NBTTagCompound)
            {
                this.isMultipleFloors = par1NBTTagCompound.getBoolean("tf");
                this.corridorDirection = par1NBTTagCompound.getInteger("D");
            }

            public Cross(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4)
            {
                super(par1);
                this.corridorDirection = par4;
                this.boundingBox = par3StructureBoundingBox;
                this.isMultipleFloors = par3StructureBoundingBox.getYSize() > 3;
            }

            public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, int par2, int par3, int par4, int par5)
            {
                StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3, par4, par2, par3 + 2, par4);

                if (par1Random.nextInt(4) == 0)
                {
                    structureboundingbox.maxY += 4;
                }

                switch (par5)
                {
                    case 0:
                        structureboundingbox.minX = par2 - 1;
                        structureboundingbox.maxX = par2 + 3;
                        structureboundingbox.maxZ = par4 + 4;
                        break;
                    case 1:
                        structureboundingbox.minX = par2 - 4;
                        structureboundingbox.minZ = par4 - 1;
                        structureboundingbox.maxZ = par4 + 3;
                        break;
                    case 2:
                        structureboundingbox.minX = par2 - 1;
                        structureboundingbox.maxX = par2 + 3;
                        structureboundingbox.minZ = par4 - 4;
                        break;
                    case 3:
                        structureboundingbox.maxX = par2 + 4;
                        structureboundingbox.minZ = par4 - 1;
                        structureboundingbox.maxZ = par4 + 3;
                }

                return StructureComponent.findIntersecting(par0List, structureboundingbox) != null ? null : structureboundingbox;
            }

            /**
             * Initiates construction of the Structure Component picked, at the current Location of StructGen
             */
            public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
            {
                int i = this.getComponentType();

                switch (this.corridorDirection)
                {
                    case 0:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 1, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 3, i);
                        break;
                    case 1:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 1, i);
                        break;
                    case 2:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 1, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 3, i);
                        break;
                    case 3:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, 3, i);
                }

                if (this.isMultipleFloors)
                {
                    if (par3Random.nextBoolean())
                    {
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, 2, i);
                    }

                    if (par3Random.nextBoolean())
                    {
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, 1, i);
                    }

                    if (par3Random.nextBoolean())
                    {
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, 3, i);
                    }

                    if (par3Random.nextBoolean())
                    {
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, 0, i);
                    }
                }
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(par1World, par3StructureBoundingBox))
                {
                    return false;
                }
                else
                {
                    if (this.isMultipleFloors)
                    {
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                    }
                    else
                    {
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air, Blocks.air, false);
                    }

                    this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, Blocks.planks, Blocks.air, false);
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.planks, Blocks.air, false);
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, Blocks.planks, Blocks.air, false);
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.planks, Blocks.air, false);

                    for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i)
                    {
                        for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j)
                        {
                            if (this.getBlockAtCurrentPosition(par1World, i, this.boundingBox.minY - 1, j, par3StructureBoundingBox).getMaterial() == Material.air)
                            {
                                this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, i, this.boundingBox.minY - 1, j, par3StructureBoundingBox);
                            }
                        }
                    }

                    return true;
                }
            }
        }

    public static class Room extends StructureComponent
        {
            /**
             * List of other Mineshaft components linked to this room.
             */
            private List roomsLinkedToTheRoom = new LinkedList();

            public Room() {}

            public Room(int par1, Random par2Random, int par3, int par4)
            {
                super(par1);
                this.boundingBox = new StructureBoundingBox(par3, 50, par4, par3 + 7 + par2Random.nextInt(6), 54 + par2Random.nextInt(6), par4 + 7 + par2Random.nextInt(6));
            }

            /**
             * Initiates construction of the Structure Component picked, at the current Location of StructGen
             */
            public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
            {
                int i = this.getComponentType();
                int k = this.boundingBox.getYSize() - 3 - 1;

                if (k <= 0)
                {
                    k = 1;
                }

                int j;
                StructureComponent structurecomponent1;
                StructureBoundingBox structureboundingbox;

                for (j = 0; j < this.boundingBox.getXSize(); j += 4)
                {
                    j += par3Random.nextInt(this.boundingBox.getXSize());

                    if (j + 3 > this.boundingBox.getXSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + j, this.boundingBox.minY + par3Random.nextInt(k) + 1, this.boundingBox.minZ - 1, 2, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureboundingbox.minX, structureboundingbox.minY, this.boundingBox.minZ, structureboundingbox.maxX, structureboundingbox.maxY, this.boundingBox.minZ + 1));
                    }
                }

                for (j = 0; j < this.boundingBox.getXSize(); j += 4)
                {
                    j += par3Random.nextInt(this.boundingBox.getXSize());

                    if (j + 3 > this.boundingBox.getXSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX + j, this.boundingBox.minY + par3Random.nextInt(k) + 1, this.boundingBox.maxZ + 1, 0, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureboundingbox.minX, structureboundingbox.minY, this.boundingBox.maxZ - 1, structureboundingbox.maxX, structureboundingbox.maxY, this.boundingBox.maxZ));
                    }
                }

                for (j = 0; j < this.boundingBox.getZSize(); j += 4)
                {
                    j += par3Random.nextInt(this.boundingBox.getZSize());

                    if (j + 3 > this.boundingBox.getZSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY + par3Random.nextInt(k) + 1, this.boundingBox.minZ + j, 1, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.minX, structureboundingbox.minY, structureboundingbox.minZ, this.boundingBox.minX + 1, structureboundingbox.maxY, structureboundingbox.maxZ));
                    }
                }

                for (j = 0; j < this.boundingBox.getZSize(); j += 4)
                {
                    j += par3Random.nextInt(this.boundingBox.getZSize());

                    if (j + 3 > this.boundingBox.getZSize())
                    {
                        break;
                    }

                    structurecomponent1 = StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY + par3Random.nextInt(k) + 1, this.boundingBox.minZ + j, 3, i);

                    if (structurecomponent1 != null)
                    {
                        structureboundingbox = structurecomponent1.getBoundingBox();
                        this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.maxX - 1, structureboundingbox.minY, structureboundingbox.minZ, this.boundingBox.maxX, structureboundingbox.maxY, structureboundingbox.maxZ));
                    }
                }
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(par1World, par3StructureBoundingBox))
                {
                    return false;
                }
                else
                {
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, Blocks.dirt, Blocks.air, true);
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, Blocks.air, Blocks.air, false);
                    Iterator iterator = this.roomsLinkedToTheRoom.iterator();

                    while (iterator.hasNext())
                    {
                        StructureBoundingBox structureboundingbox1 = (StructureBoundingBox)iterator.next();
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, structureboundingbox1.minX, structureboundingbox1.maxY - 2, structureboundingbox1.minZ, structureboundingbox1.maxX, structureboundingbox1.maxY, structureboundingbox1.maxZ, Blocks.air, Blocks.air, false);
                    }

                    this.func_151547_a(par1World, par3StructureBoundingBox, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air, false);
                    return true;
                }
            }

            protected void func_143012_a(NBTTagCompound par1NBTTagCompound)
            {
                NBTTagList nbttaglist = new NBTTagList();
                Iterator iterator = this.roomsLinkedToTheRoom.iterator();

                while (iterator.hasNext())
                {
                    StructureBoundingBox structureboundingbox = (StructureBoundingBox)iterator.next();
                    nbttaglist.appendTag(structureboundingbox.func_151535_h());
                }

                par1NBTTagCompound.setTag("Entrances", nbttaglist);
            }

            protected void func_143011_b(NBTTagCompound par1NBTTagCompound)
            {
                NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Entrances", 11);

                for (int i = 0; i < nbttaglist.tagCount(); ++i)
                {
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(nbttaglist.func_150306_c(i)));
                }
            }
        }

    public static class Corridor extends StructureComponent
        {
            private boolean hasRails;
            private boolean hasSpiders;
            private boolean spawnerPlaced;
            /**
             * A count of the different sections of this mine. The space between ceiling supports.
             */
            private int sectionCount;

            public Corridor() {}

            protected void func_143012_a(NBTTagCompound par1NBTTagCompound)
            {
                par1NBTTagCompound.setBoolean("hr", this.hasRails);
                par1NBTTagCompound.setBoolean("sc", this.hasSpiders);
                par1NBTTagCompound.setBoolean("hps", this.spawnerPlaced);
                par1NBTTagCompound.setInteger("Num", this.sectionCount);
            }

            protected void func_143011_b(NBTTagCompound par1NBTTagCompound)
            {
                this.hasRails = par1NBTTagCompound.getBoolean("hr");
                this.hasSpiders = par1NBTTagCompound.getBoolean("sc");
                this.spawnerPlaced = par1NBTTagCompound.getBoolean("hps");
                this.sectionCount = par1NBTTagCompound.getInteger("Num");
            }

            public Corridor(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4)
            {
                super(par1);
                this.coordBaseMode = par4;
                this.boundingBox = par3StructureBoundingBox;
                this.hasRails = par2Random.nextInt(3) == 0;
                this.hasSpiders = !this.hasRails && par2Random.nextInt(23) == 0;

                if (this.coordBaseMode != 2 && this.coordBaseMode != 0)
                {
                    this.sectionCount = par3StructureBoundingBox.getXSize() / 5;
                }
                else
                {
                    this.sectionCount = par3StructureBoundingBox.getZSize() / 5;
                }
            }

            public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, int par2, int par3, int par4, int par5)
            {
                StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3, par4, par2, par3 + 2, par4);
                int i1;

                for (i1 = par1Random.nextInt(3) + 2; i1 > 0; --i1)
                {
                    int j1 = i1 * 5;

                    switch (par5)
                    {
                        case 0:
                            structureboundingbox.maxX = par2 + 2;
                            structureboundingbox.maxZ = par4 + (j1 - 1);
                            break;
                        case 1:
                            structureboundingbox.minX = par2 - (j1 - 1);
                            structureboundingbox.maxZ = par4 + 2;
                            break;
                        case 2:
                            structureboundingbox.maxX = par2 + 2;
                            structureboundingbox.minZ = par4 - (j1 - 1);
                            break;
                        case 3:
                            structureboundingbox.maxX = par2 + (j1 - 1);
                            structureboundingbox.maxZ = par4 + 2;
                    }

                    if (StructureComponent.findIntersecting(par0List, structureboundingbox) == null)
                    {
                        break;
                    }
                }

                return i1 > 0 ? structureboundingbox : null;
            }

            /**
             * Initiates construction of the Structure Component picked, at the current Location of StructGen
             */
            public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
            {
                int i = this.getComponentType();
                int j = par3Random.nextInt(4);

                switch (this.coordBaseMode)
                {
                    case 0:
                        if (j <= 1)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.maxZ + 1, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.maxZ - 3, 1, i);
                        }
                        else
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.maxZ - 3, 3, i);
                        }

                        break;
                    case 1:
                        if (j <= 1)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ - 1, 2, i);
                        }
                        else
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.maxZ + 1, 0, i);
                        }

                        break;
                    case 2:
                        if (j <= 1)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ - 1, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ, 1, i);
                        }
                        else
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ, 3, i);
                        }

                        break;
                    case 3:
                        if (j <= 1)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, i);
                        }
                        else if (j == 2)
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.minZ - 1, 2, i);
                        }
                        else
                        {
                            StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + par3Random.nextInt(3), this.boundingBox.maxZ + 1, 0, i);
                        }
                }

                if (i < 8)
                {
                    int k;
                    int l;

                    if (this.coordBaseMode != 2 && this.coordBaseMode != 0)
                    {
                        for (k = this.boundingBox.minX + 3; k + 3 <= this.boundingBox.maxX; k += 5)
                        {
                            l = par3Random.nextInt(5);

                            if (l == 0)
                            {
                                StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, k, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i + 1);
                            }
                            else if (l == 1)
                            {
                                StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, k, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i + 1);
                            }
                        }
                    }
                    else
                    {
                        for (k = this.boundingBox.minZ + 3; k + 3 <= this.boundingBox.maxZ; k += 5)
                        {
                            l = par3Random.nextInt(5);

                            if (l == 0)
                            {
                                StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY, k, 1, i + 1);
                            }
                            else if (l == 1)
                            {
                                StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY, k, 3, i + 1);
                            }
                        }
                    }
                }
            }

            /**
             * Used to generate chests with items in it. ex: Temple Chests, Village Blacksmith Chests, Mineshaft Chests.
             */
            protected boolean generateStructureChestContents(World par1World, StructureBoundingBox par2StructureBoundingBox, Random par3Random, int par4, int par5, int par6, WeightedRandomChestContent[] par7ArrayOfWeightedRandomChestContent, int par8)
            {
                int i1 = this.getXWithOffset(par4, par6);
                int j1 = this.getYWithOffset(par5);
                int k1 = this.getZWithOffset(par4, par6);

                if (par2StructureBoundingBox.isVecInside(i1, j1, k1) && par1World.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    int l1 = par3Random.nextBoolean() ? 1 : 0;
                    par1World.setBlock(i1, j1, k1, Blocks.rail, this.getMetadataWithOffset(Blocks.rail, l1), 2);
                    EntityMinecartChest entityminecartchest = new EntityMinecartChest(par1World, (double)((float)i1 + 0.5F), (double)((float)j1 + 0.5F), (double)((float)k1 + 0.5F));
                    WeightedRandomChestContent.generateChestContents(par3Random, par7ArrayOfWeightedRandomChestContent, entityminecartchest, par8);
                    par1World.spawnEntityInWorld(entityminecartchest);
                    return true;
                }
                else
                {
                    return false;
                }
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(par1World, par3StructureBoundingBox))
                {
                    return false;
                }
                else
                {
                    int i = this.sectionCount * 5 - 1;
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 2, 1, i, Blocks.air, Blocks.air, false);
                    this.randomlyFillWithBlocks(par1World, par3StructureBoundingBox, par2Random, 0.8F, 0, 2, 0, 2, 2, i, Blocks.air, Blocks.air, false);

                    if (this.hasSpiders)
                    {
                        this.randomlyFillWithBlocks(par1World, par3StructureBoundingBox, par2Random, 0.6F, 0, 0, 0, 2, 1, i, Blocks.web, Blocks.air, false);
                    }

                    int j;
                    int k;

                    for (j = 0; j < this.sectionCount; ++j)
                    {
                        k = 2 + j * 5;
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, k, 0, 1, k, Blocks.fence, Blocks.air, false);
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 0, k, 2, 1, k, Blocks.fence, Blocks.air, false);

                        if (par2Random.nextInt(4) == 0)
                        {
                            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, k, 0, 2, k, Blocks.planks, Blocks.air, false);
                            this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 2, k, 2, 2, k, Blocks.planks, Blocks.air, false);
                        }
                        else
                        {
                            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, k, 2, 2, k, Blocks.planks, Blocks.air, false);
                        }

                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.1F, 0, 2, k - 1, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.1F, 2, 2, k - 1, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.1F, 0, 2, k + 1, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.1F, 2, 2, k + 1, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.05F, 0, 2, k - 2, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.05F, 2, 2, k - 2, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.05F, 0, 2, k + 2, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.05F, 2, 2, k + 2, Blocks.web, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.05F, 1, 2, k - 1, Blocks.torch, 0);
                        this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.05F, 1, 2, k + 1, Blocks.torch, 0);

                        ChestGenHooks info = ChestGenHooks.getInfo(MINESHAFT_CORRIDOR);
                        if (par2Random.nextInt(100) == 0)
                        {
                            this.generateStructureChestContents(par1World, par3StructureBoundingBox, par2Random, 2, 0, k - 1, info.getItems(par2Random), info.getCount(par2Random));
                        }

                        if (par2Random.nextInt(100) == 0)
                        {
                            this.generateStructureChestContents(par1World, par3StructureBoundingBox, par2Random, 0, 0, k + 1, info.getItems(par2Random), info.getCount(par2Random));
                        }

                        if (this.hasSpiders && !this.spawnerPlaced)
                        {
                            int l = this.getYWithOffset(0);
                            int i1 = k - 1 + par2Random.nextInt(3);
                            int j1 = this.getXWithOffset(1, i1);
                            i1 = this.getZWithOffset(1, i1);

                            if (par3StructureBoundingBox.isVecInside(j1, l, i1))
                            {
                                this.spawnerPlaced = true;
                                par1World.setBlock(j1, l, i1, Blocks.mob_spawner, 0, 2);
                                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getTileEntity(j1, l, i1);

                                if (tileentitymobspawner != null)
                                {
                                    tileentitymobspawner.func_145881_a().setEntityName("CaveSpider");
                                }
                            }
                        }
                    }

                    for (j = 0; j <= 2; ++j)
                    {
                        for (k = 0; k <= i; ++k)
                        {
                            byte b0 = -1;
                            Block block1 = this.getBlockAtCurrentPosition(par1World, j, b0, k, par3StructureBoundingBox);

                            if (block1.getMaterial() == Material.air)
                            {
                                byte b1 = -1;
                                this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, j, b1, k, par3StructureBoundingBox);
                            }
                        }
                    }

                    if (this.hasRails)
                    {
                        for (j = 0; j <= i; ++j)
                        {
                            Block block = this.getBlockAtCurrentPosition(par1World, 1, -1, j, par3StructureBoundingBox);

                            if (block.getMaterial() != Material.air && block.func_149730_j())
                            {
                                this.func_151552_a(par1World, par3StructureBoundingBox, par2Random, 0.7F, 1, 0, j, Blocks.rail, this.getMetadataWithOffset(Blocks.rail, 0));
                            }
                        }
                    }

                    return true;
                }
            }
        }

    public static class Stairs extends StructureComponent
        {
            public Stairs() {}

            public Stairs(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4)
            {
                super(par1);
                this.coordBaseMode = par4;
                this.boundingBox = par3StructureBoundingBox;
            }

            protected void func_143012_a(NBTTagCompound par1NBTTagCompound) {}

            protected void func_143011_b(NBTTagCompound par1NBTTagCompound) {}

            /**
             * Trys to find a valid place to put this component.
             */
            public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, int par2, int par3, int par4, int par5)
            {
                StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3 - 5, par4, par2, par3 + 2, par4);

                switch (par5)
                {
                    case 0:
                        structureboundingbox.maxX = par2 + 2;
                        structureboundingbox.maxZ = par4 + 8;
                        break;
                    case 1:
                        structureboundingbox.minX = par2 - 8;
                        structureboundingbox.maxZ = par4 + 2;
                        break;
                    case 2:
                        structureboundingbox.maxX = par2 + 2;
                        structureboundingbox.minZ = par4 - 8;
                        break;
                    case 3:
                        structureboundingbox.maxX = par2 + 8;
                        structureboundingbox.maxZ = par4 + 2;
                }

                return StructureComponent.findIntersecting(par0List, structureboundingbox) != null ? null : structureboundingbox;
            }

            /**
             * Initiates construction of the Structure Component picked, at the current Location of StructGen
             */
            public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
            {
                int i = this.getComponentType();

                switch (this.coordBaseMode)
                {
                    case 0:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                        break;
                    case 1:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, 1, i);
                        break;
                    case 2:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                        break;
                    case 3:
                        StructureMineshaftPiecesSavannah.getNextMineShaftComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, 3, i);
                }
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
            {
                if (this.isLiquidInStructureBoundingBox(par1World, par3StructureBoundingBox))
                {
                    return false;
                }
                else
                {
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 2, 7, 1, Blocks.air, Blocks.air, false);
                    this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 7, 2, 2, 8, Blocks.air, Blocks.air, false);

                    for (int i = 0; i < 5; ++i)
                    {
                        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, Blocks.air, Blocks.air, false);
                    }

                    return true;
                }
            }
        }
}