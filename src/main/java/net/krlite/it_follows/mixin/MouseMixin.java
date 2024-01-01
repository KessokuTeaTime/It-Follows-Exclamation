package net.krlite.it_follows.mixin;

import net.krlite.it_follows.ItFollows;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.util.InputUtil;
import org.joml.Vector2i;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Shadow private double x;

    @Shadow private double y;

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "onResolutionChanged", at = @At("RETURN"))
    private void onResolutionChanged(CallbackInfo ci) {
        Vector2i pos = ItFollows.widgetPos();
        if (pos != null) {
            System.out.println(pos);
            x = pos.x();
            y = pos.y();
            InputUtil.setCursorParameters(client.getWindow().getHandle(), 212993, x, y);
        }
    }
}
