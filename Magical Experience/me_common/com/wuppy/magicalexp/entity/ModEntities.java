package com.wuppy.magicalexp.entity;

import com.wuppy.magicalexp.MagicalExperience;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities
{
	public static void loadEntities(MagicalExperience mod)
	{
		EntityRegistry.registerModEntity(EntityExpBottlexl.class, "expbottlexl", 0, mod, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityThunderbottle.class, "thunderbottle", 1, mod, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityTntbottle.class, "tntbottle", 2, mod, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityClusterBottle.class, "clusterbottle", 3, mod, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityMagicThunder.class, "magicthunder", 4, mod, 0, 40, true);
    	EntityRegistry.registerModEntity(EntityFirebottle.class, "firebottle", 5, mod, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityDirtBottle.class, "dirtbottle", 6, mod, 40, 40, true);
    	EntityRegistry.registerModEntity(EntityBonemealBottle.class, "bonemealbottle", 7, mod, 40, 40, true);
	}
}