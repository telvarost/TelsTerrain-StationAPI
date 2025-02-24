package com.github.telvarost.telsterrain.mixin;

import com.github.telvarost.telsterrain.ModHelper;
import net.minecraft.block.LiquidBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LiquidBlock.class)
public class LiquidBlockMixin {

    @Inject(
            method = "hasCollision",
            at = @At("HEAD"),
            cancellable = true
    )
    public void telsTerrain_hasCollision(int meta, boolean allowLiquids, CallbackInfoReturnable<Boolean> cir) {
        if (allowLiquids && ModHelper.ModHelperFields.NEGATE_LIQUID_META_CHECK) {
            cir.setReturnValue(true);
        }
    }
}
