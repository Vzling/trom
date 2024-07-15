package show.trom.mod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import show.trom.mod.client.model.PurpleCrystalBrickModel;
import show.trom.mod.entity.PurpleCrystalBrick;

public class PurpleCrystalBrickRenderer extends MobRenderer<PurpleCrystalBrick, PurpleCrystalBrickModel<PurpleCrystalBrick>> {
    public PurpleCrystalBrickRenderer(EntityRendererProvider.Context context) {
        super(context, new PurpleCrystalBrickModel<>(context.bakeLayer(PurpleCrystalBrickModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PurpleCrystalBrick entity) {
        return new ResourceLocation("trom:textures/entity/purple_crystal_brick.png");
    }
}

