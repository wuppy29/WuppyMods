package koi;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class EntityAIMoveToWater extends EntityAIBase
{
	EntityCreature entity;
	World world;
	
	public EntityAIMoveToWater(EntityCreature entity, World world) 
	{
		this.entity = entity;
		this.world = world;
	}

	public boolean shouldExecute() 
	{
		int x = (int) entity.posX;
		int y = (int) entity.posY;
		int z = (int) entity.posZ;
		
		if(entity.isInWater() || world.getBlockId(x, y - 1, z) == Block.waterStill.blockID || world.getBlockId(x, y - 1, z) == Block.waterMoving.blockID || entity.hasPath())
			return false;
		else
			return true;
	}
	
	List<Integer> surroundingBlocks = new ArrayList<Integer>();
	List<Integer> xOffset = new ArrayList<Integer>();
	List<Integer> yOffset = new ArrayList<Integer>();
	List<Integer> zOffset = new ArrayList<Integer>();
	
	public void updateTask()
    {
		if(!entity.hasPath())
		{
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			
			for(int xOff = -5; xOff < 5; xOff++)
			{
				for(int yOff = 0; yOff < 3; yOff++)
				{
					for(int zOff = -5; zOff < 5; zOff++)
					{
						surroundingBlocks.add(world.getBlockId(x + xOff, y - yOff, z + zOff));
						xOffset.add(xOff);
						yOffset.add(yOff);
						zOffset.add(zOff);
					}
				}
			}
			
			for(int i = 0; i < surroundingBlocks.size(); i++)
			{
				if(!entity.hasPath())
				{
					if(surroundingBlocks.get(i) == Block.waterMoving.blockID || surroundingBlocks.get(i) == Block.waterStill.blockID)
					{
						int newx = x + xOffset.get(i);
						int newy = y - yOffset.get(i);
						int newz = z + zOffset.get(i);
						//world.getEntityPathToXYZ(entity, newx, newy, newz, 5F, false, true, false, false);
						entity.getNavigator().tryMoveToXYZ(newx, newy, newz, 0.5D);
						//entity.setPathToEntity(entity.getNavigator().getPathToXYZ(newx, newy, newz));
						//TODO make smarter move code...
						//System.out.println(newx + " " + newy + " " + newz);
					}
				}
			}
		}
    }
}