package com.wuppy.goblinsgiants.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.dimension.savannah.TeleporterGoblinsGiantsSavannah;
import com.wuppy.goblinsgiants.tabs.ModTabs;
import com.wuppy.goblinsgiants.worldgen.ModGeneration;

public class BlockGoblinPortal extends BlockPortal
{
	public BlockGoblinPortal()
	{
		super();
		this.setCreativeTab(ModTabs.ggBlocksTab);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{

	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;

			MinecraftServer mServer = MinecraftServer.getServer();

			if (player.timeUntilPortal > 0)
			{
				player.timeUntilPortal = 10;
			}
			else if (player.dimension != ModGeneration.dimension)
			{
				player.timeUntilPortal = 10;

				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, ModGeneration.dimension, new TeleporterGoblinsGiantsSavannah(mServer.worldServerForDimension(ModGeneration.dimension)));
			}
			else
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterGoblinsGiantsSavannah(mServer.worldServerForDimension(1)));
			}
		}
	}

	@Override
	public boolean func_150000_e(World par1World, int par2, int par3, int par4)
	{
		byte var5 = 0;
		byte var6 = 0;

		if (par1World.getBlock(par2 - 1, par3, par4) == Blocks.sandstone || par1World.getBlock(par2 + 1, par3, par4) == Blocks.sandstone)
		{
			var5 = 1;
		}

		if (par1World.getBlock(par2, par3, par4 - 1) == Blocks.sandstone || par1World.getBlock(par2, par3, par4 + 1) == Blocks.sandstone)
		{
			var6 = 1;
		}

		if (var5 == var6)
		{
			return false;
		}
		else
		{
			if (par1World.getBlock(par2 - var5, par3, par4 - var6) == Blocks.air)
			{
				par2 -= var5;
				par4 -= var6;
			}

			int var7;
			int var8;

			for (var7 = -1; var7 <= 2; ++var7)
			{
				for (var8 = -1; var8 <= 3; ++var8)
				{
					boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;

					if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3)
					{
						Block var10 = par1World.getBlock(par2 + var5 * var7, par3 + var8, par4 + var6 * var7);

						if (var9)
						{
							if (var10 != Blocks.sandstone)
							{
								return false;
							}
						}
						else if (var10 != Blocks.air && var10 != Blocks.fire)
						{
							return false;
						}
					}
				}
			}

			for (var7 = 0; var7 < 2; ++var7)
			{
				for (var8 = 0; var8 < 3; ++var8)
				{
					par1World.setBlock(par2 + var5 * var7, par3 + var8, par4 + var6 * var7, this, 0, 2);
				}
			}

			return true;
		}
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
	{

	}

	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 0;
	}
}