package com.wuppy.nethereye;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import java.util.List;
import java.util.Random;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.NETHER_BRIDGE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.NETHER_CAVE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.QUARTZ;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;

public class ChunkProviderCustomHell implements IChunkProvider {
	/**
	 * Is the world that the nether is getting generated.
	 */
	private final World worldObj;
	private final boolean field_177466_i;
	private final Random hellRNG;
	/**
	 * Holds the noise used to determine whether slowsand can be generated at a location
	 */
	private double[] slowsandNoise = new double[256];
	private double[] gravelNoise = new double[256];
	/**
	 * Holds the noise used to determine whether something other than netherrack can be generated at a location
	 */
	private double[] netherrackExclusivityNoise = new double[256];
	private double[] noiseField;
	/**
	 * A NoiseGeneratorOctaves used in generating nether terrain
	 */
	private final NoiseGeneratorOctaves netherNoiseGen1;
	private final NoiseGeneratorOctaves netherNoiseGen2;
	private final NoiseGeneratorOctaves netherNoiseGen3;
	/**
	 * Determines whether slowsand or gravel can be generated at a location
	 */
	private final NoiseGeneratorOctaves slowsandGravelNoiseGen;
	/**
	 * Determines whether something other than nettherack can be generated at a location
	 */
	private final NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
	public final NoiseGeneratorOctaves netherNoiseGen6;
	public final NoiseGeneratorOctaves netherNoiseGen7;
	private final WorldGenFire field_177470_t = new WorldGenFire();
	private final WorldGenGlowStone1 field_177469_u = new WorldGenGlowStone1();
	private final WorldGenGlowStone2 field_177468_v = new WorldGenGlowStone2();
	private final WorldGenerator field_177467_w;
	private final WorldGenHellLava field_177473_x;
	private final WorldGenHellLava field_177472_y;
	private final GeneratorBushFeature field_177471_z;
	private final GeneratorBushFeature field_177465_A;
	private final MapGenNetherBridge genNetherBridge;
	private final MapGenBase netherCaveGenerator;
	double[] noiseData1;
	double[] noiseData2;
	double[] noiseData3;
	double[] noiseData4;
	double[] noiseData5;
	private static final String __OBFID = "CL_00000392";

	public ChunkProviderCustomHell(World worldIn, boolean p_i45637_2_, long p_i45637_3_) {
		this.field_177467_w = new WorldGenMinable(Blocks.quartz_ore.getDefaultState(), 14, BlockHelper.forBlock(Blocks.netherrack));
		this.field_177473_x = new WorldGenHellLava(Blocks.flowing_lava, true);
		this.field_177472_y = new WorldGenHellLava(Blocks.flowing_lava, false);
		this.field_177471_z = new GeneratorBushFeature(Blocks.brown_mushroom);
		this.field_177465_A = new GeneratorBushFeature(Blocks.red_mushroom);
		this.genNetherBridge = (MapGenNetherBridge) TerrainGen.getModdedMapGen(new MapGenNetherBridge(), NETHER_BRIDGE);
		this.netherCaveGenerator = TerrainGen.getModdedMapGen(new MapGenCavesHell(), NETHER_CAVE);
		this.worldObj = worldIn;
		this.field_177466_i = p_i45637_2_;
		this.hellRNG = new Random(p_i45637_3_);

		NoiseGenerator[] noiseGens =
				{
						new NoiseGeneratorOctaves(this.hellRNG, 16),
						new NoiseGeneratorOctaves(this.hellRNG, 16),
						new NoiseGeneratorOctaves(this.hellRNG, 8),
						new NoiseGeneratorOctaves(this.hellRNG, 4),
						new NoiseGeneratorOctaves(this.hellRNG, 4),
						new NoiseGeneratorOctaves(this.hellRNG, 10),
						new NoiseGeneratorOctaves(this.hellRNG, 16)
				};
		noiseGens = TerrainGen.getModdedNoiseGenerators(worldIn, this.hellRNG, noiseGens);
		this.netherNoiseGen1 = (NoiseGeneratorOctaves) noiseGens[0];
		this.netherNoiseGen2 = (NoiseGeneratorOctaves) noiseGens[1];
		this.netherNoiseGen3 = (NoiseGeneratorOctaves) noiseGens[2];
		this.slowsandGravelNoiseGen = (NoiseGeneratorOctaves) noiseGens[3];
		this.netherrackExculsivityNoiseGen = (NoiseGeneratorOctaves) noiseGens[4];
		this.netherNoiseGen6 = (NoiseGeneratorOctaves) noiseGens[5];
		this.netherNoiseGen7 = (NoiseGeneratorOctaves) noiseGens[6];
	}

