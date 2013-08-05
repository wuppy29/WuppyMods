package peacefulpackmod.block;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockBlazelog extends Block
{
	public BlockBlazelog(int i)
    {
        super(i, Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	
	public Icon getIcon(int par1, int par2)
    {
        if(par1 == 0 || par1 == 1)
        	return iconArray[1];
        else
        	return iconArray[0];
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
	
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return PeacefulPack.blazelog.blockID;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
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
                        int l1 = world.getBlockId(i + i1, j + j1, k + k1);
                        if(l1 != PeacefulPack.blazeleaves.blockID)  ///Leaf//////////////
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