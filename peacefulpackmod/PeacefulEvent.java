package peacefulpackmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import peacefulpackmod.block.BlockBlazeSapling;
import peacefulpackmod.block.BlockRottenPlant;
import peacefulpackmod.block.Blockflax;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PeacefulEvent 
{
	@SubscribeEvent
    public void bonemealUsed(BonemealEvent event)
    {
		if(event.world.func_147439_a(event.x, event.y, event.z)== PeacefulPack.flax)
        {
        	((Blockflax)PeacefulPack.flax).fertilize(event.world, event.x, event.y, event.z);
        }
        if(event.world.func_147439_a(event.x, event.y, event.z)== PeacefulPack.rottenplant)
        {
        	((BlockRottenPlant)PeacefulPack.rottenplant).fertilize(event.world, event.x, event.y, event.z);
        }
        if(event.world.func_147439_a(event.x, event.y, event.z)== PeacefulPack.blazeSapling)
        {
        	event.world.func_147468_f(event.x, event.y, event.z);
        	((BlockBlazeSapling)PeacefulPack.blazeSapling).growTree(event.world, event.x, event.y, event.z, event.world.rand);
        }
    }
	
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(PeacefulPack.outdated)
		{
			event.player.func_146105_b(new ChatComponentText("Peacefulpack is outdated."));
			event.player.func_146105_b(new ChatComponentText("Changelog: "));
			event.player.func_146105_b(new ChatComponentText(PeacefulPack.updates));
		}
	}
	
	@SubscribeEvent
	public void dropSpiderEyes(HarvestDropsEvent event)
	{
		if(PeacefulPack.changeWeb)
		{
			if(event.block == Blocks.web)
			{
				event.drops.add(new ItemStack(Items.spider_eye));
			}
		}
	}
}