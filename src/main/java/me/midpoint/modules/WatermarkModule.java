package me.midpoint.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class WatermarkModule extends Module {
    public WatermarkModule() { super("Watermark", -1); }

    public static void render(DrawContext context) {
        if (!MidpointClient.CONFIG.watermarkEnabled) return;
        var client = MinecraftClient.getInstance();
        String text = "Midpoint Visuals | " + client.getCurrentFps() + " fps | " + client.player.networkHandler.getPlayerList().size() + " players";
        int color = 0xFFAAFF; // фиолетовый
        context.drawText(client.textRenderer, text, 5, 5, color, true);
    }
}
