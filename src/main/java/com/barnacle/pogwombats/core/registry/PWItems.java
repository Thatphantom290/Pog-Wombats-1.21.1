package com.barnacle.pogwombats.core.registry;

import com.barnacle.pogwombats.PogWombats;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PWItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PogWombats.MOD_ID);

    public static final DeferredItem<Item> WOMBAT_SPAWN_EGG = ITEMS.register("wombat_spawn_egg",
            () -> new DeferredSpawnEggItem(PWEntities.WOMBAT, 0x5c514a, 0x7f6454,
                    new Item.Properties()));

    public static final DeferredItem<Item> PACARANA_SPAWN_EGG = ITEMS.register("pacarana_spawn_egg",
                () -> new DeferredSpawnEggItem(PWEntities.PACARANA, 0x272423, 0xb09a98,
                        new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
