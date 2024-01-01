package net.krlite.it_follows.mixin;

import net.krlite.it_follows.ItFollows;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.joml.Vector2i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Shadow protected abstract void onCursorPos(long window, double x, double y);

    @Inject(method = "onResolutionChanged", at = @At("RETURN"))
    private void onResolutionChanged(CallbackInfo ci) {
        Vector2i pos = ItFollows.buttonPos();
        if (pos != null) {
            onCursorPos(MinecraftClient.getInstance().getWindow().getHandle(), pos.x(), pos.y());
            System.out.println(pos.x() + ", " + pos.y());
        }
    }
}
