package peacefulpackmod;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import peacefulpackmod.block.BlockBlazeSapling;
import peacefulpackmod.block.BlockRottenPlant;
import peacefulpackmod.block.Blockflax;

public class PeacefulEvent 
{
	@ForgeSubscribe
    public void bonemealUsed(BonemealEvent event)
    {
		if(event.world.getBlockId(event.X, event.Y, event.Z)== PeacefulPack.flax.blockID)
        {
        	((Blockflax)PeacefulPack.flax).fertilize(event.world, event.X, event.Y, event.Z);
        	event.setResult(Result.ALLOW);
        }
        if(event.world.getBlockId(event.X, event.Y, event.Z)== PeacefulPack.rottenplant.blockID)
        {
        	((BlockRottenPlant)PeacefulPack.rottenplant).fertilize(event.world, event.X, event.Y, event.Z);
        	event.setResult(Result.ALLOW);
        }
        if(event.world.getBlockId(event.X, event.Y, event.Z)== PeacefulPack.blazeSapling.blockID)
        {
        	event.world.setBlockToAir(event.X, event.Y, event.Z);
        	((BlockBlazeSapling)PeacefulPack.blazeSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
        	event.setResult(Result.ALLOW);
        }
    }
	
	@ForgeSubscribe
    public void onChunkDataEvent(ChunkDataEvent.Load evt)
	{
            NBTTagCompound nbt = evt.getData();
            
            if(!nbt.getBoolean("peacefulOresGenerated") && !evt.getChunk().getAreLevelsEmpty(2, 20))
            {
            	nbt.setBoolean("peacefulOresGenerated", true);
            	
            	World world = evt.world;
            	
            	Random random = evt.world.rand;
            	
            	switch (world.provider.dimensionId)
        		{
        			case -1: PeacefulGenerator.generateNether(world, random, evt.getChunk().xPosition, evt.getChunk().zPosition);
        			case 0: PeacefulGenerator.generateSurface(world, random, evt.getChunk().xPosition, evt.getChunk().zPosition);
        		}
            }
    }
}