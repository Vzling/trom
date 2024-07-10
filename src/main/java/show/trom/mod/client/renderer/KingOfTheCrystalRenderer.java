package show.trom.mod.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import show.trom.mod.client.model.KingOfTheCrystalModel;
import show.trom.mod.entity.KingOfTheCrystal;

public class KingOfTheCrystalRenderer extends MobRenderer<KingOfTheCrystal, KingOfTheCrystalModel<KingOfTheCrystal>> {
    public KingOfTheCrystalRenderer(EntityRendererProvider.Context context) {
        super(context, new KingOfTheCrystalModel<>(context.bakeLayer(KingOfTheCrystalModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(KingOfTheCrystal entity) {
        return new ResourceLocation("trom:textures/entity/king_of_the_crystal.png");
    }
}

