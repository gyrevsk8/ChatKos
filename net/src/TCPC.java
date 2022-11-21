import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class TCPC {
    private  final TCPL listener;//Interface tcpl
    private final Socket socket;//сокет
    private final Thread rxThread;//поток для входящих сообщений
    private final BufferedReader input;//поток ввода
    private final BufferedWriter output;//поток вывода

    public TCPC(TCPL listener,String ipAdress,int port) throws  IOException{//подключение из вне
        this(listener,new Socket(ipAdress,port));
    }
    public TCPC(TCPL listener,Socket socket) throws IOException {//конструктор создающий соединение
        this.listener=listener;
        this.socket=socket;//инициализация сокета
        input = new BufferedReader(new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8));//получаем входящий поток c работающей кодировкой
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));//получаем исходящий поток
        rxThread = new Thread(new Runnable() {//создаем новый поток
            @Override//переопределяем метод
            public void run() {
                try {
                    listener.tcpReadyConnection(TCPC.this);//подключение
                    while (!rxThread.isInterrupted()) {//пока не конец
                        String msg = input.readLine();
                        listener.tcpReceiveString(TCPC.this,input.readLine());//получение строки
                    }
                } catch (IOException e) {
                    listener.tcpException(TCPC.this,e);
                }finally {
                    listener.tcpDisconnect(TCPC.this);
                }
            }
        });
        rxThread.start();
    }
    public synchronized void sendString(String message){
     try {
         output.write(message+"\r\n");
         output.flush();
     }
     catch (IOException e){
         listener.tcpException(TCPC.this,e);
         disconnect();
     }

    }
    public synchronized void disconnect() {
       rxThread.interrupt();
       try {
           socket.close();
       } catch (IOException e){
           listener.tcpException(TCPC.this,e);
       }

    }
    @Override
    public String toString(){
        return "TCPC:"+socket.getInetAddress()+" "+socket.getPort();
    }
}
