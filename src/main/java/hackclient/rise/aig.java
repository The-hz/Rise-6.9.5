package hackclient.rise;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.Callable;
import net.minecraft.client.multiplayer.ServerAddress;

public class aig implements Callable<Long> {
    private final SocketAddress aOJ;

    public aig(String var1) {
        ServerAddress serveraddress = ServerAddress.fromString(var1);
        this.aOJ = new InetSocketAddress(serveraddress.getIP(), serveraddress.getPort());
    }

    public Long vf() {
        try {
            Socket socket = new Socket();
            long i = System.currentTimeMillis();
            socket.connect(this.aOJ);
            socket.close();
            return System.currentTimeMillis() - i;
        } catch (Exception exception) {
            return 0L;
        }
    }

    public Long call() {
        return this.vf();
    }
}
