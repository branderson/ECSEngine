package com.brad.AshleyTest.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.physics.box2d.World;
import com.brad.AshleyTest.ecs.Constants;
import com.brad.AshleyTest.ecs.basesystems.IteratingLogicSystem;
import com.brad.AshleyTest.ecs.components.DynamicBodyComponent;
import com.brad.AshleyTest.ecs.components.KinematicBodyComponent;
import com.brad.AshleyTest.ecs.components.StaticBodyComponent;
import com.brad.AshleyTest.ecs.components.TransformComponent;

/**
 * TODO: Add a class header comment!
 */
public class PhysicsSystem extends IteratingLogicSystem
{
    World world;

    public PhysicsSystem(World world) {
        super(Family.all(TransformComponent.class).one(DynamicBodyComponent.class, StaticBodyComponent.class, KinematicBodyComponent.class).get(), Constants.TPS);
        this.world = world;
    }

    @Override
    protected void updateInterval() {
        super.updateInterval();
        world.step(1 / Constants.TPS, 8, 3);
    }

    @Override
    protected void processEntity(Entity entity) {

    }
}