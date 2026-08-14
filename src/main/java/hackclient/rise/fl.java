package hackclient.rise;

import com.alan.clients.newevent.Event;

public final class fl implements Event {
    private final int width;
    private final int height;

    public fl(int var1, int var2) {
        this.width = var1;
        this.height = var2;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
