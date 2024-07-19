package show.trom.mod.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import show.trom.mod.client.model.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TromModel {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(KingOfTheCrystalModel.LAYER_LOCATION, KingOfTheCrystalModel::createBodyLayer);
        event.registerLayerDefinition(PurpleCrystalBrickModel.LAYER_LOCATION, PurpleCrystalBrickModel::createBodyLayer);
        event.registerLayerDefinition(CrystalZombieModel.LAYER_LOCATION, CrystalZombieModel::createBodyLayer);
        event.registerLayerDefinition(CrystalSkeletonModel.LAYER_LOCATION, CrystalSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(CrystalIllagerModel.LAYER_LOCATION, CrystalIllagerModel::createBodyLayer);
    }
}
