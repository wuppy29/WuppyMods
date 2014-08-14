package com.wuppy.magicalexp.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wuppy.magicalexp.MagicalExperience;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpell extends Block
{
	private BlockPressurePlate.Sensitivity sensitivity;
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public BlockSpell(BlockPressurePlate.Sensitivity sensitivity, Material par4Material)
    {
        super(Material.wood);
        this.sensitivity = sensitivity;
        setTickRandomly(true);
        float var5 = 0.0625F;
        setBlockBounds(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
        setCreativeTab(MagicalExperience.meBlocks);
        setHardness(0.5F);
        setStepSound(soundTypeWood);
        setBlockName("spell");
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
		icons = new IIcon[5];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(MagicalExperience.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
    }
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return icons[par2];
	}
	
	@Override
	public int tickRate(World world)
    {
        return 20;
    }
	
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	
	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
	@Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4);
    }
    
	@Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
    {
        boolean var6 = false;

        if (!World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4))
        {
            var6 = true;
        }

        if (var6)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
    
	@Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    
	@Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
        	this.setStateIfMobInteractsWithPlate(par1World, par2, par3, par4);
        }
    }
    
	@Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
    	{
    		par1World.spawnEntityInWorld(new EntityLightningBolt(par1World, par2, par3, par4));
        	par1World.setBlockToAir(par2, par3, par4);
    	}
		
        if (!par1World.isRemote)
        {
        	if (par1World.getBlockMetadata(par2, par3, par4) == 1)
        	{
        		par1World.createExplosion(null, par2, par3, par4, par1World.rand.nextInt(4) + 1, true);
        		par1World.setBlockToAir(par2, par3, par4);
        	}
        	else if (par1World.getBlockMetadata(par2, par3, par4) == 2)
        	{
        		par1World.setBlock(par2, par3, par4, Blocks.fire);
        		par1World.setBlock(par2, par3, par4, Blocks.fire, 0, 2);
                
                if (par1World.getBlock(par2 + 1, par3, par4) == Blocks.air)
                {
                	par1World.setBlock(par2 + 1, par3, par4, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2 - 1, par3, par4) == Blocks.air)
                {
                	par1World.setBlock(par2 - 1, par3, par4, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2, par3, par4 + 1) == Blocks.air)
                {
                	par1World.setBlock(par2, par3, par4 + 1, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2 + 1, par3, par4 + 1) == Blocks.air)
                {
                	par1World.setBlock(par2 + 1, par3, par4 + 1, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2 - 1, par3, par4 + 1) == Blocks.air)
                {
                	par1World.setBlock(par2 - 1, par3, par4 + 1, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2 + 1, par3, par4 - 1) == Blocks.air)
                {
                	par1World.setBlock(par2 + 1, par3, par4 - 1, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2 - 1, par3, par4 - 1) == Blocks.air)
                {
                	par1World.setBlock(par2 - 1, par3, par4 - 1, Blocks.fire, 0, 2);
                }
                if (par1World.getBlock(par2, par3, par4 - 1) == Blocks.air)
                {
                	par1World.setBlock(par2, par3, par4 - 1, Blocks.fire, 0, 2);
                }
        		par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "fire.ignite", 1.0F, par1World.rand.nextFloat() * 0.4F + 0.8F);
        	}
        	else if (par1World.getBlockMetadata(par2, par3, par4) == 3)
        	{        		
        		int randx = par1World.rand.nextInt(3);
        		int randy = par1World.rand.nextInt(3);
        		int randz = par1World.rand.nextInt(3);
        		
        		par1World.setBlock(par2, par3, par4, Blocks.flowing_water, 0, 2);
        		par1World.setBlock(par2, par3 + 1, par4, Blocks.flowing_water, 0, 2);
        		
        		if (par1World.getBlock(par2 + randx, par3, par4 + randz)== Blocks.air)
        		{
        			par1World.setBlock(par2 + randx, par3, par4 + randz, Blocks.flowing_water, 0, 2);
        		}
        		if (par1World.getBlock(par2, par3 + randy, par4) == Blocks.air)
        		{
        			par1World.setBlock(par2, par3 + randy, par4, Blocks.flowing_water, 0, 2);
        		}
        	}
        	else if (par1World.getBlockMetadata(par2, par3, par4) == 4)
        	{        		
        		int randx = par1World.rand.nextInt(3);
        		int randy = par1World.rand.nextInt(3);
        		int randz = par1World.rand.nextInt(3);
        		
        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
        		par1World.setBlock(par2, par3 + 1, par4, Blocks.flowing_lava, 0, 2);
        		
        		if (par1World.getBlock(par2 + randx, par3, par4 + randz)== Blocks.air)
        		{
        			par1World.setBlock(par2 + randx, par3, par4 + randz, Blocks.flowing_lava, 0, 2);
        		}
        		if (par1World.getBlock(par2, par3 + randy, par4) == Blocks.air)
        		{
        			par1World.setBlock(par2, par3 + randy, par4, Blocks.flowing_lava, 0, 2);
        		}
        	}
        }
    }
    
    @SuppressWarnings("rawtypes")
	private void setStateIfMobInteractsWithPlate(World par1World, int par2, int par3, int par4)
    {
        boolean var5 = par1World.getBlockMetadata(par2, par3, par4) == 1;
        boolean var6 = false;
        float var7 = 0.125F;
        List var8 = null;

        if (this.sensitivity == BlockPressurePlate.Sensitivity.everything)
        {
            var8 = par1World.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getBoundingBox((double)((float)par2 + var7), (double)par3, (double)((float)par4 + var7), (double)((float)(par2 + 1) - var7), (double)par3 + 0.25D, (double)((float)(par4 + 1) - var7)));
        }

        if (this.sensitivity == BlockPressurePlate.Sensitivity.mobs)
        {
            var8 = par1World.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox((double)((float)par2 + var7), (double)par3, (double)((float)par4 + var7), (double)((float)(par2 + 1) - var7), (double)par3 + 0.25D, (double)((float)(par4 + 1) - var7)));
        }

        if (this.sensitivity == BlockPressurePlate.Sensitivity.players)
        {
            var8 = par1World.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double)((float)par2 + var7), (double)par3, (double)((float)par4 + var7), (double)((float)(par2 + 1) - var7), (double)par3 + 0.25D, (double)((float)(par4 + 1) - var7)));
        }

        if (!var8.isEmpty())
        {
            var6 = true;
        }

        if (var6 && !var5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.1D, (double)par4 + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!var6 && var5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this);
            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.1D, (double)par4 + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (var6)
        {
            par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World));
        }
    }
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 5; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
