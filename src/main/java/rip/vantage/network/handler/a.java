package rip.vantage.network.handler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.websocket.ClientEndpointConfig.Configurator;

public class a extends Configurator {
    public a() {
    }

    @Override
    public void beforeRequest(Map<String, List<String>> var1) {
        var1.put("gdfg", Collections.singletonList("fdsgh"));
    }
}
