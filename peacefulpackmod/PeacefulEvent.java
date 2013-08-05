package peacefulpackmod;

import peacefulpackmod.block.BlockBlazeSapling;
import peacefulpackmod.block.BlockRottenPlant;
import peacefulpackmod.block.Blockflax;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

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
}
