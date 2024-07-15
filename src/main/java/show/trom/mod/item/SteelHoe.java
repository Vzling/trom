package show.trom.mod.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import show.trom.mod.init.TromItem;

public class SteelHoe extends HoeItem {
    public SteelHoe() {
        super(new Tier() {
            public int getUses() {
                return 652;
            }

            public float getSpeed() {
                return 6f;
            }

            public float getAttackDamageBonus() {
                return 1.5f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 12;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(TromItem.STEEL_INGOT.get()));
            }
        }, 1, -2.2f, new Properties());
    }
}
