package com.wuppy.goblinsgiants.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.world.biome.BiomeGenBase;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.config.Config;
import com.wuppy.goblinsgiants.worldgen.ModGeneration;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities
{
	public static void init(GoblinGiant mod)
	{
		GoblinGiant.proxy.registerEntityRenders();
		
		// entities
		EntityRegistry.registerModEntity(EntityBoneSpear.class, "bonespear", 35, mod, 40, 1, true);
		EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosivearrow", 36, mod, 40, 1, true);

		EntityRegistry.registerGlobalEntityID(EntitySavannahTNTPrimed.class, "savannahtntprimed", EntityRegistry.findGlobalUniqueEntityId());

		EntityRegistry.registerModEntity(EntityVampire.class, "vampire", 1, mod, 80, 3, true);

		EntityRegistry.registerModEntity(EntityDwarf.class, "dwarf", 3, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityWerewolf.class, "werewolf", 4, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityPigman.class, "pigman", 5, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityGoblin.class, "goblin", 6, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityGiant.class, "giant", 7, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityUruk.class, "orc", 8, mod, 80, 3, true);
		EntityRegistry.registerModEntity(EntityRedCreeper.class, "redcreeper", 9, mod, 80, 3, true);

		//EntityRegistry.registerModEntity(EntityGreenSnake.class, "snake", 10, mod, 80, 3, true);

		// spawns
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
		{
			if (BiomeGenBase.getBiomeGenArray()[i] != null)
			{
				if (Config.spawnVampire)
					EntityRegistry.addSpawn(EntityVampire.class, 10, 1, 3, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (Config.spawnWerewolf)
					EntityRegistry.addSpawn(EntityWerewolf.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (Config.spawnPigman)
					EntityRegistry.addSpawn(EntityPigman.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray()[i]);
				if (Config.spawnGoblin)
					EntityRegistry.addSpawn(EntityGoblin.class, 10, 7, 15, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (Config.spawnGiant)
					EntityRegistry.addSpawn(EntityGiant.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				if (Config.spawnUruk)
					EntityRegistry.addSpawn(EntityUruk.class, 8, 2, 4, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
			}
		}

		if (Config.spawnPigman)
			EntityRegistry.removeSpawn(EntityPigman.class, EnumCreatureType.creature, ModGeneration.savannah);
		if (Config.spawnRedCreeper)
			EntityRegistry.addSpawn(EntityRedCreeper.class, 4, 1, 2, EnumCreatureType.monster, ModGeneration.savannah);

		// Entity Eggs
		registerEntityEgg(EntityVampire.class, 0x979797, 0x000000);

		registerEntityEgg(EntityDwarf.class, 0xd8bb9d, 0xa63c1a);
		registerEntityEgg(EntityWerewolf.class, 0xbbc2c2, 0x585957);
		registerEntityEgg(EntityPigman.class, 0xb09190, 0x7d4443);
		registerEntityEgg(EntityGoblin.class, 0x518b3b, 0x4a5618);
		registerEntityEgg(EntityGiant.class, 0x938d63, 0x6a5535);
		registerEntityEgg(EntityUruk.class, 0xa7a377, 0x5d4c35);
		registerEntityEgg(EntityRedCreeper.class, 0xF21111, 0x000000);
	}
	
	static int startEntityId = 300;

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