package goblinsgiants.items;


import goblinsgiants.GoblinGiant;

import java.util.List;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGoldPoisonSword extends Item
{
    private float weaponDamage;
    private final EnumToolMaterial toolMaterial;

    @SideOnly(Side.CLIENT)
	private Icon[] icons;
    
    public ItemGoldPoisonSword(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block.blockID == Block.web.blockID ? 15.0F : 1.5F;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		icons = new Icon[6];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)) + " " + (i + 1));
		}
    }
    
    public Icon getIconFromDamage(int par1)
    {
        if (par1 >= 50)
        {
        	return icons[0];
        }
        if (par1 >= 40)
        {
        	return icons[1];
        }
        if (par1 >= 30)
        {
        	return icons[2];
        }
        if (par1 >= 20)
        {
        	return icons[3];
        }
        if (par1 >= 10)
        {
        	return icons[4];
        }
        if (par1 >= 0)
        {
        	return icons[5];
        }
        else
        	return icons[0];
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
    	int howManyTicks = 10;

    	if(par2EntityLiving.isEntityUndead())
    	{
    		par2EntityLiving.addPotionEffect(new PotionEffect(Potion.heal.getId(),30*howManyTicks,0));
    	}
    	else if(!par2EntityLiving.isEntityUndead())
    	{
    		par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),30*howManyTicks,0));
    	}
        par1ItemStack.damageItem(1, par3EntityLiving);

        if(par1ItemStack.getItemDamage() > 59)
        {
        	par3EntityLiving.dropItem(Item.swordGold.itemID, 1);
        	par1ItemStack.damageItem(1, par3EntityLiving);
        }
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, int par3, int par4, int par5, EntityLiving par6EntityLiving)
    {
        par1ItemStack.damageItem(2, par6EntityLiving);
        return true;
    }

    /**
     * Returns the damage against a given entity.
     */
    public float getDamageVsEntity(Entity par1Entity)
    {
        return this.weaponDamage;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 6; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4 * 10));
        }
    }
}
