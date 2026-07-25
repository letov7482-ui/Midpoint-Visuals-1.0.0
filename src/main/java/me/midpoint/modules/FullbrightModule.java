package me.midpoint.modules;

import net.minecraft.client.option.SimpleOption;

public class FullbrightModule extends Module {
    public FullbrightModule() { super("Fullbright", -1); }

    @Override
    public void onEnable() {
        if (mc.options != null) {
            mc.options.getGamma().setValue(100.0);
        }
    }

    @Override
    public void onDisable() {
        if (mc.options != null) {
            mc.options.getGamma().setValue(0.0);
        }
    }
}
