package show.trom.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import show.trom.mod.client.model.PurpleCrystalBrickModel;
import show.trom.mod.entity.PurpleCrystalBrick;

public class PurpleCrystalBrickRenderer extends MobRenderer<PurpleCrystalBrick, PurpleCrystalBrickModel<PurpleCrystalBrick>> {
    public PurpleCrystalBrickRenderer(EntityRendererProvider.Context context) {
        super(context, new PurpleCrystalBrickModel(context.bakeLayer(PurpleCrystalBrickModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("trom:textures/entity/purple_crystal_brick_layer_2.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PurpleCrystalBrick entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(LAYER_TEXTURE));
                EntityModel model = new PurpleCrystalBrickModel(Minecraft.getInstance().getEntityModels().bakeLayer(PurpleCrystalBrickModel.LAYER_LOCATION));
                this.getParentModel().copyPropertiesTo(model);
                model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
            }
        });
        this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("trom:textures/entity/purple_crystal_brick_glow.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PurpleCrystalBrick entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
                EntityModel model = new PurpleCrystalBrickModel(Minecraft.getInstance().getEntityModels().bakeLayer(PurpleCrystalBrickModel.LAYER_LOCATION));
                this.getParentModel().copyPropertiesTo(model);
                model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
            }
        });
    }


    @Override
    public ResourceLocation getTextureLocation(PurpleCrystalBrick entity) {
        return new ResourceLocation("trom:textures/entity/purple_crystal_brick.png");
    }
}

