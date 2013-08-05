package peacefulpackmod.block;

import java.util.Random;

import peacefulpackmod.PeacefulPack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBuriedRemains extends Block
{
	public BlockBuriedRemains(int par1)
	{
		super(par1, Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}

	public int idDropped(int i, Random random, int j)
	{
		return Item.rottenFlesh.itemID;
	}
}
