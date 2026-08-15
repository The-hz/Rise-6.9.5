package hackclient.rise;

import java.awt.Canvas;
import java.awt.Window;
import java.awt.im.InputMethodRequests;

class agr extends Canvas {
    private final InputMethodRequests aJG;
    final Window aJH;
    final agp aJI;

    agr(agp var1, Window window) {
        this.aJI = var1;
        this.aJH = window;
        this.aJG = new ags(this);
    }

    public InputMethodRequests uj() {
        return this.aJG;
    }
}
