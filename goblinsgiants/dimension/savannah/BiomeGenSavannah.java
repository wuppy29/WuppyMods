package goblinsgiants.dimension.savannah;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSavannah extends BiomeGenBase
{
    public BiomeGenSavannah(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.topBlock = (byte)Block.sand.blockID;
        this.fillerBlock = (byte)Block.sand.blockID;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.theBiomeDecorator.cactiPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 3;
    }
}
