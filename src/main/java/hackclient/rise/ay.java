package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;

public class ay extends Component {
    private int worldChanges;
    @EventLink
    public final Listener<WorldChangeEvent> onWorldChange = var1 -> this.worldChanges++;
    @EventLink
    public final Listener<ServerJoinEvent> onServerJoin = var1 -> this.worldChanges = 0;

    public ay() {
    }

    public boolean hasChangedWorlds() {
        return this.worldChanges > 0;
    }
}
