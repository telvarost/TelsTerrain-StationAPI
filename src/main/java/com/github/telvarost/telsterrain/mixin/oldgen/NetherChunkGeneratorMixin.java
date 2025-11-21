package com.github.telvarost.telsterrain.mixin.oldgen;

import com.github.telvarost.telsterrain.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.NetherChunkGenerator;
import net.minecraft.world.gen.feature.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(NetherChunkGenerator.class)
public class NetherChunkGeneratorMixin {

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/NetherLavaSpringFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateNetherLavaSpring(NetherLavaSpringFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_LAVAFALLS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/NetherFirePatchFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateNetherFirePatch(NetherFirePatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_FIRE_PATCHES) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/GlowstoneClusterFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateNetherCommonGlowstone(GlowstoneClusterFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_GLOWSTONE_CLUSTER_A) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/GlowstoneClusterRareFeature;generate(Lnet/minecraft/world/World;Ljava/util/Random;III)Z",
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateNetherRareGlowstone(GlowstoneClusterRareFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_GLOWSTONE_CLUSTER_B) {
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
                    ordinal = 0
            )
    )
    public boolean telsTerrain_decorateNetherBrownMushrooms(PlantPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_BROWN_MUSHROOMS) {
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
    public boolean telsTerrain_decorateNetherRedMushrooms(PlantPatchFeature instance, World world, Random random, int x, int y, int z, Operation<Boolean> original) {
        if (!Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_RED_MUSHROOMS) {
            return original.call(instance, world, random, x, y, z);
        } else {
            return true;
        }
    }
}
