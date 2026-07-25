package me.midpoint.gui;

import me.midpoint.MidpointClient;
import me.midpoint.modules.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MidpointGui extends Screen {
    private List<Module> modules;
    private TextFieldWidget searchBar;
    private int scrollOffset = 0;

    public MidpointGui() {
        super(Text.literal("Midpoint Visuals"));
        this.modules = new ArrayList<>(MidpointClient.modules);
    }

    @Override
    protected void init() {
        super.init();
        this.searchBar = new TextFieldWidget(this.textRenderer, 10, 10, 200, 20, Text.literal("Поиск"));
        this.addDrawableChild(searchBar);

        int y = 40;
        for (Module mod : modules) {
            ButtonWidget btn = ButtonWidget.builder(
                    Text.literal(mod.name + (mod.enabled ? " §aВкл" : " §cВыкл")),
                    button -> {
                        mod.toggle();
                        button.setMessage(Text.literal(mod.name + (mod.enabled ? " §aВкл" : " §cВыкл")));
                        MidpointClient.CONFIG.save();
                    })
                    .dimensions(10, y, 180, 20)
                    .build();
            this.addDrawableChild(btn);
            y += 25;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        // Градиент
        context.fillGradient(0, 0, this.width, this.height,
                new Color(20, 0, 40, 200).getRGB(),
                new Color(80, 0, 120, 200).getRGB());

        // Заголовок
        context.drawText(this.textRenderer, "Midpoint Visuals", this.width/2 - 70, 10, 0xFFAAFF, true);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() { return false; }
}
