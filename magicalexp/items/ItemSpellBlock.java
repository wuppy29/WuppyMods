package magicalexp.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSpellBlock extends ItemBlock 
{

	public ItemSpellBlock(int i, Block block) 
	{
		super(i);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) 
	{
		String name = "";
		switch(itemstack.getItemDamage()) 
		{
			case 0: 
			{
				name = "thunder";
				break;
			}
			case 1: 
			{	
				name = "explosion"; 
				break;
			}
			case 2: 
			{	
				name = "fire"; 
				break;
			}
			case 3:
			{
				name = "water";
				break;
			}
			case 4:
			{
				name = "lava";
				break;
			}
			default: name = "thunder";
		}
		return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int par1)
    {
        return par1;
    }
}
