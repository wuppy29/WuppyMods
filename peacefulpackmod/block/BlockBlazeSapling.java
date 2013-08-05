package peacefulpackmod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import peacefulpackmod.PeacefulPack;
import peacefulpackmod.worldgen.WorldGenBlazeTrees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockBlazeSapling extends BlockFlower
{
    public BlockBlazeSapling(int id)
    {
        super(id);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setTickRandomly(true);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(PeacefulPack.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
    
    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.netherrack.blockID;
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	System.out.println("running");
    	if(par1World.getBlockId(par2, par3 - 1, par4) == Block.netherrack.blockID)
    		return true;
    	else
    		return false;
    }
    
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        super.updateTick(world, i, j, k, random);
        
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int l = world.getBlockMetadata(i, j, k);
            if((l & 8) == 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, l | 8, 2);
            } else
            {
                growTree(world, i, j, k, random);
            }
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k);
        world.setBlockToAir(i, j, k);
        Object obj = null;
        obj = new WorldGenBlazeTrees();
        
        if(!((WorldGenerator) (obj)).generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, blockID, l, 2);
        }
    }
}
