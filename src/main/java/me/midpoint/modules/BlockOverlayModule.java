package me.midpoint.modules;

import me.midpoint.MidpointClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;

public class BlockOverlayModule extends Module {
    public BlockOverlayModule() { super("Block Overlay", -1); }

    public static void render() {
        // Рендер вызывается из миксина
        // Меняем цвет выделения блока
        if (MidpointClient.CONFIG.blockOverlayEnabled) {
            // Цвет берем из конфига
            int color = MidpointClient.CONFIG.blockOverlayColor;
            // Здесь рисуем контур блока с нужным цветом
        }
    }
}
