package me.midpoint;

import me.midpoint.modules.BaseModule;
import me.midpoint.modules.WatermarkModule;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class MidpointClient implements ClientModInitializer {
    public static List<BaseModule> modules = new ArrayList<>();
    public static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        // Регистрация модулей
        modules.add(new WatermarkModule());

        // Клавиша для GUI (позже)
        openGuiKey = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.midpoint.openGui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.midpoint.general")
        );

        // Tick-обработчик
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            for (BaseModule m : modules) {
                if (m.enabled) m.tick();
            }
        });

        // Рендер-обработчик (для HUD)
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            for (BaseModule m : modules) {
                if (m.enabled) m.render();
            }
        });

        System.out.println("[Midpoint Visuals] Загружено с модулями!");
    }
}
