package hackclient.rise;

import com.alan.clients.util.vector.Vector2f;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;

public class hh {
    public final adz<Tuple<Vector2f, aka>> rh = new adz<>(10);

    public hh() {
    }

    public void a(Vector2f var1, aka var2, int var3) {
        if (var3 >= this.rh.size()) {
            for (int i = 0; i < var3 - this.rh.size(); i++) {
                this.rh.add(null);
            }

            this.rh.add(new Tuple<>(var1, var2));
        }
    }

    public Vector2f gy() {
        Minecraft minecraft = Minecraft.getMinecraft();
        Tuple tuple = this.rh.getFirst();
        this.rh.removeFirst();
        Vector2f vector2f = (Vector2f)tuple.getFirst();
        aka aka = (aka)tuple.getSecond();
        double d0 = Math.hypot(aka.getX(), aka.getZ());
        float f = (float)(MathHelper.atan2(aka.getZ(), aka.getX()) * 180.0F / (float)Math.PI) - 90.0F;
        float f1 = (float)(-(MathHelper.atan2(aka.getY(), d0) * 180.0F / (float)Math.PI));
        Vector2f vector2f1 = new Vector2f(f, f1);
        Vector2f vector2f2 = new Vector2f(vector2f1.getX() + vector2f.getX(), MathHelper.clamp_float(vector2f1.getY(), -90.0F, 90.0F));
        return new Vector2f(MathHelper.wrapAngleTo180_float(vector2f2.getX() - minecraft.thePlayer.pl), vector2f2.getY() - minecraft.thePlayer.rotationPitch);
    }
}
