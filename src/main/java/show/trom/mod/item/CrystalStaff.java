package show.trom.mod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CrystalStaff extends Item {
    public CrystalStaff() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        player.startUsingItem(interactionHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int time) {
        DragonFireball dragonFireball = new DragonFireball(level, livingEntity, 0, 0, 0);
        dragonFireball.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot(), 5.0F, 4F, 0.0F);
        if (livingEntity instanceof Player player1) {
            player1.getCooldowns().addCooldown(itemStack.getItem(), 60);
            level.playSound(player1, dragonFireball, SoundEvents.ENDER_DRAGON_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        level.addFreshEntity(dragonFireball);
        super.releaseUsing(itemStack, level, livingEntity, time);
    }
}
