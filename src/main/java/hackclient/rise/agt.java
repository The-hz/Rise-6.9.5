package hackclient.rise;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

class agt implements InputMethodListener {
    final agp aJK;

    agt(agp var1) {
        this.aJK = var1;
    }

    public void b(InputMethodEvent event) {
        try {
            this.aJK.a(event);
        } finally {
            event.consume();
        }
    }

    public void c(InputMethodEvent event) {
    }
    public void inputMethodTextChanged(InputMethodEvent event) { }
    public void caretPositionChanged(InputMethodEvent event) { }

}
