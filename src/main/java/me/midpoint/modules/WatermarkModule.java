package me.midpoint.modules;

import net.minecraft.client.gui.DrawContext;

public class WatermarkModule extends BaseModule {
    public WatermarkModule() {
        super("Watermark", -1);
    }

    @Override
    public void render() {
        if (!enabled || mc.player == null) return;
        // Отрисовка водяного знака
        String text = "Midpoint Visuals";
        int color = 0xFFAAFF; // фиолетовый
        mc.textRenderer.draw(text, 5, 5, color, true);
    }
}
