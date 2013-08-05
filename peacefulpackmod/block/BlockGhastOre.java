package peacefulpackmod.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import peacefulpackmod.PeacefulPack;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockGhastOre extends Block
{
	public BlockGhastOre(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(brokenByPlayer)
		{
			for (int i : surroundingBlocks)
			{
				if (i == Block.lavaMoving.blockID || i == Block.lavaStill.blockID)
				{
					return Item.ghastTear.itemID;
				}
			}
		}
		return this.blockID;
	}
	
	boolean brokenByPlayer = false;
	
	List<Integer> surroundingBlocks;
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l)
	{
		brokenByPlayer = true;
		surroundingBlocks = null;
		surroundingBlocks = Arrays.asList(world.getBlockId(x + 1, y, z), world.getBlockId(x - 1, y, z), world.getBlockId(x, y, z + 1), world.getBlockId(x, y, z - 1), world.getBlockId(x, y + 1, z), world.getBlockId(x, y - 1, z));
		
		for (int i : surroundingBlocks)
		{
			if (i == Block.lavaMoving.blockID || i == Block.lavaStill.blockID)
			{
				int var8 = 0;
	        	
	        	var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);
	        	
	        	this.dropXpOnBlockBreak(world, x, y, z, var8);
			}
		}
	}
	
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
}