package me.midpoint.modules;

import net.minecraft.client.gui.DrawContext;

public class WatermarkModule extends BaseModule {
    public WatermarkModule() {
        super("Watermark", -1);
    }

    @Override
    public void render(DrawContext context) {
        if (!enabled) return;
        String text = "Midpoint Visuals";
        int color = 0xFFAAFF;
        context.drawText(mc.textRenderer, text, 5, 5, color, true);
    }
}
