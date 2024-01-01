package net.krlite.it_follows.mixin;

import net.krlite.it_follows.ItFollows;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CyclingButtonWidget.class)
public abstract class CyclingButtonWidgetMixin extends PressableWidget {
    public CyclingButtonWidgetMixin(int i, int j, int k, int l, Text text) {
        super(i, j, k, l, text);
    }

    @Inject(method = "cycle", at = @At("HEAD"))
    private void cycleHead(int amount, CallbackInfo ci) {
        ItFollows.buttonPos(this, getX(), getY());
    }
}
