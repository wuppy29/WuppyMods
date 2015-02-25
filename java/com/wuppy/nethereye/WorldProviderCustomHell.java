package com.wuppy.nethereye;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderCustomHell extends WorldProviderHell {
	/**
	 * Returns a new chunk provider which generates chunks for this world
	 */
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderCustomHell(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
	}
}
