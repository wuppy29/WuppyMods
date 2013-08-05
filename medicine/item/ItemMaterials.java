package medicine.item;

import java.util.List;

import medicine.Medicine;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMaterials extends Item
{
	public static final String[] names = new String[] {"emptynormalsyringe", "emptymediumsyringe", "emptyultrasyringe",
		"blueapple", "medicalgoldenapple", "diamond apple", "normaladrenalinedust", "mediumadrenalinedust", "ultraadrenalinedust", 
		"secondsyringenormal", "secondsyringehigh"};
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemMaterials(int id)
    {
    	super(id);
        this.setHasSubtypes(true);
        maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
	
	public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[var2];
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		icons = new Icon[names.length];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(Medicine.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
    }
	
	public Icon getIconFromDamage(int par1)
    {
    	return icons[par1];
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	for (int x = 0; x < 11; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }
}
