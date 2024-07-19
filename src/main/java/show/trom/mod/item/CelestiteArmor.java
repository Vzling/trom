package show.trom.mod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import show.trom.mod.init.TromItem;

public abstract class CelestiteArmor extends ArmorItem {
    public CelestiteArmor(Type type, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type type) {
                return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 37;
            }

            public int getDefenseForType(Type type) {
                return new int[]{3, 8, 7, 3}[type.getSlot().getIndex()];
            }

            public int getEnchantmentValue() {
                return 14;
            }

            public SoundEvent getEquipSound() {
                return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(TromItem.CELESTITE_CRYSTAL.get());
            }

            public String getName() {
                return "celestite";
            }

            public float getToughness() {
                return 2.5f;
            }

            public float getKnockbackResistance() {
                return 0.1f;
            }
        }, type, properties);
    }

    public static class Helmet extends CelestiteArmor {
        public Helmet() {
            super(Type.HELMET, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/celestite_layer_1.png";
        }
    }

    public static class Chestplate extends CelestiteArmor {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/celestite_layer_1.png";
        }
    }

    public static class Leggings extends CelestiteArmor {
        public Leggings() {
            super(Type.LEGGINGS, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/celestite_layer_2.png";
        }
    }

    public static class Boots extends CelestiteArmor {
        public Boots() {
            super(Type.BOOTS, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/celestite_layer_1.png";
        }
    }
}
