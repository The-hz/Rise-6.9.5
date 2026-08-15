package hackclient.rise;

import com.alan.clients.newevent.CancellableEvent;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;

public final class ff extends CancellableEvent {
    private final EntityPlayer jP;
    private final ModelBiped jQ;

    public ff(EntityPlayer player, ModelBiped modelBiped) {
        this.jP = player;
        this.jQ = modelBiped;
    }

    public EntityPlayer do_() {
        return this.jP;
    }

    public ModelBiped dp() {
        return this.jQ;
    }
}
