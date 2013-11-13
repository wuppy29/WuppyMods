package nethereye;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class NetherEyeLogin implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		if (NetherEye.outdated)
		{
			player.addChatMessage("Nether Eye is outdated. \nChangelog: \n" + NetherEye.updates);
		}
	}
	
	@Override
	public void onPlayerLogout(EntityPlayer player)
	{
		
	}
	
	@Override
	public void onPlayerChangedDimension(EntityPlayer player)
	{
		
	}
	
	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{
		
	}
}