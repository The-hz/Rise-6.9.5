package hackclient.rise;

import com.alan.clients.newevent.Event;

public final class fl implements Event {
    private final int width;
    private final int height;

    public fl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
