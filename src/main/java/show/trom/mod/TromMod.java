package show.trom.mod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import show.trom.mod.init.TromEntities;
import show.trom.mod.init.TromItem;
import show.trom.mod.init.TromTab;

@Mod(TromMod.MOD_ID)
public class TromMod {
    public static final String MOD_ID = "trom";

    public TromMod() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        TromItem.ITEMS.register(modbus);
        TromTab.TABS.register(modbus);
        TromEntities.REGISTRY.register(modbus);
    }
}


