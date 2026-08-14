package hackclient.rise;

import com.alan.clients.component.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class ce extends Component {
    public static HashMap<String, String[]> hb = new HashMap<>();

    public ce() {
    }

    public static void cg() {
        Iterator iterator = bf.dc.entrySet().iterator();

        while (iterator.hasNext()) {
            by by = (by)((Entry)iterator.next()).getValue();
            if (by.bT() && by.bZ() != null) {
                by.j(by.cb() + 1);
                if (by.cb() >= by.bZ().length) {
                    by.j(0);
                }
            }
        }
    }

    public static void ch() {
        if (!hb.isEmpty()) {
            for (Entry entry : hb.entrySet()) {
                String s = (String)entry.getKey();
                String[] astring = (String[])entry.getValue();
                by by = bf.dc.get(s);
                ResourceLocation[] aresourcelocation = new ResourceLocation[astring.length];
                if (!by.ca()) {
                    by.e(true);

                    for (int i = 0; i < astring.length; i++) {
                        int j = i;
                        String s1 = astring[i];
                        ResourceLocation resourcelocation = new ResourceLocation("capes/" + s + "/" + j);
                        TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
                        new Thread(() -> {
                            try {
                                Thread.sleep(100L);
                                ThreadDownloadImageData threaddownloadimagedata = new ThreadDownloadImageData(null, s1, null, null);
                                texturemanager.loadTexture(resourcelocation, threaddownloadimagedata);
                                aresourcelocation[j] = resourcelocation;
                            } catch (InterruptedException interruptedexception) {
                                interruptedexception.printStackTrace();
                            }
                        }).start();
                    }

                    by.a(aresourcelocation);
                    hb.remove(s);
                }
            }
        }
    }
}
