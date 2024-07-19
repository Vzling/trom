package show.trom.mod.item;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import show.trom.mod.init.TromItem;

public class RoseGoldShovel extends ShovelItem {
    public RoseGoldShovel() {
        super(new Tier() {
            public int getUses() {
                return 256;
            }

            public float getSpeed() {
                return 13f;
            }

            public float getAttackDamageBonus() {
                return 0.5f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 22;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(TromItem.ROSE_GOLD_INGOT.get());
            }
        }, 1, -2f, new Properties());
    }
}
