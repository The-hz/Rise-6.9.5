package hackclient.rise;

import java.util.Collection;

public class sx<T> extends adz<T> implements Cloneable {
    public sx(int var1) {
        super(var1);
    }

    public sx(Collection<? extends T> var1, int var2) {
        super(var1, var2);
    }

    public sx(sx<? extends T> var1) {
        super(var1, var1.rS());
    }

    public T jq() {
        return this.getLast();
    }

    @Override
    public T get(int var1) {
        return super.get(this.size() - var1 - 1);
    }

    public sx<T> jr() {
        return (sx<T>)super.clone();
    }

    @Override
    public Object clone() {
        return this.jr();
    }
}
