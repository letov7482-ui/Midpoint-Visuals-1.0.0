package me.midpoint;

import net.fabricmc.api.ClientModInitializer;

public class MidpointClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[Midpoint Visuals] Загружен!");
    }
}
