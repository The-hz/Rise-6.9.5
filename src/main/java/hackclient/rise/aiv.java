package hackclient.rise;

import com.alan.clients.util.shader.impl.AlphaShader;
import com.alan.clients.util.shader.impl.MainMenuBackgroundShader;
import com.alan.clients.util.shader.impl.OutlineShader;
import com.alan.clients.util.shader.impl.RGQShader;
import com.alan.clients.util.shader.impl.RGQTestShader;
import com.alan.clients.util.shader.impl.ROGQShader;
import com.alan.clients.util.shader.impl.ROQShader;
import com.alan.clients.util.shader.impl.BAWShader;
import com.alan.clients.util.shader.impl.BloomShader;
import com.alan.clients.util.shader.impl.GaussianBlurShader;
import com.alan.clients.util.shader.impl.RQShader;
import com.alan.clients.util.shader.impl.TriRGQShader;

public interface aiv {
    AlphaShader aPA = new AlphaShader();
    aix aPB = new BloomShader();
    aix aPC = new BloomShader();
    aix aPD = new BloomShader();
    GaussianBlurShader aPE = new GaussianBlurShader();
    GaussianBlurShader aPF = new GaussianBlurShader();
    aix aPG = new OutlineShader();
    RQShader aPH = new RQShader();
    RGQShader aPI = new RGQShader();
    ROQShader aPJ = new ROQShader();
    ROGQShader aPK = new ROGQShader();
    aix aPL = new MainMenuBackgroundShader();
    aix aPM = new BAWShader();
    RGQTestShader aPN = new RGQTestShader();
    TriRGQShader aPO = new TriRGQShader();
}
