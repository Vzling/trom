package show.trom.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import show.trom.mod.init.TromItem;

public class PurpleCrystalSword extends SwordItem {
    public PurpleCrystalSword() {
        super(new Tier() {
            public int getUses() {
                return 3764;
            }

            public float getSpeed() {
                return 9f;
            }

            public float getAttackDamageBonus() {
                return 6f;
            }

            public int getLevel() {
                return 3;
            }

            public int getEnchantmentValue() {
                return 16;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(TromItem.PURPLE_CRYSTAL_SHARD.get()));
            }
        }, 1, -2.3f, new Item.Properties());
    }
}
