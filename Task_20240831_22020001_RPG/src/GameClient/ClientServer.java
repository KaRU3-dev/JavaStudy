package GameClient;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class ClientServer {
    public int Port;
    public HttpServer Server;

    public ClientServer(int port) {
        Port = port;
    }

    public void start() {
        try {
            Server = HttpServer.create(new InetSocketAddress(Port), 0);
            Server.createContext("/get");
            Server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        Server.stop(0);
    }
}
