package com.wuppy.frozen.proxies;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.wuppy.frozen.entities.EntityAnna;
import com.wuppy.frozen.entities.EntityDuke;
import com.wuppy.frozen.entities.EntityElsa;
import com.wuppy.frozen.entities.EntityHans;
import com.wuppy.frozen.entities.EntityIceBoltElsa;
import com.wuppy.frozen.entities.EntityIceBoltFailed;
import com.wuppy.frozen.entities.EntityIceBoltPlayer;
import com.wuppy.frozen.entities.EntityKristoff;
import com.wuppy.frozen.entities.EntityThug;
import com.wuppy.frozen.entities.render.RenderBipedFrozenCraft;
import com.wuppy.frozen.entities.render.RenderIceBolt;
import com.wuppy.frozen.entities.render.RenderThug;

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
	}
}