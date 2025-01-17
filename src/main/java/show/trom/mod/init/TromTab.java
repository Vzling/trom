package show.trom.mod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import show.trom.mod.TromMod;

public class TromTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TromMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("item", () -> CreativeModeTab.builder()
            .title(Component.translatable("ItemGroup.trom.item"))
            .icon(() -> new ItemStack(TromItem.DEEPSLATE_WITH_PURPLE_CRYSTAL_SHARD.get()))
            .displayItems((parameters, output) -> {
                output.accept(TromItem.DEEPSLATE_WITH_PURPLE_CRYSTAL_SHARD.get());
                output.accept(TromItem.PURPLE_CRYSTAL_SHARD.get());
                output.accept(TromItem.CELESTITE_CRYSTAL.get());
                output.accept(TromItem.ROSE_GOLD_INGOT.get());
                output.accept(TromItem.ROSE_GOLD_NUGGET.get());
                output.accept(TromItem.ROSE_GOLD_DUST.get());
                output.accept(TromItem.COPPER_GEAR.get());
                output.accept(TromItem.COPPER_NUGGET.get());
                output.accept(TromItem.STEEL_PIPE.get());
                output.accept(TromItem.STEEL_PLATE.get());
                output.accept(TromItem.STEEL_INGOT.get());
                output.accept(TromItem.STEEL_NUGGET.get());
                output.accept(TromItem.STEEL_DUST.get());
                output.accept(TromItem.PURPLE_CRYSTAL_SWORD.get());
                output.accept(TromItem.PURPLE_CRYSTAL_HAMMER.get());
                output.accept(TromItem.CRYSTAL_STAFF.get());
                output.accept(TromItem.ROSE_GOLD_SWORD.get());
                output.accept(TromItem.ROSE_GOLD_PICKAXE.get());
                output.accept(TromItem.ROSE_GOLD_AXE.get());
                output.accept(TromItem.ROSE_GOLD_SHOVEL.get());
                output.accept(TromItem.ROSE_GOLD_HOE.get());
                output.accept(TromItem.STEEL_SWORD.get());
                output.accept(TromItem.STEEL_PICKAXE.get());
                output.accept(TromItem.STEEL_AXE.get());
                output.accept(TromItem.STEEL_SHOVEL.get());
                output.accept(TromItem.STEEL_HOE.get());
                output.accept(TromItem.CELESTITE_SWORD.get());
                output.accept(TromItem.CELESTITE_PICKAXE.get());
                output.accept(TromItem.CELESTITE_AXE.get());
                output.accept(TromItem.CELESTITE_SHOVEL.get());
                output.accept(TromItem.CELESTITE_HOE.get());
                output.accept(TromItem.COPPER_HELMET.get());
                output.accept(TromItem.COPPER_CHESTPLATE.get());
                output.accept(TromItem.COPPER_LEGGINGS.get());
                output.accept(TromItem.COPPER_BOOTS.get());
                output.accept(TromItem.ROSE_GOLD_CROWN.get());
                output.accept(TromItem.ROSE_GOLD_CHESTPLATE.get());
                output.accept(TromItem.ROSE_GOLD_LEGGINGS.get());
                output.accept(TromItem.ROSE_GOLD_BOOTS.get());
                output.accept(TromItem.STEEL_HELMET.get());
                output.accept(TromItem.STEEL_CHESTPLATE.get());
                output.accept(TromItem.STEEL_LEGGINGS.get());
                output.accept(TromItem.STEEL_BOOTS.get());
                output.accept(TromItem.CELESTITE_HELMET.get());
                output.accept(TromItem.CELESTITE_CHESTPLATE.get());
                output.accept(TromItem.CELESTITE_LEGGINGS.get());
                output.accept(TromItem.CELESTITE_BOOTS.get());
                output.accept(TromItem.KING_OF_THE_CRYSTAL_SPAWN_EGG.get());
                output.accept(TromItem.CRYSTAL_ZOMBIE_SPAWN_EGG.get());
                output.accept(TromItem.CRYSTAL_SKELETON_SPAWN_EGG.get());
                output.accept(TromItem.CRYSTAL_ILLAGER_SPAWN_EGG.get());
                output.accept(TromItem.PURPLE_CRYSTAL_BRICK_SPAWN_EGG.get());

            }).build());
}
