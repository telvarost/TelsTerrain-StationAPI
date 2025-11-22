package com.github.telvarost.telsterrain.mixin.oldgen;

import com.github.telvarost.telsterrain.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(OverworldChunkGenerator.class)
public class OverworldChunkGeneratorMixin {

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/LakeFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateWaterLakes(LakeFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_FLUID_FEATURES.DISABLE_OVERWORLD_WATER_PONDS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/LakeFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 1
            )
    )
    public boolean telsTerrain_decorateLavaLakes(LakeFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_FLUID_FEATURES.DISABLE_OVERWORLD_LAVA_PONDS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/DungeonFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateDungeons(DungeonFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_CAVE_AND_SOIL_FEATURES.DISABLE_OVERWORLD_DUNGEONS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/ClayOreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateClayOreFeature(ClayOreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_CAVE_AND_SOIL_FEATURES.DISABLE_OVERWORLD_CLAY_DEPOSITS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateOreFeatureDirt(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_CAVE_AND_SOIL_FEATURES.DISABLE_OVERWORLD_DIRT_DEPOSITS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 1
            )
    )
    public boolean telsTerrain_decorateOreFeatureGravel(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_CAVE_AND_SOIL_FEATURES.DISABLE_OVERWORLD_GRAVEL_DEPOSITS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 2
            )
    )
    public boolean telsTerrain_decorateOreFeatureCoal(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_ORES.DISABLE_OVERWORLD_COAL_ORE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 3
            )
    )
    public boolean telsTerrain_decorateOreFeatureIron(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_ORES.DISABLE_OVERWORLD_IRON_ORE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 4
            )
    )
    public boolean telsTerrain_decorateOreFeatureGold(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_ORES.DISABLE_OVERWORLD_GOLD_ORE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 5
            )
    )
    public boolean telsTerrain_decorateOreFeatureRedstone(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_ORES.DISABLE_OVERWORLD_REDSTONE_ORE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 6
            )
    )
    public boolean telsTerrain_decorateOreFeatureDiamond(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_ORES.DISABLE_OVERWORLD_DIAMOND_ORE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/OreFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 7
            )
    )
    public boolean telsTerrain_decorateOreFeatureLapisLazuli(OreFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_ORES.DISABLE_OVERWORLD_LAPIS_LAZULI_ORE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/Feature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateTrees(Feature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (instance instanceof OakTreeFeature) {
            if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_TREES.DISABLE_OVERWORLD_SMALL_OAK_TREES) {
                return original.call(instance, world, random, x, y, z);
            } else {
                return true;
            }
        } else if (instance instanceof LargeOakTreeFeature) {
            if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_TREES.DISABLE_OVERWORLD_LARGE_OAK_TREES) {
                return original.call(instance, world, random, x, y, z);
            } else {
                return true;
            }
        } else if (instance instanceof PineTreeFeature) {
            if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_TREES.DISABLE_OVERWORLD_PINE_TREES) {
                return original.call(instance, world, random, x, y, z);
            } else {
                return true;
            }
        } else if (instance instanceof BirchTreeFeature) {
            if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_TREES.DISABLE_OVERWORLD_BIRCH_TREES) {
                return original.call(instance, world, random, x, y, z);
            } else {
                return true;
            }
        } else {
            return original.call(instance, world, random, x, y, z);
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/PlantPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decoratePlantFeatureDandelions(PlantPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_DANDELIONS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/PlantPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 1
            )
    )
    public boolean telsTerrain_decoratePlantFeatureRoses(PlantPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_ROSES) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/PlantPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 2
            )
    )
    public boolean telsTerrain_decoratePlantFeatureBrownMushrooms(PlantPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_BROWN_MUSHROOMS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/PlantPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 3
            )
    )
    public boolean telsTerrain_decoratePlantFeatureRedMushrooms(PlantPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_RED_MUSHROOMS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/GrassPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateTallGrassFeature(GrassPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_TALL_GRASS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/DeadBushPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateDeadBushFeature(DeadBushPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_DEAD_BUSHES) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/SugarCanePatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateSugarCaneFeature(SugarCanePatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_SUGAR_CANE) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/PumpkinPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decoratePumpkinFeature(PumpkinPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_PUMPKINS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/CactusPatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateCactusFeature(CactusPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_SMALL_PLANTS.DISABLE_OVERWORLD_CACTI) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/SpringFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateWaterSpring(SpringFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_FLUID_FEATURES.DISABLE_OVERWORLD_WATERFALLS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/SpringFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 1
            )
    )
    public boolean telsTerrain_decorateLavaSpring(SpringFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.OVERWORLD_FLUID_FEATURES.DISABLE_OVERWORLD_LAVAFALLS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }
}
