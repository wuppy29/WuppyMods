package com.wuppy.magicalexp;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.wuppy.magicalexp.blocks.ModBlocks;
import com.wuppy.magicalexp.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class MagicalRecipes 
{
	public MagicalRecipes()
	{
    	//bottles
        GameRegistry.addShapelessRecipe(new ItemStack(Items.experience_bottle, 1), new Object[]
                {
                    new ItemStack(ModItems.components, 1, 0), new ItemStack(Items.potionitem, 1, 0)
                });
        GameRegistry.addRecipe(new ItemStack(ModItems.xpbottlexl, 1), new Object[]
                {
                    "XX", "XX", 'X', Items.experience_bottle
                });
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.thunderbottle, 1), new Object[]
        		{
        			new ItemStack(Items.gunpowder), new ItemStack(ModItems.xpbottlexl), new ItemStack(Items.fire_charge)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tntbottle, 1), new Object[]
        		{
        			new ItemStack(Items.gunpowder), new ItemStack(ModItems.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fuelbottle, 1), new Object[]
        		{
        			new ItemStack(Items.coal), new ItemStack(Items.experience_bottle)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fuelbottle, 1), new Object[]
        		{
        			new ItemStack(Items.coal, 1, 1), new ItemStack(Items.experience_bottle)
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.clusterbottle, 1), new Object[]
        		{
        			"XZX", "XCX", 'X', Items.gunpowder, 'Z', ModItems.tntbottle, 'C', ModItems.xpbottlexl
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.firebottle, 1), new Object[]
        		{
        			new ItemStack(Items.fire_charge), new ItemStack(ModItems.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.dirtbottle, 1), new Object[]
        		{
        			new ItemStack(Blocks.dirt), new ItemStack(ModItems.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bonebottle, 1), new Object[]
        		{
        			new ItemStack(Items.dye, 1, 15), new ItemStack(ModItems.xpbottlexl)
        		});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.airbottle, 1), new Object[]
        		{
        			new ItemStack(Items.experience_bottle), new ItemStack(Items.sugar)
        		});
        
        //experion tools
        GameRegistry.addRecipe(new ItemStack(ModItems.components, 1, 1), new Object[]
        		{
        			"XXX", "XZX", "XXX", 'X', Items.experience_bottle, 'Z', Items.iron_ingot
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.exppick, 1), new Object[]
        		{
        			"XXX", " Z ", " Z ", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.expaxe, 1), new Object[]
        		{
        			"XX ", "XZ ", " Z ", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.expaxe, 1), new Object[]
        		{
        			" XX", " ZX", " Z ", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.expshovel, 1), new Object[]
        		{
        			"X", "Z", "Z", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.expsword, 1), new Object[]
        		{
    				"X", "X", "Z", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.exphoe, 1), new Object[]
        		{
        			"XX ", " Z ", " Z ", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.exphoe, 1), new Object[]
        		{
        			" XX", " Z ", " Z ", 'X', new ItemStack(ModItems.components, 1, 1), 'Z', Items.stick
        		});
        
        //staffs
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.components, 1, 2), new Object[]
        		{
        			new ItemStack(Items.stick), new ItemStack(Items.diamond), new ItemStack(ModItems.xpbottlexl), new ItemStack(ModItems.xpbottlexl)
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.components, 1, 3), new Object[]
        		{
        			"XXX", "XZX", "XXX", 'X', Blocks.dirt, 'Z', new ItemStack(ModItems.components, 1, 2)
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.thunderstaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " Z ", 'X', ModItems.thunderbottle, 'C', new ItemStack(ModItems.components, 1, 2), 'Z', ModItems.xpbottlexl
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.firestaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " Z ", 'X', ModItems.firebottle, 'X', new ItemStack(ModItems.components, 1, 2), 'Z', ModItems.xpbottlexl
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.earthstaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " B ", 'X', ModItems.dirtbottle, 'X', new ItemStack(ModItems.components, 1, 3), 'Z', ModItems.xpbottlexl, 'B', ModItems.bonebottle
        		});
        GameRegistry.addRecipe(new ItemStack(ModItems.earthstaff, 1), new Object[]
        		{
        			" X ", "ZCZ", " B ", 'X', ModItems.bonebottle, 'X', new ItemStack(ModItems.components, 1, 3), 'Z', ModItems.xpbottlexl, 'B', ModItems.dirtbottle
        		});
        
        //spells
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.spell, 1, 0), true, new Object[]
        {
			" V ", " Z ", "CXC", 'X', Blocks.stone, 'Z', ModItems.thunderbottle, 'C', new ItemStack(ModItems.components, 1, 0) , 'V', "nuggetIron"
		}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.spell, 1, 1), new Object[]
        {
        	" V ", " Z ", "CXC", 'X', Blocks.stone, 'Z', ModItems.tntbottle, 'C', new ItemStack(ModItems.components, 1, 0) , 'V', "nuggetIron"
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.spell, 1, 2), new Object[]
        {
        	" V ", " Z ", "CXC", 'X', Blocks.stone, 'Z', ModItems.firebottle, 'C', new ItemStack(ModItems.components, 1, 0) , 'V', "nuggetIron"
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.spell, 1, 3), new Object[]
        {
        	" V ", "BZB", "CXC", 'X', Blocks.stone, 'Z', ModItems.xpbottlexl, 'C', new ItemStack(ModItems.components, 1, 0) , 'V', "nuggetIron", 'B', Items.water_bucket
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.spell, 1, 4), new Object[]
        {
        	" V ", "BZB", "CXC", 'X', Blocks.stone, 'Z', ModItems.xpbottlexl, 'C', new ItemStack(ModItems.components, 1, 0) , 'V', "nuggetIron", 'B', Items.lava_bucket
        }));
        
        //nuggets
        ArrayList<ItemStack> ironNuggets = OreDictionary.getOres("nuggetIron");
        if(!ironNuggets.isEmpty())
        {
        	//iron nuggets found
        	ItemStack nugget = ironNuggets.get(0);
        	
        	GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot), new Object[]
            {
        		nugget, nugget, nugget, nugget, nugget, nugget, nugget, nugget, nugget
            });
        	
        	nugget.stackSize = 9;
        	
        	GameRegistry.addShapelessRecipe(nugget, new Object[]
            {
            	new ItemStack(Items.iron_ingot)
            });
        }
        
        //mob egg recipes
        
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 50), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.gunpowder, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 51), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.bone, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 52), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.string, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 54), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.rotten_flesh, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 55), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.slime_ball, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 56), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.ghast_tear, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 57), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.gold_nugget, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 58), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.ender_pearl, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 59), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.spider_eye, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 60), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Blocks.stone, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 61), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.blaze_rod, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 62), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.magma_cream, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 90), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.porkchop, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 91), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Blocks.wool, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 92), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.beef, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 93), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.chicken, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 94), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.dye, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 95), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.cooked_porkchop, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 96), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Blocks.red_mushroom, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 97), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.snowball, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 98), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Items.cooked_fished, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 99), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Blocks.iron_block, 'V', Items.egg
                });
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 120), new Object[]
                {
                    "XCX", "XVX", "XXX", 'X', Items.experience_bottle, 'C', Blocks.planks, 'V', Items.egg
                });
	}
}
