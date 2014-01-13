package peacefulpackmod.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import peacefulpackmod.PeacefulPack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPeacefulOres extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockPeacefulOres()
	{
		super(Material.field_151576_e);
		this.func_149647_a(CreativeTabs.tabBlock);
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_149691_a(int par1, int par2)
	{
		return this.icons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void func_149651_a(IIconRegister par1IconRegister)
	{
		icons = new IIcon[5];

		for (int i = 0; i < icons.length; i++)
		{
			if (i == 0)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":sulphur");
			if (i == 1)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":niter");
			if (i == 2)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 1");
			if (i == 3)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 2");
			if (i == 4)
				icons[i] = par1IconRegister.registerIcon(PeacefulPack.modid + ":fossil 3");
		}
	}

	@Override
	public void func_149690_a(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		super.func_149690_a(par1World, par2, par3, par4, par5, par6, par7);

		int var8 = 0;

		var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 1, 3);

		this.func_149657_c(par1World, par2, par3, par4, var8);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

		if(metadata == 0)
		{
			ret.add(new ItemStack(PeacefulPack.sulphDust));
		}
		if(metadata == 1)
		{
			ret.add(new ItemStack(PeacefulPack.niterDust));
		}
		if(metadata == 2)
		{
			ret.add(new ItemStack(Items.bone));
		}
		if(metadata == 3)
		{
			ret.add(new ItemStack(Items.bone));
		}
		if(metadata == 4)
		{
			ret.add(new ItemStack(Items.bone));
		}
		
		return ret;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 5; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}
}
