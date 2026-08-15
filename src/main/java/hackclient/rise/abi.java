package hackclient.rise;

import com.alan.clients.ui.click.standard.components.popup.PopUp;
import com.alan.clients.util.vector.Vector2f;

public class abi extends PopUp {
    public abi() {
    }

    @Override
    public void draw() {
        this.scale = new Vector2f(200.0F, 120.0F);
        super.draw();
    }
}
