package hackclient.rise;

import com.alan.clients.util.vector.Vector2f;

public final class sg {
    akb VM;
    ajz VN;

    public sg(aka var1, Vector2f vec2) {
        this.VM = new akb((int)var1.x, (int)var1.y, (int)var1.z);
        this.VN = new ajz((int)(vec2.getX() / 15.0F), (int)(vec2.getY() / 20.0F));
    }

    public String hM() {
        return this.VM.ald + " " + this.VM.ale + " " + this.VM.aQE + " " + this.VN.ald + " " + this.VN.ale;
    }
}
