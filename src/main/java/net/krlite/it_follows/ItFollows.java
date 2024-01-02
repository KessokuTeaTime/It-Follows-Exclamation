package net.krlite.it_follows;

import net.fabricmc.api.ModInitializer;
import net.krlite.it_follows.mixin.ClickableWidgetAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.util.Window;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2d;
import org.joml.Vector2i;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ItFollows implements ModInitializer {
	public static final String NAME = "It Follows!", ID = "it-follows";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	private static boolean allowFollowing = false;
	private static @Nullable ClickableWidget widget;
	private static Vector2i widgetPos = new Vector2i();

	@Override
	public void onInitialize() {
	}

	private static boolean widgetCheckFailed(ClickableWidget widget) {
		return !widget.equals(ItFollows.widget);
	}

	public static void allowFollowing(ClickableWidget widget) {
		if (widgetCheckFailed(widget)) return;

		allowFollowing = true;
	}

	public static Optional<Vector2d> widgetPosUnscaled() {
		if (allowFollowing) {
			allowFollowing = false;

			Window window = MinecraftClient.getInstance().getWindow();
			Vector2d pos = new Vector2d(
					window.getWidth() * (double) widgetPos.x() / window.getScaledWidth(),
					window.getHeight() * (double) widgetPos.y() / window.getScaledHeight()
			);

			return Optional.ofNullable(
					pos.x() >= 0 && pos.x() <= window.getWidth() && pos.y() >= 0 && pos.y() <= window.getHeight() ? pos : null
			);
		} else return Optional.empty();
	}

	public static void foundWidget(ClickableWidget widget) {
		ItFollows.widget = widget;
	}

	public static void fetchXFromWidget(ClickableWidget widget) {
		if (widgetCheckFailed(widget)) return;

		ClickableWidgetAccessor accessor = ((ClickableWidgetAccessor) widget);
		widgetPos.set(accessor.getX() + accessor.getWidth() / 2, widgetPos.y());
	}

	public static void fetchYFromWidget(ClickableWidget widget) {
		if (widgetCheckFailed(widget)) return;

		ClickableWidgetAccessor accessor = ((ClickableWidgetAccessor) widget);
		widgetPos.set(widgetPos.x(), accessor.getY() + accessor.getHeight() / 2);
	}
}
