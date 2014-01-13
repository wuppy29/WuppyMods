package peacefulpackmod.block;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import peacefulpackmod.PeacefulPack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlazelog extends Block
{
	public BlockBlazelog()
    {
        super(Material.field_151575_d);
        this.func_149647_a(CreativeTabs.tabBlock);
    }
	
	public IIcon func_149691_a(int par1, int par2)
    {
        if(par1 == 0 || par1 == 1)
        	return iconArray[1];
        else
        	return iconArray[0];
    }
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@SideOnly(Side.CLIENT)
	public void func_149651_a(IIconRegister par1IconRegister)
    {
		iconArray = new IIcon[2];
		for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.func_149739_a().substring(5)) + i);
        }
    }
	
	public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.func_150898_a(this);
    }

    public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.func_149636_a(world, entityplayer, i, j, k, l);
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if(world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for(int i1 = -byte0; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for(int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        Block l1 = world.func_147439_a(i + i1, j + j1, k + k1);
                        if(l1 != PeacefulPack.blazeleaves)
                        {
                            continue;
                        }
                        int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
                        if((i2 & 8) == 0)
                        {
                            world.setBlockMetadataWithNotify(i + i1, j + j1, k + k1, i2 | 8, 2);
                        }
                    }

                }

            }

        }
    }

    public int damageDropped(int par1)
    {
        return par1;
    }
}