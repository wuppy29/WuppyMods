package com.wuppy.frozen.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.wuppy.frozen.FrozenCraft;

public class BlockIceVine extends BlockVine
{
	public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool[] ALL_FACES = new PropertyBool[] {UP, NORTH, SOUTH, WEST, EAST};
    public static final int SOUTH_FLAG = getMetaFlag(EnumFacing.SOUTH);
    public static final int NORTH_FLAG = getMetaFlag(EnumFacing.NORTH);
    public static final int EAST_FLAG = getMetaFlag(EnumFacing.EAST);
    public static final int WEST_FLAG = getMetaFlag(EnumFacing.WEST);
	
	private final String name = "iceVine";
	
	protected BlockIceVine()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(FrozenCraft.modid + "_" + name);
		setHardness(0.2F);
		setStepSound(soundTypeGrass);
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {UP, NORTH, EAST, SOUTH, WEST});
    }
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (((Boolean)state.getValue(NORTH)).booleanValue())
        {
            i |= NORTH_FLAG;
        }

        if (((Boolean)state.getValue(EAST)).booleanValue())
        {
            i |= EAST_FLAG;
        }

        if (((Boolean)state.getValue(SOUTH)).booleanValue())
        {
            i |= SOUTH_FLAG;
        }

        if (((Boolean)state.getValue(WEST)).booleanValue())
        {
            i |= WEST_FLAG;
        }

        return i;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(NORTH, Boolean.valueOf((meta & NORTH_FLAG) > 0)).withProperty(EAST, Boolean.valueOf((meta & EAST_FLAG) > 0)).withProperty(SOUTH, Boolean.valueOf((meta & SOUTH_FLAG) > 0)).withProperty(WEST, Boolean.valueOf((meta & WEST_FLAG) > 0));
    }
	
	private static int getMetaFlag(EnumFacing face)
    {
        return 1 << face.getHorizontalIndex();
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 16777215;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state)
    {
        return 16777215;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return 16777215;
    }
}