package show.trom.mod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import show.trom.mod.TromMod;
import show.trom.mod.client.animation.definitions.KingOfTheCrystalAnimation;
import show.trom.mod.client.animation.definitions.PurpleCrystalBrickAnimation;
import show.trom.mod.entity.KingOfTheCrystal;
import show.trom.mod.entity.PurpleCrystalBrick;

public class PurpleCrystalBrickModel<T extends PurpleCrystalBrick> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TromMod.MOD_ID, "purple_crystal_brick"), "main");
    public final ModelPart root;
    public final ModelPart body;

    public PurpleCrystalBrickModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));
        PartDefinition crystal = body.addOrReplaceChild("crystal", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -19.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
        PartDefinition cube_r1 = crystal.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 24).addBox(-3.0F, -6.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -11.0F, 1.0F, -0.4363F, 0.0F, 0.4363F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.idleAnimationState, PurpleCrystalBrickAnimation.idle, ageInTicks);
        this.animateWalk(PurpleCrystalBrickAnimation.walk, limbSwing, limbSwingAmount, 1.0f, 1.0f);
    }
    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}