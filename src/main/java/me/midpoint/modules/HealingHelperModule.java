package me.midpoint.modules;

import me.midpoint.MidpointClient;
import net.minecraft.item.Items;

public class HealingHelperModule extends Module {
    public HealingHelperModule() { super("Healing Helper", -1); }

    @Override
    public void tick() {
        if (!enabled || mc.player == null) return;
        float hp = mc.player.getHealth();
        if (hp < 8.0f) {
            // Ищем золотые яблоки в хотбаре
            for (int i = 0; i < 9; i++) {
                var stack = mc.player.getInventory().getStack(i);
                if (stack.getItem() == Items.GOLDEN_APPLE || stack.getItem() == Items.ENCHANTED_GOLDEN_APPLE) {
                    MidpointClient.CONFIG.healingSlot = i;
                    return;
                }
            }
        }
        MidpointClient.CONFIG.healingSlot = -1;
    }
}
