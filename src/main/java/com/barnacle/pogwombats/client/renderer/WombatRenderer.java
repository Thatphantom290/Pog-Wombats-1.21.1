package com.barnacle.pogwombats.client.renderer;

import com.barnacle.pogwombats.client.ModModelLayers;
import com.barnacle.pogwombats.client.model.BabyWombatModel;
import com.barnacle.pogwombats.client.model.WombatModel;
import com.barnacle.pogwombats.common.entity.Wombat;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.EntityModel;

    public class WombatRenderer extends MobRenderer<Wombat, EntityModel<Wombat>> {

    private static final ResourceLocation ADULT_TEXTURE = ResourceLocation.fromNamespaceAndPath("pogwombats", "textures/entity/wombat/wombat.png");
    private static final ResourceLocation BABY_TEXTURE = ResourceLocation.fromNamespaceAndPath("pogwombats", "textures/entity/wombat/wombat_baby.png");

    private final EntityModel<Wombat> adultModel;
    private final EntityModel<Wombat> babyModel;

    public WombatRenderer(EntityRendererProvider.Context context) {
        super(context, new WombatModel<>(context.bakeLayer(ModModelLayers.WOMBAT)), 0.5f);

        this.adultModel = this.getModel();
        this.babyModel = new BabyWombatModel<>(context.bakeLayer(ModModelLayers.BABY_WOMBAT));
    }

    @Override
    public ResourceLocation getTextureLocation(Wombat entity) {
        return entity.isBaby() ? BABY_TEXTURE : ADULT_TEXTURE;
    }

    @Override
    public void render(Wombat entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            this.model = this.babyModel;
        } else {
            this.model = this.adultModel;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}