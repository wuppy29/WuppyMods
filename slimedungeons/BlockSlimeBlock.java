package slimedungeons;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlimeBlock extends Block
{
	public BlockSlimeBlock(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(SlimeDungeon.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.slimeBall.itemID;
    }
	
    public int quantityDropped(Random par1Random)
    {
        return 2;
    }
}