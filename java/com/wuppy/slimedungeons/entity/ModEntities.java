package com.wuppy.slimedungeons.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.wuppy.slimedungeons.SlimeDungeon;

public class ModEntities
{
	private static int startEntityId = 30;
	
	public static void init(SlimeDungeon mod)
	{
		EntityRegistry.registerModEntity(EntitySlimeZombie.class, "SlimeZombie", 0, mod, 80, 3, true);
		registerEntityEgg(EntitySlimeZombie.class, 0x009696, 0x478c36);
	}
	
	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.idToClassMapping.put(id, entity);
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