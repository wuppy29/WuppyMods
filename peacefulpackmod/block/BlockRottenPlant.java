package peacefulpackmod.block;

import java.util.Random;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRottenPlant extends BlockMushroom
{
    public BlockRottenPlant(int par1, String par2)
    {
        super(par1);
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
        this.disableStats();
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        return iconArray[par2];
    }
    
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
	
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
		iconArray = new Icon[2];
		for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
        }
    }
	
    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.netherrack.blockID;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 9)
        {
            int i = par1World.getBlockMetadata(par2, par3, par4);

            if (i < 1)
            {
                float f = getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25F / f) + 1) == 0)
                {
                    i++;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, i, 2);
                }
            }
        }
        
    }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
    }

    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float f = 1.0F;
        int i = par1World.getBlockId(par2, par3, par4 - 1);
        int j = par1World.getBlockId(par2, par3, par4 + 1);
        int k = par1World.getBlockId(par2 - 1, par3, par4);
        int l = par1World.getBlockId(par2 + 1, par3, par4);
        int i1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int j1 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int k1 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int l1 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean flag = k == blockID || l == blockID;
        boolean flag1 = i == blockID || j == blockID;
        boolean flag2 = i1 == blockID || j1 == blockID || k1 == blockID || l1 == blockID;

        for (int i2 = par2 - 1; i2 <= par2 + 1; i2++)
        {
            for (int j2 = par4 - 1; j2 <= par4 + 1; j2++)
            {
                int k2 = par1World.getBlockId(i2, par3 - 1, j2);
                float f1 = 0.0F;

                if (k2 == Block.netherrack.blockID)
                {
                    f1 = 1.0F;

                    if (par1World.getBlockMetadata(i2, par3 - 1, j2) > 0)
                    {
                        f1 = 3F;
                    }
                }

                if (i2 != par2 || j2 != par4)
                {
                    f1 /= 4F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }

    /**
     * The type of render function that is called for this block
     */
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);

        if (par1World.isRemote)
        {
            return;
        }

        EntityItem entityitem = new EntityItem(par1World, (float)par2, (float)par3, (float)par4, new ItemStack(PeacefulPack.rottenseed));
        entityitem.delayBeforeCanPickup = 10;
        par1World.spawnEntityInWorld(entityitem);
        int i = 3 + par7;

    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (par1 > 0)
        {
            return Item.rottenFlesh.itemID;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	return 1;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return PeacefulPack.rottenseed.itemID;
    }
}
