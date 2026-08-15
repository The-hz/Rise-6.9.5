package com.alan.clients.module.impl.other.sampler;

import com.alan.clients.util.vector.Vector2f;
import com.alan.clients.util.vector.Vector2i;
import com.alan.clients.util.vector.Vector3i;
import hackclient.rise.aka;

public final class SampleKey {
    Vector3i VM;
    Vector2i VN;

    public SampleKey(aka var1, Vector2f vec2) {
        this.VM = new Vector3i((int)var1.x, (int)var1.y, (int)var1.z);
        this.VN = new Vector2i((int)(vec2.getX() / 15.0F), (int)(vec2.getY() / 20.0F));
    }

    public String hM() {
        return this.VM.ald + " " + this.VM.ale + " " + this.VM.aQE + " " + this.VN.ald + " " + this.VN.ale;
    }
}
