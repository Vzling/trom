package show.trom.mod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import show.trom.mod.init.TromItem;

public abstract class RoseGoldArmor extends ArmorItem {
    public RoseGoldArmor(Type type, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type type) {
                return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 7;
            }

            public int getDefenseForType(Type type) {
                return new int[]{1, 3, 5, 2}[type.getSlot().getIndex()];
            }

            public int getEnchantmentValue() {
                return 27;
            }

            public SoundEvent getEquipSound() {
                return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_gold"));
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(TromItem.ROSE_GOLD_INGOT.get()));
            }

            public String getName() {
                return "rose_gold";
            }

            public float getToughness() {
                return 4.5f;
            }

            public float getKnockbackResistance() {
                return 0f;
            }
        }, type, properties);
    }

    public static class Helmet extends RoseGoldArmor {
        public Helmet() {
            super(Type.HELMET, new Properties().fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/rose_gold_layer_1.png";
        }

        @Override
        public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
            return true;
        }
    }

    public static class Chestplate extends RoseGoldArmor {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties().fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/rose_gold_layer_1.png";
        }

        @Override
        public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
            return true;
        }
    }

    public static class Leggings extends RoseGoldArmor {
        public Leggings() {
            super(Type.LEGGINGS, new Properties().fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/rose_gold_layer_2.png";
        }

        @Override
        public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
            return true;
        }
    }

    public static class Boots extends RoseGoldArmor {
        public Boots() {
            super(Type.BOOTS, new Properties().fireResistant());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/rose_gold_layer_1.png";
        }

        @Override
        public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
            return true;
        }

    }
}
