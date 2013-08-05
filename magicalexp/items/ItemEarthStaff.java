package magicalexp.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magicalexp.MagicalExperience;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemEarthStaff extends ItemME
{
    private float weaponDamage;
    private final EnumToolMaterial toolMaterial;

    public ItemEarthStaff(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.weaponDamage = par2EnumToolMaterial.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
    
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block.blockID == Block.web.blockID ? 15.0F : 1.5F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, int par3, int par4, int par5, EntityLiving par6EntityLiving)
    {
        par1ItemStack.damageItem(1, par6EntityLiving);
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
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
    	//bonemeal
    	
    	int var8 = par3World.getBlockId(par4, par5, par6);
    	
        if (var8 == Block.grass.blockID)
        {
        	if (!par3World.isRemote)
            {
        		par1ItemStack.damageItem(1, par2EntityPlayer);
                label73:

                for (int var9 = 0; var9 < 128; ++var9)
                {
                    int var10 = par4;
                    int var11 = par5 + 1;
                    int var12 = par6;

                    for (int var13 = 0; var13 < var9 / 16; ++var13)
                    {
                        var10 += itemRand.nextInt(3) - 1;
                        var11 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2;
                        var12 += itemRand.nextInt(3) - 1;

                        if (par3World.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || par3World.isBlockNormalCube(var10, var11, var12))
                        {
                            continue label73;
                        }
                    }

                    if (par3World.getBlockId(var10, var11, var12) == 0)
                    {
                        if (itemRand.nextInt(10) != 0)
                        {
                            par3World.setBlock(var10, var11, var12, Block.tallGrass.blockID, 1, 2);
                        }
                        else
                        {
                            ForgeHooks.plantGrass(par3World, var10, var11, var12);
                        }
                    }
                }
            }
        }
        
        else if (var8 == Block.sapling.blockID)
        {
        	if (!par3World.isRemote)
            {
                ((BlockSapling)Block.sapling).growTree(par3World, par4, par5, par6, par3World.rand);
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        
        else if(var8 == Block.mushroomBrown.blockID || var8 == Block.mushroomRed.blockID)
        {
        	if (!par3World.isRemote && ((BlockMushroom)Block.blocksList[var8]).fertilizeMushroom(par3World, par4, par5, par6, par3World.rand))
            {
        		par1ItemStack.damageItem(1, par2EntityPlayer);
            }

            return true;
        }
        
        else if(var8 == Block.melonStem.blockID || var8 == Block.pumpkinStem.blockID)
        {
            if (!par3World.isRemote)
            {
                ((BlockStem)Block.blocksList[var8]).fertilizeStem(par3World, par4, par5, par6);
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }

            return true;
        }
        
        else if (var8 == Block.crops.blockID)
        {
            if (!par3World.isRemote)
            {
                ((BlockCrops)Block.crops).fertilize(par3World, par4, par5, par6);
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        
        //dirt box
        else
        {
    		for(int dirt = 0; dirt <= 2; dirt++)
    		{
    			par3World.setBlock(par4, par5 + dirt, par6, Block.dirt.blockID);
    			par3World.setBlock(par4 + 1, par5 + dirt, par6, Block.dirt.blockID);
    			par3World.setBlock(par4 - 1, par5 + dirt, par6, Block.dirt.blockID);
    			par3World.setBlock(par4, par5 + dirt, par6 + 1, Block.dirt.blockID);
    			par3World.setBlock(par4, par5 + dirt, par6 - 1, Block.dirt.blockID);
    			par3World.setBlock(par4 + 1, par5 + dirt, par6 + 1, Block.dirt.blockID);
    			par3World.setBlock(par4 - 1, par5 + dirt, par6 + 1, Block.dirt.blockID);
    			par3World.setBlock(par4 + 1, par5 + dirt, par6 - 1, Block.dirt.blockID);
    			par3World.setBlock(par4 - 1, par5 + dirt, par6 - 1, Block.dirt.blockID);
    		}
    		par1ItemStack.damageItem(3, par2EntityPlayer);
        }
        return true;
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
}
