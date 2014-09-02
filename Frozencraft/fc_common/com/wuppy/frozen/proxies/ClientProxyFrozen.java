package com.wuppy.frozen.proxies;

import net.minecraft.client.model.ModelBiped;

import com.wuppy.frozen.entities.EntityAnna;
import com.wuppy.frozen.entities.EntityDuke;
import com.wuppy.frozen.entities.EntityElsa;
import com.wuppy.frozen.entities.EntityHans;
import com.wuppy.frozen.entities.EntityIceBoltElsa;
import com.wuppy.frozen.entities.EntityIceBoltFailed;
import com.wuppy.frozen.entities.EntityIceBoltPlayer;
import com.wuppy.frozen.entities.EntityKristoff;
import com.wuppy.frozen.entities.EntityMarshmallow;
import com.wuppy.frozen.entities.EntityOlaf;
import com.wuppy.frozen.entities.EntitySven;
import com.wuppy.frozen.entities.EntityThug;
import com.wuppy.frozen.entities.render.RenderBipedFrozenCraft;
import com.wuppy.frozen.entities.render.RenderIceBolt;
import com.wuppy.frozen.entities.render.RenderMarshmallow;
import com.wuppy.frozen.entities.render.RenderOlaf;
import com.wuppy.frozen.entities.render.RenderSven;
import com.wuppy.frozen.entities.render.RenderThug;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyFrozen extends CommonProxyFrozen
{
	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBoltElsa.class, new RenderIceBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBoltFailed.class, new RenderIceBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBoltPlayer.class, new RenderIceBolt());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityElsa.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/elsa.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnna.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/anna.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityKristoff.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/kristoff.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityHans.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/hans.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDuke.class, new RenderBipedFrozenCraft(new ModelBiped(), 0.5F, "textures/models/duke.png"));
		RenderingRegistry.registerEntityRenderingHandler(EntityThug.class, new RenderThug());
		RenderingRegistry.registerEntityRenderingHandler(EntityOlaf.class, new RenderOlaf());
		RenderingRegistry.registerEntityRenderingHandler(EntitySven.class, new RenderSven());
		RenderingRegistry.registerEntityRenderingHandler(EntityMarshmallow.class, new RenderMarshmallow());
	}
}