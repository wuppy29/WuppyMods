package com.wuppy.goblinsgiants;

import com.wuppy.goblinsgiants.entity.EntityBoneSpear;
import com.wuppy.goblinsgiants.entity.EntityDwarf;
import com.wuppy.goblinsgiants.entity.EntityExplosiveArrow;
import com.wuppy.goblinsgiants.entity.EntityGiant;
import com.wuppy.goblinsgiants.entity.EntityGoblin;
import com.wuppy.goblinsgiants.entity.EntityPigman;
import com.wuppy.goblinsgiants.entity.EntityRedCreeper;
import com.wuppy.goblinsgiants.entity.EntitySavannahTNTPrimed;
import com.wuppy.goblinsgiants.entity.EntityUruk;
import com.wuppy.goblinsgiants.entity.EntityVampire;
import com.wuppy.goblinsgiants.entity.EntityWerewolf;
import com.wuppy.goblinsgiants.render.ModelDwarf;
import com.wuppy.goblinsgiants.render.ModelGiant;
import com.wuppy.goblinsgiants.render.ModelGoblin;
import com.wuppy.goblinsgiants.render.ModelWerewolf;
import com.wuppy.goblinsgiants.render.RenderBoneSpear;
import com.wuppy.goblinsgiants.render.RenderCustomWood;
import com.wuppy.goblinsgiants.render.RenderExplosiveArrow;
import com.wuppy.goblinsgiants.render.RenderGGMob;
import com.wuppy.goblinsgiants.render.RenderGoblin;
import com.wuppy.goblinsgiants.render.RenderOrc;
import com.wuppy.goblinsgiants.render.RenderRedCreeper;
import com.wuppy.goblinsgiants.render.RenderSavannahTNTPrimed;

import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyGoblin extends CommonProxyGoblin
{
	@Override
    public void registerRenderThings()
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityBoneSpear.class, new RenderBoneSpear());
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, new RenderExplosiveArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntitySavannahTNTPrimed.class, new RenderSavannahTNTPrimed());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVampire.class, new RenderGGMob(new ModelBiped(), 0.5F, "textures/models/vampire.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderGGMob(new ModelDwarf(), 0.5F, "textures/models/Dwarf.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityWerewolf.class, new RenderGGMob(new ModelWerewolf(), 0.5F, "textures/models/WereWolf.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPigman.class, new RenderGGMob(new ModelBiped(), 0.5F, "textures/models/pigman.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderGoblin(new ModelGoblin(), 0.5F, "textures/models/goblin.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiant.class, new RenderGGMob(new ModelGiant(), 0.5F, "textures/models/giant.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityUruk.class, new RenderOrc(new ModelBiped(), 0.5F, "textures/models/orc.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedCreeper.class, new RenderRedCreeper());
		
		RenderingRegistry.registerBlockHandler(new RenderCustomWood());
    }
}