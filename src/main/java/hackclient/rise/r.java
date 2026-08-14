package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.WorldChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.entity.Entity;

public class r {
    private final HashMap<Object, ArrayList<Integer>> bn = new HashMap<>();
    @EventLink
    public final Listener<WorldChangeEvent> bo = var1 -> this.clear();

    public r() {
    }

    public void init() {
        Client.a.e().b(this);
    }

    public boolean a(Entity var1) {
        Iterator iterator = this.bn.values().iterator();

        while (iterator.hasNext()) {
            if (((ArrayList)iterator.next()).contains(var1.getEntityId())) {
                return true;
            }
        }

        return false;
    }

    public boolean a(Object var1, Entity var2) {
        return !this.bn.containsKey(var1) ? false : this.bn.get(var1).contains(var2.getEntityId());
    }

    public void b(Object var1, Entity var2) {
        int i = var2.getEntityId();
        if (!this.bn.containsKey(var1)) {
            this.bn.put(var1, new ArrayList<>());
        }

        ArrayList arraylist = this.bn.get(var1);
        if (!arraylist.contains(i)) {
            arraylist.add(i);
        }
    }

    public void c(Object var1, Entity var2) {
        if (this.bn.containsKey(var1)) {
            this.bn.get(var1).remove(Integer.valueOf(var2.getEntityId()));
        }
    }

    public void clear() {
        this.bn.clear();
    }

    public void a(Object var1) {
        if (this.bn.containsKey(var1)) {
            this.bn.get(var1).clear();
        }
    }
}
