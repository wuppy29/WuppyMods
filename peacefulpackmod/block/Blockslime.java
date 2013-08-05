package peacefulpackmod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Blockslime extends Block
{
	public Blockslime(int id)
    {
        super(id, Material.ground);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
    
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.slimeBall.itemID;
    }
	
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        if (par5Random.nextInt(2) == 0)
        {
        	double var1 = (double)((float)par2 + par1World.rand.nextFloat());
            double var2 = (double)((float)par3 + par1World.rand.nextFloat());
            double var3 = (double)((float)par4 + par1World.rand.nextFloat());
            par1World.spawnParticle("slime", var1, var2, var3, 0.0D, 0.0D, 0.0D);
        }
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.00001D;
        par5Entity.motionY *= 0.0D;
        par5Entity.motionZ *= 0.00001D;
    }
}
