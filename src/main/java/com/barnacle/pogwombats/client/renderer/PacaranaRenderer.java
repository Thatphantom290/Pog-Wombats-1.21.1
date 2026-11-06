package com.barnacle.pogwombats.client.renderer;

import com.barnacle.pogwombats.client.ModModelLayers;
import com.barnacle.pogwombats.client.model.BabyPacaranaModel;
import com.barnacle.pogwombats.client.model.BabyWombatModel;
import com.barnacle.pogwombats.client.model.PacaranaModel;
import com.barnacle.pogwombats.client.model.WombatModel;
import com.barnacle.pogwombats.common.entity.Pacarana;
import com.barnacle.pogwombats.common.entity.Wombat;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PacaranaRenderer extends MobRenderer<Pacarana, EntityModel<Pacarana>> {

private static final ResourceLocation ADULT_TEXTURE = ResourceLocation.fromNamespaceAndPath("pogwombats", "textures/entity/pacarana/pacarana.png");
private static final ResourceLocation BABY_TEXTURE = ResourceLocation.fromNamespaceAndPath("pogwombats", "textures/entity/pacarana/pacarana_baby.png");

private final EntityModel<Pacarana> adultModel;
private final EntityModel<Pacarana> babyModel;

public PacaranaRenderer(EntityRendererProvider.Context context) {
    super(context, new PacaranaModel<>(context.bakeLayer(ModModelLayers.PACARANA)), 0.5f);

    this.adultModel = this.getModel();
    this.babyModel = new BabyPacaranaModel<>(context.bakeLayer(ModModelLayers.BABY_PACARANA));
}

@Override
public ResourceLocation getTextureLocation(Pacarana entity) {
    return entity.isBaby() ? BABY_TEXTURE : ADULT_TEXTURE;
}

@Override
public void render(Pacarana entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
    if (entity.isBaby()) {
        this.model = this.babyModel;
    } else {
        this.model = this.adultModel;
    }

    super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
}
}