package com.github.telvarost.terraintweaks.mixin;

import com.github.telvarost.terraintweaks.Config;
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
    public void terrainTweaks_decorateGetBiome(ChunkSource source, int x, int z, CallbackInfo ci) {
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
    private int terrainTweaks_decorateDungeonAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    private int terrainTweaks_decorateDirtAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.PLAINS == biomeToDecorate) {
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
                    intValue = 10,
                    ordinal = 2
            )
    )
    private int terrainTweaks_decorateGravelAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SWAMPLAND == biomeToDecorate) {
                value = (int)(value * 1.5F);
            } else if (Biome.PLAINS == biomeToDecorate) {
                value = (int)(value * 0.75F);
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
    private int terrainTweaks_decorateCoalAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.TAIGA == biomeToDecorate) {
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
    private int terrainTweaks_decorateIronAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    private int terrainTweaks_decorateGoldAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.DESERT == biomeToDecorate) {
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
    private int terrainTweaks_decorateGoldCount(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    private int terrainTweaks_decorateRedstoneAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SAVANNA == biomeToDecorate) {
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
                    intValue = 1,
                    ordinal = 1
            )
    )
    private int terrainTweaks_decorateDiamondAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.TUNDRA == biomeToDecorate) {
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
    private int terrainTweaks_decorateDiamondCount(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    private int terrainTweaks_decorateLapisAttempts(int value) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
            if (Biome.SEASONAL_FOREST == biomeToDecorate) {
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
    private int terrainTweaks_decorateLapisCount(int value) {
        System.out.println("Reducing Lapis");
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    public int terrainTweaks_decoratePumpkinAttempts(Random instance, int bound, Operation<Integer> original) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    public int terrainTweaks_decorateRoseAttempts(Random instance, int bound, Operation<Integer> original) {
        if (Config.config.ENABLE_BIOME_SPECIFIC_GENERATION) {
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
    public void terrainTweaks_decorateCaveSand(ChunkSource source, int x, int z, CallbackInfo ci) {
        if (  Config.config.ENABLE_CAVE_CLAY_GENERATION
           || Config.config.ENABLE_CAVE_ICE_GENERATION
           || Config.config.ENABLE_CAVE_SAND_GENERATION
        ) {
            int var4 = x * 16;
            int var5 = z * 16;
            int var13;
            int var14;
            int var15;
            int var16;

            if (  Config.config.ENABLE_CAVE_ICE_GENERATION
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

            if (  Config.config.ENABLE_CAVE_CLAY_GENERATION
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

            /* TerrainTweaks Ideas */
//    DUNGEON_RAINFOREST      = DONE - Rainforest - Sandy,  150% Dungeon,  75% Pumpkin
//    DIRT_PLAINS             = DONE - Plains     - Sandy,  150% Dirt,     75% Gravel
//    GRAVEL_SWAMPLAND        = DONE - Swamps     - Clayey, 150% Gravel,   50% Gold
//    COAL_TAIGA              = DONE - Taiga      - Icy,    150% Coal,     75% Dirt
//    IRON_FOREST             = DONE - Forest     - Normal, 150% Iron,     50% Lapis
//    GOLD_DESERT             = DONE - Desert     - Sandy,  200% Gold,     50% Rose
//    REDSTONE_SAVANNA        = DONE - Savanna    - Sandy,  150% Redstone, 75% Dungeon
//    DIAMOND_TUNDRA          = DONE - Tundra     - Icy,    200% Diamond,  75% Redstone
//    LAPIS_SEASONAL_FOREST   = DONE - Seasonal   - Normal, 200% Lapis,    75% Iron
//    PUMPKIN_SHRUBLAND       = DONE - Shrubland  - Sandy,  150% Pumpkin,  75% Coal
//    ICE_DESERT              = DONE - Ice Desert - Icy,    200% Rose,     50% Diamond

//    CLAY_NETHER             = DONE - Nether - single clay blocks x5 the rate of solitary lava source blocks
//    SKY                     = DONE - No tweaks

            if (  Config.config.ENABLE_CAVE_SAND_GENERATION
               && (  Biome.RAINFOREST    == biomeToDecorate
                  || Biome.PLAINS        == biomeToDecorate
                  || Biome.DESERT        == biomeToDecorate
                  || Biome.SAVANNA       == biomeToDecorate
                  || Biome.SHRUBLAND     == biomeToDecorate
                  )
            ) {
                for(var13 = 0; var13 < 10; ++var13) {
                    var14 = var4 + this.random.nextInt(16);
                    var15 = this.random.nextInt(8) + this.random.nextInt(40);
                    var16 = var5 + this.random.nextInt(16);
                    (new OreFeature(Block.SAND.id, 24)).generate(this.world, this.random, var14, var15, var16);
                }
            }
        }
    }
}
