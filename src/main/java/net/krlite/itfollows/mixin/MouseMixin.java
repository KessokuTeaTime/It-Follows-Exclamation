package net.krlite.itfollows.mixin;

import net.krlite.itfollows.ItFollows;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.util.InputUtil;
import org.joml.Vector2d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Shadow private double x;

    @Shadow private double y;

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "onResolutionChanged", at = @At("RETURN"))
    private void onResolutionChanged(CallbackInfo ci) {
        Optional<Vector2d> pos = ItFollows.widgetPosUnscaled();
        if (pos.isPresent()) {
            x = pos.get().x();
            y = pos.get().y();
            InputUtil.setCursorParameters(client.getWindow().getHandle(), 212993, x, y);
        }
    }
}
