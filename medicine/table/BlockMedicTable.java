package medicine.table;

import medicine.Medicine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMedicTable extends Block
{
	public BlockMedicTable(int par1, Material par2Material)
	{
		super(par1, par2Material);
		setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
		iconArray = new Icon[2];
		for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(Medicine.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
        }
    }
    
    public Icon getIcon(int par1, int par2)
    {
    	if(par1 == 1)
    		return iconArray[0];
    	else
    		return iconArray[1];
    }
    
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
    	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (!world.isRemote && !player.isSneaking())
		{
			//TODO open Medic Table GUI
		}
		return true;
	}
    
    @Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
    
    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
		return new TileEntityMedicTable();
	}
}