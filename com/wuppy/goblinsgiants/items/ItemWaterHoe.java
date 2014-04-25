package com.wuppy.goblinsgiants.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import com.wuppy.goblinsgiants.GoblinGiant;
import com.wuppy.goblinsgiants.tabs.ModTabs;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWaterHoe extends ItemHoe
{
    public ItemWaterHoe(ToolMaterial enumToolMaterial)
    {
        super(enumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(enumToolMaterial.getMaxUses());
        this.setCreativeTab(ModTabs.ggMiscTab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }
            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            Block var11 = par3World.getBlock(par4, par5, par6);
            Block var12 = par3World.getBlock(par4, par5 + 1, par6);

            if ((par7 == 0 || var12 != Blocks.air || var11 != Blocks.grass) && var11 != Blocks.dirt)
            {
                return false;
            }
            else
            {
                Block var13 = Blocks.farmland;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getStepResourcePath(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);
                par3World.spawnParticle("splash", par4, par5 + 1.5F, par6, 0F, 0.3F, 0F);
                par3World.playSoundEffect((float)par4, (float)par5, (float)par6, "random.splash", 1.0F, 1.0F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, var13);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }
}
