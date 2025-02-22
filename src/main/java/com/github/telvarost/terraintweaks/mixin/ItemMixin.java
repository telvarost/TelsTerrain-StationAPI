package com.github.telvarost.terraintweaks.mixin;

import com.github.telvarost.terraintweaks.Config;
import com.github.telvarost.terraintweaks.ModHelper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResultType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(
            method = "use",
            at = @At("HEAD"),
            cancellable = true
    )
    public void terrainTweaks_use(ItemStack stack, World world, PlayerEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (Item.BOWL.id == stack.itemId && Config.config.ALLOW_SHAPING_WATER_AND_LAVA) {
            float var4 = 1.0F;
            float var5 = user.prevPitch + (user.pitch - user.prevPitch) * var4;
            float var6 = user.prevYaw + (user.yaw - user.prevYaw) * var4;
            double var7 = user.prevX + (user.x - user.prevX) * (double) var4;
            double var9 = user.prevY + (user.y - user.prevY) * (double) var4 + 1.62 - (double) user.standingEyeHeight;
            double var11 = user.prevZ + (user.z - user.prevZ) * (double) var4;
            Vec3d var13 = Vec3d.createCached(var7, var9, var11);
            float var14 = MathHelper.cos(-var6 * 0.017453292F - 3.1415927F);
            float var15 = MathHelper.sin(-var6 * 0.017453292F - 3.1415927F);
            float var16 = -MathHelper.cos(-var5 * 0.017453292F);
            float var17 = MathHelper.sin(-var5 * 0.017453292F);
            float var18 = var15 * var16;
            float var20 = var14 * var16;
            double var21 = 5.0;
            Vec3d var23 = var13.add((double) var18 * var21, (double) var17 * var21, (double) var20 * var21);

            ModHelper.ModHelperFields.NEGATE_LIQUID_META_CHECK = true;
            HitResult var24 = world.raycast(var13, var23, true);
            ModHelper.ModHelperFields.NEGATE_LIQUID_META_CHECK = false;

            if (var24 == null) {
                cir.setReturnValue(stack);
                return;
            } else {
                if (var24.type == HitResultType.BLOCK) {
                    int var25 = var24.blockX;
                    int var26 = var24.blockY;
                    int var27 = var24.blockZ;
                    if (!world.canInteract(user, var25, var26, var27)) {
                        cir.setReturnValue(stack);
                        return;
                    }

                    if (world.getMaterial(var25, var26, var27) == Material.WATER) {
                        int blockMeta = world.getBlockMeta(var25, var26, var27);

                        if (7 <= blockMeta) {
                            world.setBlockWithoutNotifyingNeighbors(var25, var26, var27, 0, 0);
                            world.setBlockDirty(var25, var26, var27);
                        } else {
                            blockMeta++;

                            world.setBlockMetaWithoutNotifyingNeighbors(var25, var26, var27, blockMeta);
                            world.setBlockDirty(var25, var26, var27);
                        }

                        cir.setReturnValue(new ItemStack(Item.BOWL, stack.count));
                        return;
                    } else if (world.getMaterial(var25, var26, var27) == Material.LAVA) {
                        int blockMeta = world.getBlockMeta(var25, var26, var27);

                        if (7 <= blockMeta) {
                            world.setBlockWithoutNotifyingNeighbors(var25, var26, var27, 0, 0);
                            world.setBlockDirty(var25, var26, var27);
                        } else {
                            blockMeta++;

                            world.setBlockMetaWithoutNotifyingNeighbors(var25, var26, var27, blockMeta);
                            world.setBlockDirty(var25, var26, var27);
                        }

                        world.playSound((double)((float)var25 + 0.5F), (double)((float)var26 + 0.5F), (double)((float)var27 + 0.5F), "random.fizz", 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
                        for(int smokeIndex = 0; smokeIndex < 3; ++smokeIndex) {
                            world.addParticle("largesmoke", (double)var25 + Math.random(), (double)var26 + 1.2, (double)var27 + Math.random(), 0.0, 0.0, 0.0);
                        }

                        stack.count--;
                        cir.setReturnValue(stack);
                        return;
                    }
                }

                cir.setReturnValue(stack);
                return;
            }
        }
    }
}
