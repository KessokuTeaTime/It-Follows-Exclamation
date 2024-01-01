package net.krlite.it_follows;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.util.ActionResult;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItFollows implements ModInitializer {
	public static final String NAME = "It Follows!", ID = "it-follows";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Nullable
	private static PressableWidget GUI_SCALE_WIDGET = null;
	@Nullable
	private static Vector2i BUTTON_POS = null;

	@Override
	public void onInitialize() {
	}

	public static void guiScaleWidget(PressableWidget widget) {
		GUI_SCALE_WIDGET = widget;
	}

	public static @Nullable Vector2i buttonPos() {
		return BUTTON_POS;
	}

	public static void buttonPos(PressableWidget widget, int x, int y) {
		if (widget.equals(GUI_SCALE_WIDGET)) {
			BUTTON_POS = new Vector2i(x, y);
		}
	}
}
