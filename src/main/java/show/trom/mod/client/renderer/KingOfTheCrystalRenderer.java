package show.trom.mod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import show.trom.mod.client.model.KingOfTheCrystalModel;
import show.trom.mod.entity.KingOfTheCrystal;

public class KingOfTheCrystalRenderer extends MobRenderer<KingOfTheCrystal, KingOfTheCrystalModel<KingOfTheCrystal>> {
    public KingOfTheCrystalRenderer(EntityRendererProvider.Context context) {
        super(context, new KingOfTheCrystalModel<>(context.bakeLayer(KingOfTheCrystalModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(KingOfTheCrystal entity) {
        return new ResourceLocation("trom:textures/entity/king_of_the_crystal.png");
    }
}

