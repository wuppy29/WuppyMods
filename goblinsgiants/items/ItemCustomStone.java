package goblinsgiants.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCustomStone extends ItemBlock
{
	public ItemCustomStone(int i, Block block)
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
				name = "gold";
				break;
			}
			case 1:
			{
				name = "iron";
				break;
			}
			case 2:
			{
				name = "coal";
				break;
			}
			case 3:
			{
				name = "diamond";
				break;
			}
			case 4:
			{
				name = "redstone";
				break;
			}
			case 5:
			{
				name = "lapis";
				break;
			}
			default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}

	public int getMetadata(int par1)
    {
        return par1;
    }
}
