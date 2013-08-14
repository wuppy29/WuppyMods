package pp_t_addon;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGrave extends ItemBlock
{
	public ItemGrave(int i, Block block)
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
				name = "skull";
				break;
			}
			case 1:
			{
				name = "bones";
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
