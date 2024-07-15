package show.trom.mod.init;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import show.trom.mod.client.renderer.KingOfTheCrystalRenderer;
import show.trom.mod.client.renderer.PurpleCrystalBrickRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TromRenderer {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TromEntities.KING_OF_THE_CRYSTAL.get(), KingOfTheCrystalRenderer::new);
        event.registerEntityRenderer(TromEntities.PURPLE_CRYSTAL_BRICK.get(), PurpleCrystalBrickRenderer::new);
    }
}
