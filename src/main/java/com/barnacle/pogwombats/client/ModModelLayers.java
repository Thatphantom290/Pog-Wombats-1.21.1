package com.barnacle.pogwombats.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation WOMBAT = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("pogwombats", "wombat"), "main"
    );
    public static final ModelLayerLocation BABY_WOMBAT = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("pogwombats", "baby_wombat"), "main"
    );

    public static final ModelLayerLocation PACARANA = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("pogwombats", "pacarana"), "main"
    );
    public static final ModelLayerLocation BABY_PACARANA = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("pogwombats", "baby_pacarana"), "main"
    );
}