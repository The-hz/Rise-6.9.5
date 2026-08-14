package hackclient.rise;

import java.awt.Rectangle;
import java.awt.font.TextHitInfo;
import java.awt.im.InputMethodRequests;
import java.text.AttributedCharacterIterator.Attribute;
import java.text.AttributedCharacterIterator;

class ags implements InputMethodRequests {
    final agr aJJ;

    ags(agr var1) {
        this.aJJ = var1;
    }

    public Rectangle a(TextHitInfo var1) {
        return new Rectangle(this.aJJ.aJH.getX(), this.aJJ.aJH.getY(), 1, Math.max(1, this.aJJ.aJI.aJC));
    }

    public TextHitInfo n(int var1, int var2) {
        return null;
    }

    public int uk() {
        return 0;
    }

    public AttributedCharacterIterator a(int var1, int var2, Attribute[] var3) {
        return null;
    }

    public int ul() {
        return 0;
    }

    public AttributedCharacterIterator a(Attribute[] var1) {
        return null;
    }

    public AttributedCharacterIterator b(Attribute[] var1) {
        return null;
    }
    public java.awt.Rectangle getTextLocation(java.awt.font.TextHitInfo var1) { return null; }
    public java.awt.font.TextHitInfo getLocationOffset(int var1, int var2) { return null; }
    public int getInsertPositionOffset() { return 0; }
    public java.text.AttributedCharacterIterator getCommittedText(int var1, int var2, java.text.AttributedCharacterIterator.Attribute[] var3) { return null; }
    public int getCommittedTextLength() { return 0; }
    public java.text.AttributedCharacterIterator cancelLatestCommittedText(java.text.AttributedCharacterIterator.Attribute[] var1) { return null; }
    public java.text.AttributedCharacterIterator getSelectedText(java.text.AttributedCharacterIterator.Attribute[] var1) { return null; }
}
