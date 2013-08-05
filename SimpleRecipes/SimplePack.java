package SimpleRecipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SimplePack.modid, name = "Simple Recipes", version = "1.7.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SimplePack 
{
	public static final String modid = "wuppy29_simplerecipes";
	
	@EventHandler
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.addRecipe(new ItemStack(Block.blockClay, 4), new Object[]
				{
					"ZXZ", "XCX", "ZXZ", 'Z', new ItemStack(Item.dyePowder, 1, 15), 'C', Item.bucketWater, 'X', Block.sand
				});
		GameRegistry.addRecipe(new ItemStack(Block.cobblestoneMossy, 1), new Object[]
				{
					" X ", "XZX", " X ", 'Z', Block.cobblestone, 'X', Block.vine
				});
		GameRegistry.addRecipe(new ItemStack(Block.web, 5), new Object[]
				{
					"X X", " X ", "X X", 'X', Item.silk
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.obsidian, 1), new Object[]
				{
					new ItemStack(Item.bucketWater), new ItemStack(Item.bucketLava)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.gravel, 2), new Object[]
				{
					new ItemStack(Item.flint), new ItemStack(Block.cobblestone)
				});
		GameRegistry.addRecipe(new ItemStack(Block.sponge, 4), new Object[]
				{
					" X ", "XZX", " X ", 'X', new ItemStack(Block.cloth, 1, 11), 'Z', Item.bucketWater
				});
		GameRegistry.addRecipe(new ItemStack(Block.ice, 1), new Object[]
				{
					" X ", "XZX", " X ", 'X', Item.snowball, 'Z', Item.bucketWater
				});
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1, 1), new Object[]
				{
					" X ", "XZX", " X ", 'Z', new ItemStack(Block.stoneBrick, 1, 0), 'X', Block.vine
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.grass), new Object[]
				{
					new ItemStack(Block.dirt), new ItemStack(Block.vine)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.bone), new Object[]
				{
					new ItemStack(Item.chickenRaw)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.bone), new Object[]
				{
					new ItemStack(Item.porkRaw)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.bone), new Object[]
				{
					new ItemStack(Item.beefRaw)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 2), new Object[]
				{
					new ItemStack(Item.flint), new ItemStack(Block.stoneBrick)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.redstone, 2), new Object[]
				{
					new ItemStack(Item.glowstone), new ItemStack(Item.dyePowder, 1, 1)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.glowstone, 2), new Object[]
				{
					new ItemStack(Item.redstone), new ItemStack(Item.dyePowder, 1, 11)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.book, 1), new Object[] 
				{
					new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Block.cloth)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 1, 0), new Object[]
				{
					new ItemStack(Item.coal)
				});
		GameRegistry.addRecipe(new ItemStack(Item.arrow, 2), new Object[]
				{
					"XCX",
					" V ",
					" B ",
					'X', Block.leaves, 'C', Item.silk, 'V', Item.stick, 'B', Item.flint
				});
		GameRegistry.addSmelting(Block.netherrack.blockID, new ItemStack(Block.netherBrick), 0.1F);
		GameRegistry.addSmelting(Block.stoneBrick.blockID, new ItemStack(Block.stoneBrick, 1, 3), 0.1F);
	}
}
