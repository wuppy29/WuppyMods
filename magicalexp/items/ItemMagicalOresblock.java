package magicalexp.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMagicalOresblock extends ItemBlock 
{
	public ItemMagicalOresblock(int i, Block block) 
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
				name = "expore";
				break;
			}
			case 1: 
			{	
				name = "cobbleexpore"; 
				break;
			}
			default: name = "expore";
		}
		return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int par1)
    {
        return par1;
    }
}