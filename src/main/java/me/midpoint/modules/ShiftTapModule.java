package me.midpoint.modules;

public class ShiftTapModule extends Module {
    public ShiftTapModule() { super("Shift Tap", -1); }

    @Override
    public void tick() {
        if (!enabled || mc.player == null) return;
        // Если игрок атакует (левая кнопка мыши зажата), эмулируем шифт
        if (mc.options.attackKey.isPressed()) {
            mc.options.sneakKey.setPressed(true);
        } else {
            mc.options.sneakKey.setPressed(false);
        }
    }
}
