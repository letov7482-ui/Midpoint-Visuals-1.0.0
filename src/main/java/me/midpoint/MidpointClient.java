package me.midpoint;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class MidpointClient implements ClientModInitializer {
    public static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        // Регистрация клавиши для открытия GUI (позже)
        openGuiKey = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.midpoint.openGui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.midpoint.general")
        );

        System.out.println("[Midpoint Visuals] Загружен (базовая версия без модулей)");
        System.out.println("[Midpoint Visuals] Модули будут добавлены позже.");
    }
}
