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
import show.trom.mod.entity.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TromEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TromMod.MOD_ID);
    public static final RegistryObject<EntityType<KingOfTheCrystal>> KING_OF_THE_CRYSTAL =
            REGISTRY.register("king_of_the_crystal", () -> EntityType.Builder.of(KingOfTheCrystal::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.8f)
                    .build(new ResourceLocation(TromMod.MOD_ID, "king_of_the_crystal").toString()));
    public static final RegistryObject<EntityType<PurpleCrystalBrick>> PURPLE_CRYSTAL_BRICK =
            REGISTRY.register("purple_crystal_brick", () -> EntityType.Builder.of(PurpleCrystalBrick::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.8f)
                    .build(new ResourceLocation(TromMod.MOD_ID, "purple_crystal_brick").toString()));
    public static final RegistryObject<EntityType<CrystalZombie>> CRYSTAL_ZOMBIE =
            REGISTRY.register("crystal_zombie", () -> EntityType.Builder.of(CrystalZombie::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.8f)
                    .build(new ResourceLocation(TromMod.MOD_ID, "crystal_zombie").toString()));
    public static final RegistryObject<EntityType<CrystalSkeleton>> CRYSTAL_SKELETON =
            REGISTRY.register("crystal_skeleton", () -> EntityType.Builder.of(CrystalSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.8f)
                    .build(new ResourceLocation(TromMod.MOD_ID, "crystal_skeleton").toString()));
    public static final RegistryObject<EntityType<CrystalIllager>> CRYSTAL_ILLAGER =
            REGISTRY.register("crystal_illager", () -> EntityType.Builder.of(CrystalIllager::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.8f)
                    .build(new ResourceLocation(TromMod.MOD_ID, "crystal_illager").toString()));

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(KING_OF_THE_CRYSTAL.get(), KingOfTheCrystal.createAttributes().build());
        event.put(PURPLE_CRYSTAL_BRICK.get(), PurpleCrystalBrick.createAttributes().build());
        event.put(CRYSTAL_ZOMBIE.get(), CrystalZombie.createAttributes().build());
        event.put(CRYSTAL_SKELETON.get(), CrystalSkeleton.createAttributes().build());
        event.put(CRYSTAL_ILLAGER.get(), CrystalIllager.createAttributes().build());
    }
}
