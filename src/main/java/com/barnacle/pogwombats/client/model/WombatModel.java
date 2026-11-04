package com.barnacle.pogwombats.client.model;

import com.barnacle.pogwombats.common.entity.Wombat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class WombatModel <T extends Wombat> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart leftarm;
    private final ModelPart leftleg;
    private final ModelPart rightarm;
    private final ModelPart rightleg;
    private final ModelPart head;

    public WombatModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.leftarm = this.root.getChild("leftarm");
        this.leftleg = this.root.getChild("leftleg");
        this.rightarm = this.root.getChild("rightarm");
        this.rightleg = this.root.getChild("rightleg");
        this.head = this.root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0F, -4.0F, 11.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -6.0F, 0.0F));

        PartDefinition leftarm = root.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(0, 23).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -3.0F, -1.5F));

        PartDefinition leftleg = root.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 29).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -3.0F, 5.5F));

        PartDefinition rightarm = root.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(12, 23).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -3.0F, -1.5F));

        PartDefinition rightleg = root.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(12, 29).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -3.0F, 5.5F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 36).addBox(-4.0F, -5.0F, -4.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(36, 39).addBox(-1.0F, -11.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 20).addBox(-5.0F, -5.1F, -5.0F, 11.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(24, 30).addBox(-1.0F, -3.0F, -5.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 30).addBox(-5.0F, -7.0F, -1.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(32, 33).addBox(4.0F, -7.0F, -1.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -7.0F, -3.0F));

        return LayerDefinition.create(meshdefinition, 48, 48);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.head.resetPose();
        this.leftarm.resetPose();
        this.rightarm.resetPose();
        this.leftleg.resetPose();
        this.rightleg.resetPose();

        this.applyHeadRotation(netHeadYaw, headPitch);

        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
