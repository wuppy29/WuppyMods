package harderpeaceful;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class HPDummy extends DummyModContainer
{
	public HPDummy() 
	{
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "wuppy29_harderpeaceful";
		meta.name = "Harder Peaceful";
		meta.version = "1.6.0";
		meta.credits = "";
		meta.authorList = Arrays.asList("wuppy29");
		meta.description = "Increases the difficulty of peaceful by removing health and food regeneration.";
		meta.url = "http://www.minecraftforum.net/topic/1094417-";
		meta.updateUrl = "";
		meta.screenshots = new String[0];
		meta.logoFile = "";
	}
	
	@Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
		bus.register(this);
		return true;
    }
}