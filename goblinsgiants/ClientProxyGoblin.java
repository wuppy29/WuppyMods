package goblinsgiants;

import goblinsgiants.entity.EntityBoneSpear;
import goblinsgiants.entity.EntityDwarf;
import goblinsgiants.entity.EntityExplosiveArrow;
import goblinsgiants.entity.EntityGiant;
import goblinsgiants.entity.EntityGoblin;
import goblinsgiants.entity.EntityPigman;
import goblinsgiants.entity.EntityRedCreeper;
import goblinsgiants.entity.EntitySavannahTNTPrimed;
import goblinsgiants.entity.EntityUruk;
import goblinsgiants.entity.EntityVampire;
import goblinsgiants.entity.EntityWerewolf;
import goblinsgiants.render.ModelDwarf;
import goblinsgiants.render.ModelGiant;
import goblinsgiants.render.ModelGoblin;
import goblinsgiants.render.ModelWerewolf;
import goblinsgiants.render.RenderBoneSpear;
import goblinsgiants.render.RenderCustomWood;
import goblinsgiants.render.RenderExplosiveArrow;
import goblinsgiants.render.RenderGGMob;
import goblinsgiants.render.RenderOrc;
import goblinsgiants.render.RenderRedCreeper;
import goblinsgiants.render.RenderSavannahTNTPrimed;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderGGMob(new ModelGoblin(), 0.5F, "textures/models/goblin.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiant.class, new RenderGGMob(new ModelGiant(), 0.5F, "textures/models/giant.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityUruk.class, new RenderOrc(new ModelBiped(), 0.5F, "textures/models/orc.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedCreeper.class, new RenderRedCreeper());
		
		RenderingRegistry.registerBlockHandler(new RenderCustomWood());
    }
}