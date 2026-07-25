package me.midpoint;

import me.midpoint.config.ModConfig;
import me.midpoint.modules.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class MidpointClient implements ClientModInitializer {
    public static final String MOD_ID = "midpoint";
    public static ModConfig CONFIG;
    public static List<Module> modules = new ArrayList<>();
    public static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        CONFIG = ModConfig.load();
        
        // Регистрация модулей
        modules.add(new EmoteModule());
        modules.add(new ShiftTapModule());
        modules.add(new HealingHelperModule());
        modules.add(new CooldownsModule());
        modules.add(new ItemScrollerModule());
        modules.add(new ItemSwapModule());
        modules.add(new ElytraSwapModule());
        modules.add(new TotemTrackerModule());
        modules.add(new FreeLookModule());
        modules.add(new AspectRatioModule());
        modules.add(new BlockOverlayModule());
        modules.add(new FullbrightModule());
        modules.add(new HitboxCustomizerModule());
        modules.add(new ParticlesModule());
        modules.add(new TargetESPModule());
        modules.add(new WorldParticlesModule());
        modules.add(new NimbModule());
        modules.add(new HudModule());
        modules.add(new PotionsModule());
        modules.add(new TargetHudModule());
        modules.add(new WatermarkModule());

        // Клавиша для открытия GUI (по умолчанию P)
        openGuiKey = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.midpoint.openGui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.midpoint.general")
        );

        // Tick обработчик
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            for (Module m : modules) {
                if (m.enabled) m.tick();
            }
        });

        System.out.println("[Midpoint Visuals] Загружено!");
    }

    public static void tickModules() {
        // Вызывается из миксина для рендера
    }
}
