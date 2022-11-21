import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Srv  implements TCPL{

    public static void main(String[] args) {
        new Srv();
    }

    private final ArrayList<TCPC> connections = new ArrayList<TCPC>();

    private Srv(){
        System.out.println("Server running...");
        try(ServerSocket serverSocket = new ServerSocket(8199)){
            while (true){
                try {
                    new TCPC(this,serverSocket.accept());
                }catch (IOException e){
                    System.out.println("TCPconnection exception:"+ e);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public synchronized void tcpReadyConnection(TCPC tcpc) {
        connections.add(tcpc);
        sendToAllClients("Clients connected:"+tcpc);
    }

    @Override
    public synchronized void tcpReceiveString(TCPC tcpc, String value) {
        sendToAllClients(value);
    }

    @Override
    public synchronized void tcpDisconnect(TCPC tcpc) {
        connections.remove(tcpc);
        sendToAllClients("Client disconnected:"+tcpc);
    }

    @Override
    public  synchronized void tcpException(TCPC tcpc, Exception e) {
        System.out.println("TCPC exception:"+e);
    }
    private void sendToAllClients(String value){
        System.out.println(value);
        for (int i=0;i<connections.size();i++){
            connections.get(i).sendString(value);
        }
    }
}
