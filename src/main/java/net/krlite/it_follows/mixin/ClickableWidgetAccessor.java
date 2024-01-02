package net.krlite.it_follows.mixin;

import net.minecraft.client.gui.widget.ClickableWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClickableWidget.class)
public interface ClickableWidgetAccessor {
    @Accessor("x")
    int getX();

    @Accessor("y")
    int getY();

    @Accessor
    int getWidth();

    @Accessor
    int getHeight();
}
