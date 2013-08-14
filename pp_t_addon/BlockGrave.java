package pp_t_addon;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import thaumcraft.common.Config;
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
	
	Icon boneIcon;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(PeacefulPackThaumcraftAddon.modid + ":" + (this.getUnlocalizedName().substring(5)));
        this.boneIcon = par1IconRegister.registerIcon(PeacefulPackThaumcraftAddon.modid + ":" + (this.getUnlocalizedName().substring(5)) + "1");
    }
	
	public Icon getIcon(int side, int meta)
	{
		if(side == 1 && meta == 0)
			return blockIcon;
		if(side == 1 && meta == 1)
			return boneIcon;
		else
			return Block.stone.getIcon(0, 0);
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(par1 == 0)
			return Config.itemResource.itemID;
		else
			return Item.bone.itemID;
	}
	
	public int damageDropped(int par1)
	{
		if(par1 == 0)
			return 5;
		else
			return 0;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 2; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}