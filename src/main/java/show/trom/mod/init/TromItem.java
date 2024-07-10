package show.trom.mod.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import show.trom.mod.TromMod;
import show.trom.mod.item.*;

public class TromItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TromMod.MOD_ID);
    public static final RegistryObject<Item> DEEPSLATE_WITH_PURPLE_CRYSTAL_SHARD = ITEMS.register("deepslate_with_purple_crystal_shard", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PURPLE_CRYSTAL_SHARD = ITEMS.register("purple_crystal_shard", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PURPLE_CRYSTAL_SWORD = ITEMS.register("purple_crystal_sword", PurpleCrystalSword::new);
    public static final RegistryObject<Item> PURPLE_CRYSTAL_HAMMER = ITEMS.register("purple_crystal_hammer", PurpleCrystalHammer::new);
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", CopperArmor.Helmet::new);
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", CopperArmor.Chestplate::new);
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", CopperArmor.Leggings::new);
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", CopperArmor.Boots::new);
    public static final RegistryObject<Item> ROSE_GOLD_INGOT = ITEMS.register("rose_gold_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_CROWN = ITEMS.register("rose_gold_crown", RoseGoldArmor.Helmet::new);
    public static final RegistryObject<Item> ROSE_GOLD_CHESTPLATE = ITEMS.register("rose_gold_chestplate", RoseGoldArmor.Chestplate::new);
    public static final RegistryObject<Item> ROSE_GOLD_LEGGINGS = ITEMS.register("rose_gold_leggings", RoseGoldArmor.Leggings::new);
    public static final RegistryObject<Item> ROSE_GOLD_BOOTS = ITEMS.register("rose_gold_boots", RoseGoldArmor.Boots::new);
    public static final RegistryObject<Item> ROSE_GOLD_NUGGET = ITEMS.register("rose_gold_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_GEAR = ITEMS.register("copper_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PIPE = ITEMS.register("steel_pipe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HOLY_STEEL_PIPE = ITEMS.register("holy_steel_pipe", () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", SteelArmor.Helmet::new);
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", SteelArmor.Chestplate::new);
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", SteelArmor.Leggings::new);
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", SteelArmor.Boots::new);
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_DUST = ITEMS.register("rose_gold_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KING_OF_THE_CRYSTAL_SPAWN_EGG = ITEMS.register("king_of_the_crystal_spawn_egg", () -> new ForgeSpawnEggItem(TromEntities.KING_OF_THE_CRYSTAL, -13421773, -10092442, new Item.Properties()));


}