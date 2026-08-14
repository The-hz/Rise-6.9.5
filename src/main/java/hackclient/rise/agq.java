package hackclient.rise;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

class agq implements InputMethodListener {
    final agp aJF;

    agq(agp var1) {
        this.aJF = var1;
    }

    public void b(InputMethodEvent var1) {
        try {
            this.aJF.a(var1);
        } finally {
            var1.consume();
        }
    }

    public void c(InputMethodEvent var1) {
    }
    public void inputMethodTextChanged(InputMethodEvent var1) { }
    public void caretPositionChanged(InputMethodEvent var1) { }

}
