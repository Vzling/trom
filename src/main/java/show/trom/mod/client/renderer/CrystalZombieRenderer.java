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
import show.trom.mod.client.model.CrystalZombieModel;
import show.trom.mod.entity.CrystalZombie;

public class CrystalZombieRenderer extends MobRenderer<CrystalZombie, CrystalZombieModel<CrystalZombie>> {
    public CrystalZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new CrystalZombieModel(context.bakeLayer(CrystalZombieModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("trom:textures/entity/crystal_zombie_glow.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CrystalZombie entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
                EntityModel model = new CrystalZombieModel(Minecraft.getInstance().getEntityModels().bakeLayer(CrystalZombieModel.LAYER_LOCATION));
                this.getParentModel().copyPropertiesTo(model);
                model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalZombie entity) {
        return new ResourceLocation("trom:textures/entity/crystal_zombie.png");
    }
}

