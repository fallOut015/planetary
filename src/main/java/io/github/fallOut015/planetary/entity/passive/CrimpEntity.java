package io.github.fallOut015.planetary.entity.passive;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class CrimpEntity extends CreatureEntity {
    private static final DataParameter<Boolean> CURLING = EntityDataManager.defineId(CrimpEntity.class, DataSerializers.BOOLEAN);

    public CrimpEntity(EntityType<? extends CrimpEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, AbstractPiglinEntity.class, 10.0F, 2.0D, 3.0D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 1.0000001E-5F));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 10.0F));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(CURLING, false);
    }

    public static AttributeModifierMap.MutableAttribute applyAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.15F).add(Attributes.MAX_HEALTH, 10.0D);
    }

    public void setCurling(boolean value) {
        this.entityData.set(CURLING, value);
    }
    public boolean isCurling() {
        return this.entityData.get(CURLING).booleanValue();
    }

    @Override
    public boolean isOnFire() {
        return false;
    }
}