	public void func_180515_a(int p_180515_1_, int p_180515_2_, ChunkPrimer p_180515_3_) {
		byte b0 = 4;
		byte b1 = 32;
		int k = b0 + 1;
		byte b2 = 17;
		int l = b0 + 1;
		this.noiseField = this.initializeNoiseField(this.noiseField, p_180515_1_ * b0, 0, p_180515_2_ * b0, k, b2, l);

		for (int i1 = 0; i1 < b0; ++i1) {
			for (int j1 = 0; j1 < b0; ++j1) {
				for (int k1 = 0; k1 < 16; ++k1) {
					double d0 = 0.125D;
					double d1 = this.noiseField[(((i1) * l + j1) * b2 + k1)];
					double d2 = this.noiseField[(((i1) * l + j1 + 1) * b2 + k1)];
					double d3 = this.noiseField[(((i1 + 1) * l + j1) * b2 + k1)];
					double d4 = this.noiseField[(((i1 + 1) * l + j1 + 1) * b2 + k1)];
					double d5 = (this.noiseField[((i1) * l + j1) * b2 + k1 + 1] - d1) * d0;
					double d6 = (this.noiseField[((i1) * l + j1 + 1) * b2 + k1 + 1] - d2) * d0;
					double d7 = (this.noiseField[((i1 + 1) * l + j1) * b2 + k1 + 1] - d3) * d0;
					double d8 = (this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 1] - d4) * d0;

					for (int l1 = 0; l1 < 8; ++l1) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i2 = 0; i2 < 4; ++i2) {
							double d14 = 0.25D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;

							for (int j2 = 0; j2 < 4; ++j2) {
								IBlockState iblockstate = null;

								if (k1 * 8 + l1 < b1) {
									iblockstate = Blocks.lava.getDefaultState();
								}

								if (d15 > 0.0D) {
									iblockstate = Blocks.netherrack.getDefaultState();
								}

								int k2 = i2 + i1 * 4;
								int l2 = l1 + k1 * 8;
								int i3 = j2 + j1 * 4;
								p_180515_3_.setBlockState(k2, l2, i3, iblockstate);
								d15 += d16;
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public void func_180516_b(int p_180516_1_, int p_180516_2_, ChunkPrimer p_180516_3_) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_180516_1_, p_180516_2_, p_180516_3_, this.worldObj);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return;

		byte b0 = 64;
		double d0 = 0.03125D;
		this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, p_180516_1_ * 16, p_180516_2_ * 16, 0, 16, 16, 1, d0, d0, 1.0D);
		this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, p_180516_1_ * 16, 109, p_180516_2_ * 16, 16, 1, 16, d0, 1.0D, d0);
		this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.netherrackExclusivityNoise, p_180516_1_ * 16, p_180516_2_ * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);

