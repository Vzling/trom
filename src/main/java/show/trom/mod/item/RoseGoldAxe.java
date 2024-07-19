package show.trom.mod.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import show.trom.mod.init.TromItem;

public class RoseGoldAxe extends AxeItem {
    public RoseGoldAxe() {
        super(new Tier() {
            public int getUses() {
                return 256;
            }

            public float getSpeed() {
                return 13f;
            }

            public float getAttackDamageBonus() {
                return 5.5f;
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
        }, 1, -2.8f, new Properties());
    }
}
