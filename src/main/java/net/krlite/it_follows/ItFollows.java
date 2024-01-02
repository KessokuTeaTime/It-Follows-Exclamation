package net.krlite.it_follows;

import net.fabricmc.api.ModInitializer;
import net.krlite.it_follows.mixin.ClickableWidgetAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.util.Window;
import org.joml.Vector2d;
import org.joml.Vector2i;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.Supplier;

public class ItFollows implements ModInitializer {
	public static final String NAME = "It Follows!", ID = "it-follows";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	private static boolean allowFollowing = false;
	private static Supplier<Vector2i> widgetPosSupplier = () -> new Vector2i();

	@Override
	public void onInitialize() {
	}

	public static void allowFollowing() {
		allowFollowing = true;
	}

	public static Optional<Vector2d> widgetPosUnscaled() {
		if (allowFollowing) {
			allowFollowing = false;
			Vector2i pos = widgetPosSupplier.get();
			Window window = MinecraftClient.getInstance().getWindow();
			return Optional.of(new Vector2d(
					window.getWidth() * (double) pos.x() / window.getScaledWidth(),
					window.getHeight() * (double) pos.y() / window.getScaledHeight()
			));
		} else return Optional.empty();
	}

	public static void fetchPosFromWidget(ClickableWidget widget) {
		ClickableWidgetAccessor accessor = ((ClickableWidgetAccessor) widget);
		widgetPosSupplier = () -> new Vector2i(accessor.getX() + accessor.getWidth() / 2, accessor.getY() + accessor.getHeight() / 2);
	}
}
