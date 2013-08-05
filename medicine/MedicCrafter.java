package medicine;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MedicCrafter
{
	public static void registerCrafting()
	{
		GameRegistry.addRecipe(new ItemStack(Medicine.healthPack, 1), new Object[]
				{
					"XZX", "ZCZ", "XZX", 'X', Item.paper, 'Z', Item.redstone, 'C', Item.appleRed
				});
		GameRegistry.addRecipe(new ItemStack(Medicine.regenPack, 1), new Object[]
				{
					"XZX", "ZCZ", "XZX", 'X', Item.paper, 'Z', Item.glowstone, 'C', Item.appleRed
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Medicine.material, 3, 0), new Object[]
				{
					new ItemStack(Item.ingotIron), new ItemStack(Item.glassBottle)
				});
		GameRegistry.addRecipe(new ItemStack(Medicine.material, 1, 1), new Object[]
				{
					" X ", "XCX", " X ", 'X', new ItemStack(Item.dyePowder, 1, 4), 'C', Item.appleRed
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Medicine.normalsyringe, 1), new Object[]
				{
					new ItemStack(Medicine.material, 1, 1), new ItemStack(Medicine.material, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(Medicine.medictable), new Object[]
				{
					"XCX", "XVX", "XXX", 'C', new ItemStack(Medicine.healthPack, 1, 1), 'V', Block.stone, 'X', Item.ingotIron
				});
	}
}
