package peacefulpackmod;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class PeacefulFuel implements IFuelHandler 
{
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.itemID == PeacefulPack.sulphDust.itemID)
			return 1000;
		if(fuel == new ItemStack(PeacefulPack.blazelog, 1))
			return 1600;
		
		else
			return 0;
	}
}
