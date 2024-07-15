package show.trom.mod.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import show.trom.mod.client.model.KingOfTheCrystalModel;
import show.trom.mod.client.model.PurpleCrystalBrickModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TromModel {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(KingOfTheCrystalModel.LAYER_LOCATION, KingOfTheCrystalModel::createBodyLayer);
        event.registerLayerDefinition(PurpleCrystalBrickModel.LAYER_LOCATION, PurpleCrystalBrickModel::createBodyLayer);
    }
}
