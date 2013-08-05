package magicalexp;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExp extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockExp(int i)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		icons = new Icon[2];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(MagicalExperience.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
    }
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return icons[par2];
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
		if (par1 == 0)
		{
			return MagicalExperience.components.itemID;
		}
		else
			return 0;
    }
	
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote && par5 == 1)
        {
            EntitySilverfish entitysilverfish = new EntitySilverfish(par1World);
            entitysilverfish.setLocationAndAngles((double)par2 + 0.5D, par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
            
            for (int i = 3 + par1World.rand.nextInt(5) + par1World.rand.nextInt(5); i > 0;)
            {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                par1World.spawnEntityInWorld(new EntityXPOrb(par1World, par2, par3, par4, j));
            }
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 2; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}