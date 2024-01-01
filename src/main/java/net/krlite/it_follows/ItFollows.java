package net.krlite.it_follows;

import net.fabricmc.api.ModInitializer;
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
	private static PressableWidget GUI_SCALE_WIDGET = null;
	@Nullable
	private static Supplier<Vector2i> WIDGET_POS_SUPPLIER = null;

	@Override
	public void onInitialize() {
	}

	public static void guiScaleWidget(PressableWidget widget) {
		GUI_SCALE_WIDGET = widget;
	}

	public static @Nullable Vector2i widgetPos() {
		if (WIDGET_POS_SUPPLIER != null) {
			return WIDGET_POS_SUPPLIER.get();
		} else return null;
	}

	public static void widgetPos(PressableWidget widget, Supplier<Vector2i> supplier) {
		if (widget.equals(GUI_SCALE_WIDGET)) {
			WIDGET_POS_SUPPLIER = supplier;
		}
	}
}
