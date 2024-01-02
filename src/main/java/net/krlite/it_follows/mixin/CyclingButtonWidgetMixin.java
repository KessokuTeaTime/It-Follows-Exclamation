package net.krlite.it_follows.mixin;

import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CyclingButtonWidget.class)
public abstract class CyclingButtonWidgetMixin extends PressableWidget {
    public CyclingButtonWidgetMixin(int i, int j, int k, int l, Text text) {
        super(i, j, k, l, text);
    }
}
