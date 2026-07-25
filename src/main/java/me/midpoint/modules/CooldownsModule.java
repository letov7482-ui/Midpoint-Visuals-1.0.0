package me.midpoint.modules;

import net.minecraft.item.Item;
import java.util.HashMap;
import java.util.Map;

public class CooldownsModule extends Module {
    private Map<Item, Long> cooldowns = new HashMap<>();

    public CooldownsModule() { super("Cooldowns", -1); }

    @Override
    public void tick() {
        if (!enabled || mc.player == null) return;
        var cooldownManager = mc.player.getItemCooldownManager();
        for (int i = 0; i < mc.player.getInventory().size(); i++) {
            var stack = mc.player.getInventory().getStack(i);
            if (stack.isEmpty()) continue;
            float progress = cooldownManager.getCooldownProgress(stack.getItem(), 0.0f);
            if (progress > 0) {
                long remaining = (long) (progress * 20 * 50); // тики в мс
                cooldowns.put(stack.getItem(), System.currentTimeMillis() + remaining);
            } else {
                cooldowns.remove(stack.getItem());
            }
        }
    }

    public long getRemaining(Item item) {
        return cooldowns.getOrDefault(item, 0L) - System.currentTimeMillis();
    }
}
