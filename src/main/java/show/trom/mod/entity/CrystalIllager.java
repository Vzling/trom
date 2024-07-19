package show.trom.mod.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import show.trom.mod.entity.phase.BehaviourManager;
import show.trom.mod.entity.phase.MeleeAttackPhase;
import show.trom.mod.entity.phase.MultiBehaviourUser;

import java.util.List;

public class CrystalIllager extends Monster implements MultiBehaviourUser {
    protected static final EntityDataAccessor<Integer> BEHAVIOUR_STATE = SynchedEntityData.defineId(CrystalIllager.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> BEHAVIOUR_TICKS = SynchedEntityData.defineId(CrystalIllager.class, EntityDataSerializers.INT);
    private static final int MELEE_ID = 1;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState meleeAnimationState = new AnimationState();
    private final BehaviourManager<CrystalIllager> behaviourManager = new BehaviourManager<>(this, List.of(
            new MeleeAttackPhase<CrystalIllager>(MELEE_ID, 1, 30, 30).with(2, 12)
    ));

    public CrystalIllager(EntityType<CrystalIllager> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 0;
        setPersistenceRequired();
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
        builder = builder.add(Attributes.MAX_HEALTH, 25);
        builder = builder.add(Attributes.ARMOR, 5);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
        builder = builder.add(Attributes.FOLLOW_RANGE, 64);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
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
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    public MobType getMobType() {
        return MobType.ILLAGER;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public double getMyRidingOffset() {
        return -0.35D;
    }

    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pillager.ambient"));
    }

    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pillager.hurt"));
    }

    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pillager.death"));
    }

    public boolean canChangeDimensions() {
        return false;
    }

    public void customServerAiStep() {
        super.customServerAiStep();
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
