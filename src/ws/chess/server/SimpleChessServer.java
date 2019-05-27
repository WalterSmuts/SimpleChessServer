package ws.chess.server;

public class SimpleChessServer {

    public void run() {
        try {
            while (true){
                System.out.println("Running Simple Chess Server...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

}
