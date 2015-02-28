package com.wuppy.peacefulpackmod.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.wuppy.peacefulpackmod.PeacefulPack;
import com.wuppy.peacefulpackmod.item.ItemPeacefulOresblock;
import com.wuppy.peacefulpackmod.item.ModItems;

public class BlockPeacefulOres extends Block
{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockPeacefulOres.OreType.class);

	private final String name = "oreBlock";

	public BlockPeacefulOres()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, ItemPeacefulOresblock.class, name);
		setUnlocalizedName(PeacefulPack.modid + "_" + name);

		setStepSound(soundTypeStone);
		setHardness(3F);
		setResistance(1.0F);

		setCreativeTab(PeacefulPack.ppBlocksTab);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockPeacefulOres.OreType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockPeacefulOres.OreType) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, VARIANT);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (state.getValue(VARIANT) == OreType.SULPHER || state.getValue(VARIANT) == OreType.NITER)
		{
			return ModItems.peacefulMaterial;
		}
		else
			return Items.bone;
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		if(state.getValue(VARIANT) == OreType.NITER)
			return 1;
		else
			return 0;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < BlockPeacefulOres.OreType.values().length; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}

	public static enum OreType implements IStringSerializable
	{
		SULPHER(0, "sulphur"), NITER(1, "niter"), FOSSIL1(2, "fossil1"), FOSSIL2(3, "fossil2"), FOSSIL3(4, "fossil3");

		private final int metadata;
		private final String name;

		private OreType(int metadata, String name)
		{
			this.metadata = metadata;
			this.name = name;
		}

		static
		{
			BlockPeacefulOres.OreType[] values = values();

			for (OreType type : values)
			{
				values()[type.getMetadata()] = type;
			}
		}

		public int getMetadata()
		{
			return this.metadata;
		}

		@Override
		public String getName()
		{
			return name;
		}

		public static BlockPeacefulOres.OreType byMetadata(int metadata)
		{
			if (metadata < 0 || metadata >= values().length)
			{
				metadata = 0;
			}

			return values()[metadata];
		}

		private String getResouceLocation()
		{
			return PeacefulPack.modid + ":" + name;
		}

		public static void registerVariants()
		{
			String[] variants = new String[values().length];

			for (int i = 0; i < values().length; i++)
			{
				variants[i] = values()[i].getResouceLocation();
			}

			ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.oreBlock), variants);
		}

		public static void registerRenders()
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			for (int i = 0; i < values().length; i++)
			{
				renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.oreBlock), i, new ModelResourceLocation(values()[i].getResouceLocation(), "inventory"));
			}
		}
	}
}