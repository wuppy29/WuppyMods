package harderpeaceful;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;

@MCVersion(value = "1.6.2")
public class HarderPeaceful implements IFMLLoadingPlugin
{
	public static File location;
	
	public String[] getASMTransformerClass() 
	{
		return new String[]{HPClassTransformer.class.getName()};
	}
	
	public String getModContainerClass() 
	{
		return HPDummy.class.getName();
	}
	
	public String getSetupClass() 
	{
		return null;
	}
	
	public void injectData(Map<String, Object> data) 
	{
		location = (File) data.get("coremodLocation");
	}
	
	public String[] getLibraryRequestClass() 
	{
		return null;
	}
	
	//http://www.minecraftforum.net/topic/1854988-tutorial-162-changing-vanilla-without-editing-base-classes-coremods-and-events-very-advanced/
}