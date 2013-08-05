package goblinsgiants.items;

import goblinsgiants.GoblinGiant;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPortalPlacer extends Item
{
	public ItemPortalPlacer(int par1)
	{
		super(par1);
		maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(GoblinGiant.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(!par2World.isRemote)
		{
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 3, (int) par3EntityPlayer.posY + 4, (int) par3EntityPlayer.posZ, Block.sandStone.blockID);

			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 1, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 1, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 2, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal.blockID);
			par2World.setBlock((int) par3EntityPlayer.posX + 2, (int) par3EntityPlayer.posY + 3, (int) par3EntityPlayer.posZ, GoblinGiant.goblinportal.blockID);

			par1ItemStack.stackSize--;
		}

		return par1ItemStack;
    }
}
