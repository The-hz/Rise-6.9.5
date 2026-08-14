package hackclient.rise;

import com.alan.clients.component.Component;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.ServerJoinEvent;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;

public class ay extends Component {
    private int cC;
    @EventLink
    public final Listener<WorldChangeEvent> cD = var1 -> this.cC++;
    @EventLink
    public final Listener<ServerJoinEvent> cE = var1 -> this.cC = 0;

    public ay() {
    }

    public boolean aV() {
        return this.cC > 0;
    }
}
