package magicalexp;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MagicalRecipes 
{
	public MagicalRecipes()
	{

    	//bottles
        GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), new Object[]
                {
                    new ItemStack(MagicalExperience.components, 1, 0), new ItemStack(Item.potion, 1, 0)
                });
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.xpbottlexl, 1), new Object[]
                {
                    "XX", "XX", 'X', Item.expBottle
                });
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.thunderbottle, 1), new Object[]
        		{
        			new ItemStack(Item.gunpowder), new ItemStack(MagicalExperience.xpbottlexl), new ItemStack(Item.fireballCharge)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.tntbottle, 1), new Object[]
        		{
        			new ItemStack(Item.gunpowder), new ItemStack(MagicalExperience.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.fuelbottle, 1), new Object[]
        		{
        			new ItemStack(Item.coal), new ItemStack(Item.expBottle)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.fuelbottle, 1), new Object[]
        		{
        			new ItemStack(Item.coal, 1, 1), new ItemStack(Item.expBottle)
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.clusterbottle, 1), new Object[]
        		{
        			"XZX", "XCX", 'X', Item.gunpowder, 'Z', MagicalExperience.tntbottle, 'C', MagicalExperience.xpbottlexl
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.firebottle, 1), new Object[]
        		{
        			new ItemStack(Item.fireballCharge), new ItemStack(MagicalExperience.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.dirtbottle, 1), new Object[]
        		{
        			new ItemStack(Block.dirt), new ItemStack(MagicalExperience.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.bonebottle, 1), new Object[]
        		{
        			new ItemStack(Item.dyePowder, 1, 15), new ItemStack(MagicalExperience.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.airbottle, 1), new Object[]
        		{
        			new ItemStack(Item.expBottle), new ItemStack(Item.sugar)
        		});
        
        //experion tools
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.components, 1, 1), new Object[]
        		{
        			"XXX", "XZX", "XXX", 'X', Item.expBottle, 'Z', Item.ingotIron
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.exppick, 1), new Object[]
        		{
        			"XXX", " Z ", " Z ", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.expaxe, 1), new Object[]
        		{
        			"XX ", "XZ ", " Z ", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.expaxe, 1), new Object[]
        		{
        			" XX", " ZX", " Z ", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.expshovel, 1), new Object[]
        		{
        			"X", "Z", "Z", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.expsword, 1), new Object[]
        		{
    				"X", "X", "Z", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.exphoe, 1), new Object[]
        		{
        			"XX ", " Z ", " Z ", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.exphoe, 1), new Object[]
        		{
        			" XX", " Z ", " Z ", 'X', new ItemStack(MagicalExperience.components, 1, 1), 'Z', Item.stick
        		});
        
        //staffs
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.components, 1, 2), new Object[]
        		{
        			new ItemStack(Item.stick), new ItemStack(Item.diamond), new ItemStack(MagicalExperience.xpbottlexl), new ItemStack(MagicalExperience.xpbottlexl)
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.components, 1, 3), new Object[]
        		{
        			"XXX", "XZX", "XXX", 'X', Block.dirt, 'Z', new ItemStack(MagicalExperience.components, 1, 2)
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.thunderstaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " Z ", 'X', MagicalExperience.thunderbottle, 'C', new ItemStack(MagicalExperience.components, 1, 2), 'Z', MagicalExperience.xpbottlexl
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.firestaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " Z ", 'X', MagicalExperience.firebottle, 'X', new ItemStack(MagicalExperience.components, 1, 2), 'Z', MagicalExperience.xpbottlexl
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.earthstaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " B ", 'X', MagicalExperience.dirtbottle, 'X', new ItemStack(MagicalExperience.components, 1, 3), 'Z', MagicalExperience.xpbottlexl, 'B', MagicalExperience.bonebottle
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.earthstaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " B ", 'X', MagicalExperience.bonebottle, 'X', new ItemStack(MagicalExperience.components, 1, 3), 'Z', MagicalExperience.xpbottlexl, 'B', MagicalExperience.dirtbottle
        		});
        
        //spells
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.spell, 1, 0), new Object[]
        		{
        			" V ", " Z ", "CXC", 'X', Block.stone, 'Z', MagicalExperience.thunderbottle, 'C', new ItemStack(MagicalExperience.components, 1, 0) , 'V', new ItemStack(MagicalExperience.components, 1, 4)
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.spell, 1, 1), new Object[]
        		{
        			" V ", " Z ", "CXC", 'X', Block.stone, 'Z', MagicalExperience.tntbottle, 'C', new ItemStack(MagicalExperience.components, 1, 0) , 'V', new ItemStack(MagicalExperience.components, 1, 4)
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.spell, 1, 2), new Object[]
        		{
        			" V ", " Z ", "CXC", 'X', Block.stone, 'Z', MagicalExperience.firebottle, 'C', new ItemStack(MagicalExperience.components, 1, 0) , 'V', new ItemStack(MagicalExperience.components, 1, 4)
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.spell, 1, 3), new Object[]
        		{
        			" V ", "BZB", "CXC", 'X', Block.stone, 'Z', MagicalExperience.xpbottlexl, 'C', new ItemStack(MagicalExperience.components, 1, 0) , 'V', new ItemStack(MagicalExperience.components, 1, 4), 'B', Item.bucketWater
        		});
        GameRegistry.addRecipe(new ItemStack(MagicalExperience.spell, 1, 4), new Object[]
        		{
        			" V ", "BZB", "CXC", 'X', Block.stone, 'Z', MagicalExperience.xpbottlexl, 'C', new ItemStack(MagicalExperience.components, 1, 0) , 'V', new ItemStack(MagicalExperience.components, 1, 4), 'B', Item.bucketLava
        		});
        
        //etc
        GameRegistry.addShapelessRecipe(new ItemStack(MagicalExperience.components, 4, 4), new Object[]
        		{
        			new ItemStack(Item.ingotIron)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 1), new Object[]
        		{
        			new ItemStack(MagicalExperience.components, 1, 4), new ItemStack(MagicalExperience.components, 1, 4), new ItemStack(MagicalExperience.components, 1, 4), new ItemStack(MagicalExperience.components, 1, 4)
        		});
        
        //mob egg recipes
        
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 50), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.gunpowder, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.bone, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 52), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.silk, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.rottenFlesh, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.slimeBall, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 56), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.ghastTear, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 57), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.goldNugget, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 58), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.enderPearl, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 59), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.spiderEye, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 60), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Block.stone, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 61), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.blazeRod, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 62), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.magmaCream, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 90), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.porkRaw, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 91), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Block.cloth, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 92), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.beefRaw, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 93), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.chickenRaw, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 94), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.dyePowder, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 95), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.porkCooked, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 96), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', BlockFlower.mushroomRed, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 97), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.snowball, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 98), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Item.fishCooked, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 99), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Block.blockIron, 'V', Item.egg
                });
        GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 120), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Item.expBottle, 'C', Block.planks, 'V', Item.egg
                });
	}
}
