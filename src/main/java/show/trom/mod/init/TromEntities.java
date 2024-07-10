package show.trom.mod.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import show.trom.mod.TromMod;
import show.trom.mod.entity.KingOfTheCrystal;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TromEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TromMod.MOD_ID);
    public static final RegistryObject<EntityType<KingOfTheCrystal>> KING_OF_THE_CRYSTAL =
            REGISTRY.register("king_of_the_crystal", () -> EntityType.Builder.of(KingOfTheCrystal::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.8f)
                    .build(new ResourceLocation(TromMod.MOD_ID, "king_of_the_crystal").toString()));

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(KING_OF_THE_CRYSTAL.get(), KingOfTheCrystal.createAttributes().build());
    }
}
