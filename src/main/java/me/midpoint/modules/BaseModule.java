package me.midpoint.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public abstract class BaseModule {
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public String name;
    public boolean enabled;
    public int keyBind;

    public BaseModule(String name, int keyBind) {
        this.name = name;
        this.keyBind = keyBind;
        this.enabled = true; // по умолчанию включён для теста
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {}
    public void onDisable() {}
    public void tick() {}
    public void render(DrawContext context) {}
}
