package nethereye;

import java.lang.reflect.Method;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ItemNetherEye extends Item
{
    public ItemNetherEye(int par1)
    {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(NetherEye.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if (!par2World.isRemote && par3EntityPlayer.dimension == -1)
        {
    		ChunkPosition chunkPos = par2World.findClosestStructure("Fortress", (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
            
            if (chunkPos != null)
            {
                EntityNetherEye var6 = new EntityNetherEye(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY + 1.62D - (double)par3EntityPlayer.yOffset, par3EntityPlayer.posZ);
                var6.moveTowards((double)chunkPos.x, chunkPos.y, (double)chunkPos.z);
                par2World.spawnEntityInWorld(var6);
                par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                par2World.playAuxSFXAtEntity((EntityPlayer)null, 1002, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ, 0);

                if (!par3EntityPlayer.capabilities.isCreativeMode)
                {
                    --par1ItemStack.stackSize;
                }
            }
            else
            {
            	par3EntityPlayer.addChatMessage("There isn't a fortress nearby.");
            }
        }
    	else if(!par2World.isRemote && par3EntityPlayer.dimension != -1)
    	{
    		par3EntityPlayer.addChatMessage("You need to be in the Nether to use this.");
    	}

        return par1ItemStack;
    }
}