		for (int k = 0; k < 16; ++k) {
			for (int l = 0; l < 16; ++l) {
				boolean flag = this.slowsandNoise[k + l * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D;
				boolean flag1 = this.gravelNoise[k + l * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D;
				int i1 = (int) (this.netherrackExclusivityNoise[k + l * 16] / 3.0D + 3.0D + this.hellRNG.nextDouble() * 0.25D);
				int j1 = -1;
				IBlockState iblockstate = Blocks.netherrack.getDefaultState();
				IBlockState iblockstate1 = Blocks.netherrack.getDefaultState();

				for (int k1 = 127; k1 >= 0; --k1) {
					if (k1 < 127 - this.hellRNG.nextInt(5) && k1 > this.hellRNG.nextInt(5)) {
						IBlockState iblockstate2 = p_180516_3_.getBlockState(l, k1, k);

						if (iblockstate2.getBlock() != null && iblockstate2.getBlock().getMaterial() != Material.air) {
							if (iblockstate2.getBlock() == Blocks.netherrack) {
								if (j1 == -1) {
									if (i1 <= 0) {
										iblockstate = null;
										iblockstate1 = Blocks.netherrack.getDefaultState();
									} else if (k1 >= b0 - 4 && k1 <= b0 + 1) {
										iblockstate = Blocks.netherrack.getDefaultState();
										iblockstate1 = Blocks.netherrack.getDefaultState();

										if (flag1) {
											iblockstate = Blocks.gravel.getDefaultState();
											iblockstate1 = Blocks.netherrack.getDefaultState();
										}

										if (flag) {
											iblockstate = Blocks.soul_sand.getDefaultState();
											iblockstate1 = Blocks.soul_sand.getDefaultState();
										}
									}

									if (k1 < b0 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air)) {
										iblockstate = Blocks.lava.getDefaultState();
									}

									j1 = i1;

									if (k1 >= b0 - 1) {
										p_180516_3_.setBlockState(l, k1, k, iblockstate);
									} else {
										p_180516_3_.setBlockState(l, k1, k, iblockstate1);
									}
								} else if (j1 > 0) {
									--j1;
									p_180516_3_.setBlockState(l, k1, k, iblockstate1);
								}
							}
						} else {
							j1 = -1;
						}
					} else {
						p_180516_3_.setBlockState(l, k1, k, Blocks.bedrock.getDefaultState());
					}
				}
			}
		}
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
	 * specified chunk from the map seed and chunk seed
	 */
	@Override
	public Chunk provideChunk(int x, int z) {
		this.hellRNG.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.func_180515_a(x, z, chunkprimer);
		this.func_180516_b(x, z, chunkprimer);
		this.netherCaveGenerator.func_175792_a(this, this.worldObj, x, z, chunkprimer);

		if (this.field_177466_i) {
			this.genNetherBridge.func_175792_a(this, this.worldObj, x, z, chunkprimer);
		}

		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, x * 16, z * 16, 16, 16);
		byte[] abyte = chunk.getBiomeArray();

		for (int k = 0; k < abyte.length; ++k) {
			abyte[k] = (byte) abiomegenbase[k].biomeID;
		}

		chunk.resetRelightChecks();
		return chunk;
	}

	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the [empty] noise array, the position, and the
	 * size.
	 */
	private double[] initializeNoiseField(double[] p_73164_1_, int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, p_73164_1_, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;

		if (p_73164_1_ == null) {
			p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
		}

		double d0 = 684.412D;
		double d1 = 2053.236D;
		this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
		this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100.0D, 0.0D, 100.0D);
		this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0 / 80.0D, d1 / 60.0D, d0 / 80.0D);
		this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
		this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
		int k1 = 0;
		double[] adouble1 = new double[p_73164_6_];
		int l1;

		for (l1 = 0; l1 < p_73164_6_; ++l1) {
			adouble1[l1] = Math.cos((double) l1 * Math.PI * 6.0D / (double) p_73164_6_) * 2.0D;
			double d2 = (double) l1;

			if (l1 > p_73164_6_ / 2) {
				d2 = (double) (p_73164_6_ - 1 - l1);
			}

			if (d2 < 4.0D) {
				d2 = 4.0D - d2;
				adouble1[l1] -= d2 * d2 * d2 * 10.0D;
			}
		}

		for (l1 = 0; l1 < p_73164_5_; ++l1) {
			for (int j2 = 0; j2 < p_73164_7_; ++j2) {
				double d3 = 0.0D;

				for (int i2 = 0; i2 < p_73164_6_; ++i2) {
					double d4;
					double d5 = adouble1[i2];
					double d6 = this.noiseData2[k1] / 512.0D;
					double d7 = this.noiseData3[k1] / 512.0D;
					double d8 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;

					if (d8 < 0.0D) {
						d4 = d6;
					} else if (d8 > 1.0D) {
						d4 = d7;
					} else {
						d4 = d6 + (d7 - d6) * d8;
					}

					d4 -= d5;
					double d9;

					if (i2 > p_73164_6_ - 4) {
						d9 = (double) ((float) (i2 - (p_73164_6_ - 4)) / 3.0F);
						d4 = d4 * (1.0D - d9) + -10.0D * d9;
					}

					if ((double) i2 < d3) {
						d9 = (d3 - (double) i2) / 4.0D;
						d9 = MathHelper.clamp_double(d9, 0.0D, 1.0D);
						d4 = d4 * (1.0D - d9) + -10.0D * d9;
					}

					p_73164_1_[k1] = d4;
					++k1;
				}
			}
		}

		return p_73164_1_;
	}

	/**
	 * Checks to see if a chunk exists at x, z
	 */
	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
		BlockFalling.fallInstantly = true;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(p_73153_1_, worldObj, hellRNG, p_73153_2_, p_73153_3_, false));

		BlockPos blockpos = new BlockPos(p_73153_2_ * 16, 0, p_73153_3_ * 16);
		ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(p_73153_2_, p_73153_3_);
		this.genNetherBridge.func_175794_a(this.worldObj, this.hellRNG, chunkcoordintpair);
		int k;

		boolean doGen = TerrainGen.populate(p_73153_1_, worldObj, hellRNG, p_73153_2_, p_73153_3_, false, NETHER_LAVA);
		for (k = 0; doGen && k < 8; ++k) {
			this.field_177472_y.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
		}

		doGen = TerrainGen.populate(p_73153_1_, worldObj, hellRNG, p_73153_2_, p_73153_3_, false, FIRE);
		for (k = 0; doGen && k < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1) + 1; ++k) {
			this.field_177470_t.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
		}

		doGen = TerrainGen.populate(p_73153_1_, worldObj, hellRNG, p_73153_2_, p_73153_3_, false, GLOWSTONE);
		for (k = 0; doGen && k < this.hellRNG.nextInt(this.hellRNG.nextInt(10) + 1); ++k) {
			this.field_177469_u.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(120) + 4, this.hellRNG.nextInt(16) + 8));
		}

		for (k = 0; doGen && k < 10; ++k) {
			this.field_177468_v.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldObj, hellRNG, blockpos));

		doGen = TerrainGen.decorate(worldObj, hellRNG, blockpos, SHROOM);
		if (doGen && this.hellRNG.nextBoolean()) {
			this.field_177471_z.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
		}

		if (doGen && this.hellRNG.nextBoolean()) {
			this.field_177465_A.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16) + 8, this.hellRNG.nextInt(128), this.hellRNG.nextInt(16) + 8));
		}

		doGen = TerrainGen.generateOre(worldObj, hellRNG, field_177467_w, blockpos, QUARTZ);
		for (k = 0; doGen && k < 16; ++k) {
			this.field_177467_w.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
		}

		doGen = TerrainGen.populate(p_73153_1_, worldObj, hellRNG, p_73153_2_, p_73153_3_, false, NETHER_LAVA2);
		for (k = 0; doGen && k < 16; ++k) {
			this.field_177473_x.generate(this.worldObj, this.hellRNG, blockpos.add(this.hellRNG.nextInt(16), this.hellRNG.nextInt(108) + 10, this.hellRNG.nextInt(16)));
		}

		BlockFalling.fallInstantly = false;
	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		return false;
	}

	/**
	 * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
	 * Return true if all chunks have been saved.
	 */
	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		return true;
	}

	/**
	 * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
	 * unimplemented.
	 */
	@Override
	public void saveExtraData() {
	}

	/**
	 * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
	 */
	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	/**
	 * Returns if the IChunkProvider supports saving.
	 */
	@Override
	public boolean canSave() {
		return true;
	}

	/**
	 * Converts the instance data to a readable string.
	 */
	@Override
	public String makeString() {
		return "HellRandomLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		if (creatureType == EnumCreatureType.MONSTER) {
			if (this.genNetherBridge.func_175795_b(pos)) {
				return this.genNetherBridge.getSpawnList();
			}

			if (this.genNetherBridge.func_175796_a(this.worldObj, pos) && this.worldObj.getBlockState(pos.down()).getBlock() == Blocks.nether_brick) {
				return this.genNetherBridge.getSpawnList();
			}
		}

		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(pos);
		return biomegenbase.getSpawnableList(creatureType);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String p_180513_2_, BlockPos p_180513_3_) {
		return "Fortress".equals(p_180513_2_) && this.genNetherBridge != null ? this.genNetherBridge.getClosestStrongholdPos(worldIn, p_180513_3_) : null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {
		this.genNetherBridge.func_175792_a(this, this.worldObj, p_180514_2_, p_180514_3_, null);
	}

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
	}
}