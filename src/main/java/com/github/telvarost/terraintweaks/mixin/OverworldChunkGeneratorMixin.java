package com.github.telvarost.terraintweaks.mixin;

import com.github.telvarost.terraintweaks.Config;
import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.ClayOreFeature;
import net.minecraft.world.gen.feature.DungeonFeature;
import net.minecraft.world.gen.feature.OreFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(OverworldChunkGenerator.class)
public class OverworldChunkGeneratorMixin {

    @Shadow private Random random;

    @Shadow private World world;

    /* Ideas */
//    TerrainTweaks
//    REDSTONE_RAINFOREST     = YES - Blood forest
//    LAPIS_SWAMPLAND         = YES - Sea creature
//    COBWEBS_SEASONAL_FOREST = YES - Season cycles or Frozen depths -> (snow if Aether is present)
//    COAL_FOREST             = YES - Decaying trees or Glowing abyss -> (glowstone if StartInNether is present)
//    SANDSTONE_SAVANNA       = YES - Baked soil or Loose soil -> (sand if BNB is present)
//    CLAY_SHRUBLAND          = YES - Hard soil
//    IRON_TAIGA              = YES - Cold metal
//    GOLD_DESERT             = YES - Hot metal
//    NORMAL_PLAINS           = YES - Plain walk
//    ICE_ICE_DESERT          = YES - Ice wall
//    DIAMOND_TUNDRA          = YES - White clarity
//    SAND_HELL               = YES - Plantable glowstone
//    SNOW_SKY                = YES - Frozen atmosphere


    /* Reference */
//        for(var13 = 0; var13 < 8; ++var13) {
//        var14 = var4 + this.random.nextInt(16) + 8;
//        var15 = this.random.nextInt(128);
//        var16 = var5 + this.random.nextInt(16) + 8;
//        (new DungeonFeature()).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 10; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(128);
//        var16 = var5 + this.random.nextInt(16);
//        (new ClayOreFeature(32)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 20; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(128);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.DIRT.id, 32)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 10; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(128);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.GRAVEL.id, 32)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 20; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(128);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.COAL_ORE.id, 16)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 20; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(64);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.IRON_ORE.id, 8)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 2; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(32);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.GOLD_ORE.id, 8)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 8; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(16);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.REDSTONE_ORE.id, 7)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 1; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(16);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.DIAMOND_ORE.id, 7)).generate(this.world, this.random, var14, var15, var16);
//    }
//
//        for(var13 = 0; var13 < 1; ++var13) {
//        var14 = var4 + this.random.nextInt(16);
//        var15 = this.random.nextInt(16) + this.random.nextInt(16);
//        var16 = var5 + this.random.nextInt(16);
//        (new OreFeature(Block.LAPIS_ORE.id, 6)).generate(this.world, this.random, var14, var15, var16);
//    }


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
        if (Config.config.ENABLE_CAVE_SAND_GENERATION) {
            int var4 = x * 16;
            int var5 = z * 16;
            int var13;
            int var14;
            int var15;
            int var16;

            if (  Config.config.ENABLE_BIOME_SPECIFIC_GENERATION
               && (  Biome.TAIGA      == biomeToDecorate
                  || Biome.TUNDRA     == biomeToDecorate
                  || Biome.ICE_DESERT == biomeToDecorate
                  || Biome.SKY        == biomeToDecorate
                  )
            ) {
                for(var13 = 0; var13 < 10; ++var13) {
                    var14 = var4 + this.random.nextInt(16);
                    var15 = this.random.nextInt(8) + this.random.nextInt(40);
                    var16 = var5 + this.random.nextInt(16);
                    (new OreFeature(Block.ICE.id, 24)).generate(this.world, this.random, var14, var15, var16);
                }
            } else {
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
