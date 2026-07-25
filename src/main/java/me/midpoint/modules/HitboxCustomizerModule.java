package me.midpoint.modules;

import me.midpoint.MidpointClient;

public class HitboxCustomizerModule extends Module {
    public HitboxCustomizerModule() { super("Hitbox Customizer", -1); }

    public static int getColor() {
        return MidpointClient.CONFIG.hitboxColor;
    }
}
