package com.barnacle.pogwombats.client;

import com.barnacle.pogwombats.client.model.BabyWombatModel;
import com.barnacle.pogwombats.client.model.WombatModel;
import com.barnacle.pogwombats.client.renderer.WombatRenderer;
import com.barnacle.pogwombats.core.registry.PWEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "pogwombats", bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.WOMBAT, WombatModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BABY_WOMBAT, BabyWombatModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PWEntities.WOMBAT.get(), WombatRenderer::new);
    }
}