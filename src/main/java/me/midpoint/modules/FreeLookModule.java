package me.midpoint.modules;

import net.minecraft.client.option.Perspective;

public class FreeLookModule extends Module {
    private float yaw, pitch;

    public FreeLookModule() { super("Free Look", -1); }

    @Override
    public void onEnable() {
        if (mc.player != null) {
            yaw = mc.player.getYaw();
            pitch = mc.player.getPitch();
        }
        mc.options.setPerspective(Perspective.THIRD_PERSON_BACK);
    }

    @Override
    public void tick() {
        if (!enabled || mc.player == null) return;
        // В миксине Mouse перехватываем движение и применяем к этим переменным
        // здесь только заглушка
    }

    @Override
    public void onDisable() {
        mc.options.setPerspective(Perspective.FIRST_PERSON);
    }
}
