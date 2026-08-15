package rip.vantage.commons.packet.impl.client.protection;

import java.awt.geom.Dimension2D;
import org.apache.batik.swing.JSVGCanvas;

public class AltSkin {
    private final String eOQ;

    public AltSkin(String var1) {
        this.eOQ = var1;
    }

    public Dimension2D getSize() {
        if (this.eOQ == null) {
            return null;
        }

        JSVGCanvas jsvgcanvas = new JSVGCanvas();
        jsvgcanvas.loadSVGDocument(this.eOQ);
        return jsvgcanvas.getSVGDocumentSize();
    }

    @Override
    public String toString() {
        Dimension2D dimension2d = this.getSize();
        return "[" + dimension2d.getWidth() + ", " + dimension2d.getHeight() + "]";
    }
}
