package com.github.telvarost.telsterrain.mixin.newgen;

import com.github.telvarost.telsterrain.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.OreFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(OverworldChunkGenerator.class)
public class OverworldChunkGeneratorMixin {

    @Shadow private Random random;

    @Shadow private World world;

    @Unique
    private Biome biomeToDecorate;

    @Inject(
            method = "decorate",
            at = @At("HEAD"),
            cancellable = true
    )
    public void telsTerrain_decorateGetBiome(ChunkSource source, int x, int z, CallbackInfo ci) {
        int var4 = x * 16;
        int var5 = z * 16;
        biomeToDecorate = this.world.method_1781().getBiome(var4 + 16, var5 + 16);
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 8,
                    ordinal = 6
            )
    )
    private int telsTerrain_decorateDungeonAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.RAINFOREST == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.SAVANNA == biomeToDecorate) {
                value = (int)(value * 0.75F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 20,
                    ordinal = 0
            )
    )
    private int telsTerrain_decorateDirtAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.PLAINS == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.TUNDRA == biomeToDecorate) {
                value = (int)(value * 0.75F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 10,
                    ordinal = 2
            )
    )
    private int telsTerrain_decorateGravelAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.TAIGA == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.PLAINS == biomeToDecorate) {
                value = (int)(value * 0.5F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 20,
                    ordinal = 1
            )
    )
    private int telsTerrain_decorateCoalAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SWAMPLAND == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.SHRUBLAND == biomeToDecorate) {
                value = (int)(value * 0.75F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 20,
                    ordinal = 2
            )
    )
    private int telsTerrain_decorateIronAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.FOREST == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.SEASONAL_FOREST == biomeToDecorate) {
                value = (int)(value * 0.75F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 2,
                    ordinal = 0
            )
    )
    private int telsTerrain_decorateGoldAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SEASONAL_FOREST == biomeToDecorate) {
                value = (int)(value * 2);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 8,
                    ordinal = 10
            )
    )
    private int telsTerrain_decorateGoldCount(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SWAMPLAND == biomeToDecorate) {
                value = (int)(value * 0.5F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 8,
                    ordinal = 11
            )
    )
    private int telsTerrain_decorateRedstoneAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.TUNDRA == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.TAIGA == biomeToDecorate) {
                value = (int)(value * 0.75F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 1,
                    ordinal = 1
            )
    )
    private int telsTerrain_decorateDiamondAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SAVANNA == biomeToDecorate) {
                value = (int)(value * 2);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 7,
                    ordinal = 1
            )
    )
    private int telsTerrain_decorateDiamondCount(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.ICE_DESERT == biomeToDecorate) {
                value = (int)(value * 0.5F);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 1,
                    ordinal = 2
            )
    )
    private int telsTerrain_decorateLapisAttempts(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.DESERT == biomeToDecorate) {
                value = (int)(value * 2);
            }
        }

        return value;
    }

    @ModifyConstant(
            method = "decorate",
            constant = @Constant(
                    intValue = 6,
                    ordinal = 0
            )
    )
    private int telsTerrain_decorateLapisCount(int value) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.FOREST == biomeToDecorate) {
                value = (int)(value * 0.5F);
            }
        }

        return value;
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextInt(I)I",
                    ordinal = 69
            )
    )
    public int telsTerrain_decoratePumpkinAttempts(Random instance, int bound, Operation<Integer> original) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SHRUBLAND == biomeToDecorate) {
                return original.call(instance, (int)(bound * 0.5F));
            } else if (Biome.RAINFOREST == biomeToDecorate) {
                return original.call(instance, (int)(bound * 1.5F));
            }
        }

        return original.call(instance, bound);
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextInt(I)I",
                    ordinal = 54
            )
    )
    public int telsTerrain_decorateRoseAttempts(Random instance, int bound, Operation<Integer> original) {
        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.ICE_DESERT == biomeToDecorate) {
                return original.call(instance, (int)(bound * 0.5F));
            } else if (Biome.DESERT == biomeToDecorate) {
                return original.call(instance, (int)(bound * 2.0F));
            }
        }

        return original.call(instance, bound);
    }

    @Inject(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;method_1781()Lnet/minecraft/world/biome/source/BiomeSource;",
                    ordinal = 1
            ),
            cancellable = true
    )
    public void telsTerrain_decorateUnderground(ChunkSource source, int x, int z, CallbackInfo ci) {
        if (  Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_CLAY_GENERATION
           || Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_ICE_GENERATION
           || Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_SAND_GENERATION
        ) {
            int var4 = x * 16;
            int var5 = z * 16;
            int var13;
            int var14;
            int var15;
            int var16;

            if (  Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_ICE_GENERATION
               && (  Biome.TAIGA      == biomeToDecorate
                  || Biome.TUNDRA     == biomeToDecorate
                  || Biome.ICE_DESERT == biomeToDecorate
                  )
            ) {
                for(var13 = 0; var13 < 10; ++var13) {
                    var14 = var4 + this.random.nextInt(16);
                    var15 = this.random.nextInt(8) + this.random.nextInt(40);
                    var16 = var5 + this.random.nextInt(16);
                    (new OreFeature(Block.ICE.id, 24)).generate(this.world, this.random, var14, var15, var16);
                }
            }

            if (  Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_CLAY_GENERATION
               && (  Biome.SWAMPLAND     == biomeToDecorate
                  )
            ) {
                for(var13 = 0; var13 < 5; ++var13) {
                    var14 = var4 + this.random.nextInt(16);
                    var15 = this.random.nextInt(8) + this.random.nextInt(40);
                    var16 = var5 + this.random.nextInt(16);
                    (new OreFeature(Block.CLAY.id, 12)).generate(this.world, this.random, var14, var15, var16);
                }
            }

            if (  Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_SAND_GENERATION
               && (  Biome.RAINFOREST    == biomeToDecorate
                  || Biome.DESERT        == biomeToDecorate
                  || Biome.SAVANNA       == biomeToDecorate
                  )
            ) {
                for(var13 = 0; var13 < 10; ++var13) {
                    var14 = var4 + this.random.nextInt(16);
                    var15 = this.random.nextInt(8) + this.random.nextInt(40);
                    var16 = var5 + this.random.nextInt(16);
                    (new OreFeature(Block.SAND.id, 24)).generate(this.world, this.random, var14, var15, var16);
                }
            }

            if (  Config.config.NEW_TERRAIN_GENERATION.ENABLE_CAVE_SANDSTONE_GENERATION
               && (  Biome.PLAINS        == biomeToDecorate
                  || Biome.SHRUBLAND     == biomeToDecorate
                  )
            ) {
                for(var13 = 0; var13 < 10; ++var13) {
                    var14 = var4 + this.random.nextInt(16);
                    var15 = this.random.nextInt(8) + this.random.nextInt(40);
                    var16 = var5 + this.random.nextInt(16);
                    (new OreFeature(Block.SANDSTONE.id, 24)).generate(this.world, this.random, var14, var15, var16);
                }
            }
        }

        if (Config.config.NEW_TERRAIN_GENERATION.ENABLE_DESERT_STONE_AND_GRAVEL_SWAP) {
            int xLocation = x * 16;
            int zLocation = z * 16;

            for (int xOffset = 0; xOffset < 16; xOffset++) {
                for (int zOffset = 0; zOffset < 16; zOffset++) {
                    int xExact = xLocation + xOffset + 16;
                    int zExact = zLocation + zOffset + 16;

                    Biome biome = this.world.method_1781().getBiome(xExact, zExact);
                    if (Biome.DESERT == biome) {
                        for (int yLevel = 0; yLevel < this.world.getHeight(); yLevel++) {
                            int blockId = this.world.getBlockId(xExact, yLevel, zExact);

                            if (0 == blockId) {
                                /* Do nothing */
                            } else if (Block.STONE.id == blockId) {
                                this.world.setBlockWithoutNotifyingNeighbors(xExact, yLevel, zExact, Block.SANDSTONE.id);
                            } else if (Block.GRAVEL.id == blockId) {
                                this.world.setBlockWithoutNotifyingNeighbors(xExact, yLevel, zExact, Block.SAND.id);
                            }
                        }
                    }
                }
            }
        }
    }
}
