package me.midpoint.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
    // Настройки модулей (включение/выключение)
    public boolean emoteEnabled = false;
    public boolean shiftTapEnabled = false;
    public boolean healingHelperEnabled = true;
    public boolean cooldownsEnabled = true;
    public boolean itemScrollerEnabled = true;
    public boolean itemSwapEnabled = false;
    public boolean elytraSwapEnabled = false;
    public boolean totemTrackerEnabled = true;
    public boolean freeLookEnabled = false;
    public boolean aspectRatioEnabled = false;
    public boolean blockOverlayEnabled = true;
    public boolean fullbrightEnabled = true;
    public boolean hitboxCustomizerEnabled = true;
    public boolean particlesEnabled = true;
    public boolean targetESPEnabled = true;
    public boolean worldParticlesEnabled = true;
    public boolean nimbEnabled = true;
    public boolean hudEnabled = true;
    public boolean potionsEnabled = true;
    public boolean targetHudEnabled = true;
    public boolean watermarkEnabled = true;

    // Доп. параметры
    public int healingSlot = -1;
    public float aspectRatioValue = 1.333f; // 4:3
    public int hitboxColor = 0xFFFFFF; // белый
    public int blockOverlayColor = 0xFFFFFF;
    public int targetEspMode = 0; // 0 - призраки, 1 - орбитал, 2 - кубики

    public static ModConfig load() {
        File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "midpoint-visuals.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                return new Gson().fromJson(reader, ModConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ModConfig();
    }

    public void save() {
        File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "midpoint-visuals.json");
        try (FileWriter writer = new FileWriter(file)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
