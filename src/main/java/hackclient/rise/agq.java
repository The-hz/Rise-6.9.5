package hackclient.rise;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

class agq implements InputMethodListener {
    final agp aJF;

    agq(agp var1) {
        this.aJF = var1;
    }

    public void b(InputMethodEvent event) {
        try {
            this.aJF.a(event);
        } finally {
            event.consume();
        }
    }

    public void c(InputMethodEvent event) {
    }
    public void inputMethodTextChanged(InputMethodEvent event) { }
    public void caretPositionChanged(InputMethodEvent event) { }

}
