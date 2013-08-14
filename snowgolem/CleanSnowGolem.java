package snowgolem;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = CleanSnowGolem.modid, name = "Clean Snow Golem", version = "1.5.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CleanSnowGolem 
{
	public static final String modid = "wuppy29_snowgolem";
	
	@SidedProxy(clientSide = "snowgolem.ClientProxySG", serverSide = "snowgolem.CommonProxySG")
	public static CommonProxySG proxy;
	
	public static int customPumpkinID = Block.pumpkin.blockID;
	public static Block customPumpkin;
	
	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		Block.blocksList[customPumpkinID] = null;
		
		customPumpkin = (new BlockCustomPumpkin(customPumpkinID, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("pumpkin").func_111022_d("pumpkin");
		
		EntityRegistry.registerModEntity(EntityCleanSnowGolem.class, "snow golem", 1, this, 80, 3, true);
	}
}
