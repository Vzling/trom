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
import net.minecraft.util.Mth;
import show.trom.mod.client.model.KingOfTheCrystalModel;
import show.trom.mod.entity.KingOfTheCrystal;

public class KingOfTheCrystalRenderer extends MobRenderer<KingOfTheCrystal, KingOfTheCrystalModel<KingOfTheCrystal>> {
    public KingOfTheCrystalRenderer(EntityRendererProvider.Context context) {
        super(context, new KingOfTheCrystalModel(context.bakeLayer(KingOfTheCrystalModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("trom:textures/entity/king_of_the_crystal_glow.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KingOfTheCrystal entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
                EntityModel model = new KingOfTheCrystalModel(Minecraft.getInstance().getEntityModels().bakeLayer(KingOfTheCrystalModel.LAYER_LOCATION));
                this.getParentModel().copyPropertiesTo(model);
                model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
            }
        });
    }

    @Override
    protected void scale(KingOfTheCrystal entity, PoseStack stack, float partialTicks) {
        float bounce = entity.tickCount + partialTicks;
        stack.translate(0F, Mth.sin((bounce) * 0.2F) * 0.15F, 0F);
    }

    @Override
    public ResourceLocation getTextureLocation(KingOfTheCrystal entity) {
        return new ResourceLocation("trom:textures/entity/king_of_the_crystal.png");
    }
}

