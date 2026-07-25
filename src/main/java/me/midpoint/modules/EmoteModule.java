package me.midpoint.modules;

public class EmoteModule extends Module {
    private float rotationYaw = 0;
    private boolean sitting = false;

    public EmoteModule() {
        super("Emotes", -1);
    }

    @Override
    public void tick() {
        if (!enabled || mc.player == null) return;
        // Вращение на 360°
        rotationYaw += 5.0f;
        if (rotationYaw > 360) rotationYaw -= 360;
        mc.player.setYaw(mc.player.getYaw() + 5.0f);

        // Сидение – уменьшаем хитбокс через миксин (здесь только флаг)
        // В миксине PlayerEntity будет проверка этого модуля
    }

    public boolean isSitting() { return enabled; }
    public float getYawOffset() { return rotationYaw; }
}
