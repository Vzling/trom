package show.trom.mod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class CopperArmor extends ArmorItem {
    public CopperArmor(Type type, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type type) {
                return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 10;
            }

            public int getDefenseForType(Type type) {
                return new int[]{2, 5, 6, 2}[type.getSlot().getIndex()];
            }

            public int getEnchantmentValue() {
                return 15;
            }

            public SoundEvent getEquipSound() {
                return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(Items.COPPER_INGOT));
            }

            public String getName() {
                return "copper";
            }

            public float getToughness() {
                return 0f;
            }

            public float getKnockbackResistance() {
                return 0f;
            }
        }, type, properties);
    }

    public static class Helmet extends CopperArmor {
        public Helmet() {
            super(Type.HELMET, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/copper_layer_1.png";
        }
    }

    public static class Chestplate extends CopperArmor {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/copper_layer_1.png";
        }
    }

    public static class Leggings extends CopperArmor {
        public Leggings() {
            super(Type.LEGGINGS, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/copper_layer_2.png";
        }
    }

    public static class Boots extends CopperArmor {
        public Boots() {
            super(Type.BOOTS, new Properties());
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "trom:textures/models/armor/copper_layer_1.png";
        }
    }
}
