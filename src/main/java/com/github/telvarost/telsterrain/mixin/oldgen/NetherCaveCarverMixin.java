package com.github.telvarost.telsterrain.mixin.oldgen;

import com.github.telvarost.telsterrain.Config;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.NetherCaveCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherCaveCarver.class)
public class NetherCaveCarverMixin extends Carver {

    @Inject(
            method = "carveTunnels",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void carveTunnels(
            int chunkX,
            int chunkZ,
            byte[] blocks,
            double x,
            double y,
            double z,
            float baseWidth,
            float yaw,
            float pitch,
            int tunnel,
            int tunnelCount,
            double widthHeightRatio,
            CallbackInfo ci
    ) {
        if (Config.config.OLD_TERRAIN_GENERATION.NETHER_FEATURES.DISABLE_NETHER_CAVES) {
            ci.cancel();
        }
    }
}
