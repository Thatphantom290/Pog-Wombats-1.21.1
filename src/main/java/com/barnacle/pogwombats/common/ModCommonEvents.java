package com.barnacle.pogwombats.common;

import com.barnacle.pogwombats.common.entity.Wombat;
import com.barnacle.pogwombats.core.registry.PWEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = "pogwombats", bus = EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PWEntities.WOMBAT.get(), Wombat.createAttributes().build());
    }
}