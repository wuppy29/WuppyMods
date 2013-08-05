package peacefulpackmod.block;

import net.minecraft.block.BlockWeb;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCustomWeb extends BlockWeb
{
    public BlockCustomWeb(int id) 
    {
		super(id);
	}

	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        if (par1World.rand.nextInt(5) == 0)
        {
        	this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.spiderEye, 1));
        }
        else
        {
        	this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.silk, 1));
        }
    }
}
