package show.trom.mod.item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import show.trom.mod.init.TromItem;

public class CelestiteHoe extends HoeItem {
    public CelestiteHoe() {
        super(new Tier() {
            public int getUses() {
                return 1752;
            }

            public float getSpeed() {
                return 9f;
            }

            public float getAttackDamageBonus() {
                return 2.5f;
            }

            public int getLevel() {
                return 3;
            }

            public int getEnchantmentValue() {
                return 14;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(TromItem.STEEL_INGOT.get());
            }
        }, 1, -2.1f, new Properties());
    }
}
