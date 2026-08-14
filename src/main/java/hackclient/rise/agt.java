package hackclient.rise;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

class agt implements InputMethodListener {
    final agp aJK;

    agt(agp var1) {
        this.aJK = var1;
    }

    public void b(InputMethodEvent var1) {
        try {
            this.aJK.a(var1);
        } finally {
            var1.consume();
        }
    }

    public void c(InputMethodEvent var1) {
    }
    public void inputMethodTextChanged(InputMethodEvent var1) { }
    public void caretPositionChanged(InputMethodEvent var1) { }

}
