package magicalexp.items;

import magicalexp.MagicalExperience;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHoeExperion extends ItemME
{
    public ItemHoeExperion(int par1, EnumToolMaterial par2EnumToolMaterialExperion)
    {
        super(par1);
        maxStackSize = 1;
        setMaxDamage(par2EnumToolMaterialExperion.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }

        int i = par3World.getBlockId(par4, par5, par6);
        int j = par3World.getBlockId(par4, par5 + 1, par6);

        if (par7 != 0 && j == 0 && i == Block.grass.blockID || i == Block.dirt.blockID)
        {
            Block block = Block.tilledField;
            par3World.playSoundEffect((float)par4 + 0.5F, (float)par5 + 0.5F, (float)par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            
            if (par3World.isRemote)
            {
                return true;
            }
            else
            {
            	par3World.setBlock(par4, par5, par6, block.blockID, 1, 2);
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}
