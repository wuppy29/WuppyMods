package goblinsgiants.render;

import goblinsgiants.GoblinGiant;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderCustomWood implements ISimpleBlockRenderingHandler
{
	public static int renderId = RenderingRegistry.getNextAvailableRenderId();

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		if (modelID == renderId)
		{
			renderer.setRenderBounds(0.15f, 0f, 0.15f, 0.85f, 1f, 0.85f);
			renderInvBlock(renderer, block, metadata);
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		if (modelID == renderId)
		{
			//middle for every wood block
			renderer.setRenderBounds(0.33f, 0.33f, 0.33f, 0.66f, 0.66f, 0.66f);
			renderer.renderStandardBlock(block, x, y, z);
			
			//top
			if(world.getBlockId(x, y + 1, z) == GoblinGiant.customWood.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.66f, 0.33f, 0.66f, 1f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			if(world.getBlockId(x, y + 1, z) == Block.leaves.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.66f, 0.33f, 0.66f, 1.15f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			//bottom
			if(!world.isAirBlock(x, y - 1, z))
			{
				renderer.setRenderBounds(0.33f, 0f, 0.33f, 0.66f, 0.33f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			//left
			if(world.getBlockId(x + 1, y, z) == GoblinGiant.customWood.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.33f, 0.33f, 1f, 0.66f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			if(world.getBlockId(x + 1, y, z) == Block.leaves.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.33f, 0.33f, 1.15f, 0.66f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			//right
			if(world.getBlockId(x - 1, y, z) == GoblinGiant.customWood.blockID)
			{
				renderer.setRenderBounds(0f, 0.33f, 0.33f, 0.33f, 0.66f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			if(world.getBlockId(x - 1, y, z) == Block.leaves.blockID)
			{
				renderer.setRenderBounds(-0.15f, 0.33f, 0.33f, 0.33f, 0.66f, 0.66f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			//front
			if(world.getBlockId(x, y, z + 1) == GoblinGiant.customWood.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.33f, 0.33f, 0.66f, 0.66f, 1f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			if(world.getBlockId(x, y, z + 1) == Block.leaves.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.33f, 0.33f, 0.66f, 0.66f, 1.15f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			//behind
			if(world.getBlockId(x, y, z - 1) == GoblinGiant.customWood.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.33f, 0f, 0.66f, 0.66f, 0.33f);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			if(world.getBlockId(x, y, z - 1) == Block.leaves.blockID)
			{
				renderer.setRenderBounds(0.33f, 0.33f, -0.15f, 0.66f, 0.66f, 0.33f);
				renderer.renderStandardBlock(block, x, y, z);
			}
		}
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return renderId;
	}

	public static void renderInvBlock(RenderBlocks renderblocks, Block block, int meta)
	{
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}