package com.barnacle.pogwombats.core.registry;

import com.barnacle.pogwombats.PogWombats;
import com.barnacle.pogwombats.common.entity.Wombat;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class PWEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PogWombats.MOD_ID);

    public static final Supplier<EntityType<Wombat>> WOMBAT =
            ENTITY_TYPES.register("wombat", () -> EntityType.Builder.of(Wombat::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f).build("wombat"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
