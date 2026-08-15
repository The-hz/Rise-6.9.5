package com.alan.clients.module.impl.movement.terrainspeed;

public final class PhysicsIntegrator {
    public PhysicsVector3 SU = new PhysicsVector3(0.0, 0.0, 0.0);
    public PhysicsVector3 SV = new PhysicsVector3(0.0, 0.0, 0.0);
    public PhysicsVector3 SW = new PhysicsVector3(0.0, 0.0, 0.0);
    PhysicsVector3 SX = new PhysicsVector3(0.0, -10.0, 0.0);
    double SY = 2.0;
    double SZ = 1.0;

    public PhysicsIntegrator() {
    }

    public PhysicsVector3 hI() {
        double d0 = 1.0 / this.SZ;
        this.SV.scale(d0);
        this.SV.add(this.SX).scale(this.SY);
        this.SU.scale(d0);
        this.SV.scale(0.03333333333333333);
        this.SU.add(this.SV);
        this.SW.add(this.SU);
        this.SV.set(0.0, 0.0, 0.0);
        this.SU.set(0.0, 0.0, 0.0);
        return this.SW;
    }
}
