package pp_t_addon;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGrave extends Block
{
	public BlockGrave(int par1, Material par2Material)
	{
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(PeacefulPackThaumcraftAddon.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
	
	public Icon getIcon(int side, int meta)
	{
		if(side == 1)
			return blockIcon;
		else
			return Block.stone.getIcon(0, 0);
	}
	
	//TODO add Thaumcraft drop
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Item.appleGold.itemID;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
}