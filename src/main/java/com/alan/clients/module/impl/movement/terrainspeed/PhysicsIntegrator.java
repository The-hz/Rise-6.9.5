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
        this.SV.p(d0);
        this.SV.a(this.SX).p(this.SY);
        this.SU.p(d0);
        this.SV.p(0.03333333333333333);
        this.SU.a(this.SV);
        this.SW.a(this.SU);
        this.SV.d(0.0, 0.0, 0.0);
        this.SU.d(0.0, 0.0, 0.0);
        return this.SW;
    }
}
