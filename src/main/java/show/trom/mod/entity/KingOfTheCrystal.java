package show.trom.mod.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import show.trom.mod.entity.phase.BehaviourManager;
import show.trom.mod.entity.phase.MeleeAttackPhase;
import show.trom.mod.entity.phase.MultiBehaviourUser;
import show.trom.mod.init.TromItem;

import java.util.List;

public class KingOfTheCrystal extends Monster implements MultiBehaviourUser {
    protected static final EntityDataAccessor<Integer> BEHAVIOUR_STATE = SynchedEntityData.defineId(KingOfTheCrystal.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> BEHAVIOUR_TICKS = SynchedEntityData.defineId(KingOfTheCrystal.class, EntityDataSerializers.INT);
    private static final int MELEE_ID = 1;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState meleeAnimationState = new AnimationState();
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.PINK, ServerBossEvent.BossBarOverlay.PROGRESS);
    private final BehaviourManager<KingOfTheCrystal> behaviourManager = new BehaviourManager<>(this, List.of(
            new MeleeAttackPhase<KingOfTheCrystal>(MELEE_ID, 1, 30, 30).with(2, 12)
    ));

    public KingOfTheCrystal(EntityType<KingOfTheCrystal> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 0;
        setPersistenceRequired();
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TromItem.PURPLE_CRYSTAL_SWORD.get()));
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 250);
        builder = builder.add(Attributes.ARMOR, 20);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
        builder = builder.add(Attributes.FOLLOW_RANGE, 64);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.3);
        return builder;
    }

    public int getBehaviourState() {
        return entityData.get(BEHAVIOUR_STATE);
    }

    public void setBehaviourState(int attackState) {
        entityData.set(BEHAVIOUR_STATE, attackState);
    }

    public int getBehaviourTicks() {
        return entityData.get(BEHAVIOUR_TICKS);
    }

    public void setBehaviourTicks(int behaviourTicks) {
        entityData.set(BEHAVIOUR_TICKS, behaviourTicks);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BEHAVIOUR_STATE, 0);
        this.entityData.define(BEHAVIOUR_TICKS, 0);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        if (accessor.equals(BEHAVIOUR_STATE) && getBehaviourState() != 0) {
            if (getBehaviourState() == MELEE_ID) {
                meleeAnimationState.start(tickCount);
            } else {
                meleeAnimationState.stop();
            }
        }
        super.onSyncedDataUpdated(accessor);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 15.0F, 1.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public double getMyRidingOffset() {
        return -0.35D;
    }

    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.ambient"));
    }

    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.break"));
    }

    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.death"));
    }

    public boolean hurt(DamageSource damagesource, float amount) {
        if (damagesource.is(DamageTypes.FALL))
            return false;
        if (damagesource.is(DamageTypes.IN_FIRE))
            return false;
        if (damagesource.is(DamageTypes.ON_FIRE))
            return false;
        return super.hurt(damagesource, amount);
    }

    public boolean canChangeDimensions() {
        return false;
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        if (!isNoAi()) {
            this.behaviourManager.tick();
        }
    }

    @Override
    public void tick() {
        super.tick();
        idleAnimationState.startIfStopped(this.tickCount);
    }
}
