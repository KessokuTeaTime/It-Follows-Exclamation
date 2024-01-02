package net.krlite.it_follows;

import net.fabricmc.api.ModInitializer;
import net.krlite.it_follows.mixin.ClickableWidgetAccessor;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2d;
import org.joml.Vector2i;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.Supplier;

public class ItFollows implements ModInitializer {
	public static final String NAME = "It Follows!", ID = "it-follows";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Nullable
	private static Supplier<Vector2i> WIDGET_POS_SUPPLIER = null;

	@Override
	public void onInitialize() {
	}

	public static @Nullable Vector2i widgetPos() {
		if (WIDGET_POS_SUPPLIER != null) {
			return WIDGET_POS_SUPPLIER.get();
		} else return null;
	}

	public static void fetchPosFromWidget(ClickableWidget widget) {
		ClickableWidgetAccessor accessor = ((ClickableWidgetAccessor) widget);
		WIDGET_POS_SUPPLIER = () -> new Vector2i(accessor.getX() + accessor.getWidth() / 2, accessor.getY() + accessor.getHeight() / 2);
	}
}
