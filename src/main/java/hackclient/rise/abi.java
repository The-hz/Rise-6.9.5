package hackclient.rise;

import com.alan.clients.util.vector.Vector2f;

public class abi extends abh {
    public abi() {
    }

    @Override
    public void draw() {
        this.scale = new Vector2f(200.0F, 120.0F);
        super.draw();
    }
}
