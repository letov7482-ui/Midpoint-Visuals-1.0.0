package me.midpoint;

import me.midpoint.modules.BaseModule;
import me.midpoint.modules.WatermarkModule;
import net.fabricmc.api.ClientModInitializer;

import java.util.ArrayList;
import java.util.List;

public class MidpointClient implements ClientModInitializer {
    public static List<BaseModule> modules = new ArrayList<>();

    @Override
    public void onInitializeClient() {
        modules.add(new WatermarkModule());
        System.out.println("[Midpoint Visuals] Загружено (без Fabric API)");
    }
}
