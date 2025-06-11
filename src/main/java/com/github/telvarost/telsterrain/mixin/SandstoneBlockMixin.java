package com.github.telvarost.telsterrain.mixin;

import com.github.telvarost.telsterrain.Config;
import net.minecraft.block.Block;
import net.minecraft.block.SandstoneBlock;
import net.minecraft.block.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SandstoneBlock.class)
public class SandstoneBlockMixin extends Block {
    public SandstoneBlockMixin(int id) {
        super(id, 192, Material.STONE);
    }

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    public void telsTerrain_init(int id, CallbackInfo ci) {
        if (Config.config.INCREASE_SANDSTONE_BLAST_RESISTANCE) {
            setResistance(7.5F);
        }
    }
}
