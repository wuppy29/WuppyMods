package peacefulpackmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Blockslime extends Block
{
	public Blockslime()
    {
        super(Material.field_151578_c);
        func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        this.func_149647_a(CreativeTabs.tabBlock);
    }
	
	public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Items.slime_ball;
    }

    public void func_149734_b(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.func_149734_b(par1World, par2, par3, par4, par5Random);

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
