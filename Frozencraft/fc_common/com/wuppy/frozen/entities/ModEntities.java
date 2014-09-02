package com.wuppy.frozen.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.wuppy.frozen.FrozenCraft;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities
{
	public static void loadEntities(FrozenCraft mod)
	{
		EntityRegistry.registerModEntity(EntityIceBoltElsa.class, "iceboltelsa", 38, mod, 40, 1, true);
		EntityRegistry.registerModEntity(EntityIceBoltFailed.class, "iceboltfailed", 39, mod, 40, 1, true);
		EntityRegistry.registerModEntity(EntityIceBoltPlayer.class, "iceboltplayer", 40, mod, 40, 1, true);
		
		EntityRegistry.registerModEntity(EntityElsa.class, "elsa", 0, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAnna.class, "anna", 1, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityKristoff.class, "kristoff", 2, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityHans.class, "hans", 3, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityDuke.class, "duke", 4, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityThug.class, "thug", 5, mod, 80, 3, true);
		//EntityRegistry.registerModEntity(EntityOlaf.class, "olaf", 6, mod, 80, 3, true);
		//EntityRegistry.registerModEntity(EntitySven.class, "sven", 7, mod, 80, 3, true);
		//EntityRegistry.registerModEntity(EntityMarshmallow.class, "marshmallow", 8, mod, 80, 3, true);
		
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
		{
			if (BiomeGenBase.getBiomeGenArray()[i] != null)
			{
				EntityRegistry.addSpawn(EntityElsa.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityAnna.class, 5, 1, 1, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityKristoff.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityHans.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityDuke.class, 7, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityThug.class, 7, 2, 4, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				
				/*if(BiomeGenBase.getBiomeGenArray()[i].getTempCategory() == TempCategory.COLD)
				{
					EntityRegistry.addSpawn(EntityOlaf.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray()[i]);
					EntityRegistry.addSpawn(EntitySven.class, 5, 1, 1, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray()[i]);
					EntityRegistry.addSpawn(EntityMarshmallow.class, 5, 1, 1, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray()[i]);
				}*/
			}
		}
		
		registerEntityEgg(EntityElsa.class, 0x64c6e6, 0xa2dafa);
		registerEntityEgg(EntityAnna.class, 0xe71879, 0xc15c33);
		registerEntityEgg(EntityKristoff.class, 0x2c2d28, 0xcfae66);
		registerEntityEgg(EntityHans.class, 0xffffff, 0xc05449);
		registerEntityEgg(EntityDuke.class, 0x110e17, 0xe3e4e6);
		registerEntityEgg(EntityThug.class, 0x400e0e, 0x2d201a);
		//registerEntityEgg(EntityOlaf.class, 0xf8fcec, 0xce5b1c);
		//registerEntityEgg(EntitySven.class, 0x644627, 0xe9e7e4);
		//registerEntityEgg(EntityMarshmallow.class, 0xe1e8f0, 0x4e9dc6);
	}
	
	static int startEntityId = 40;

	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}
}