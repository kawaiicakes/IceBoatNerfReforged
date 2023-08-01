package io.github.kawaiicakes.iceboatnerf.mixin;

import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Boat.class, priority = 100_000) //this is set so high to prevent other mods from accidentally modifying the return again
public class BoatMixin {
    @Inject(method = "getGroundFriction", at = @At("RETURN"), cancellable = true)
    private void getGroundFriction(@NotNull CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(0.45F); //magic number from supersaiyansubtlety's work.
        //https://gitlab.com/supersaiyansubtlety/ice_boat_nerf/-/blob/master/src/main/java/net/sssubtlety/ice_boat_nerf/mixin/BoatEntityMixin.java?ref_type=heads
    }
}