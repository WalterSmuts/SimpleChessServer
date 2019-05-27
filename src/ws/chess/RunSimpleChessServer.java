package ws.chess;

import com.google.inject.Injector;
import ws.chess.server.SimpleChessServer;

import static com.google.inject.Guice.createInjector;

public class RunSimpleChessServer {

    public static void main(String[] args) {
        Injector injector =  createInjector(new ServerModule());
        SimpleChessServer server = injector.getInstance(SimpleChessServer.class);
        server.run();
    }
}
