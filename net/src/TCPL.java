public interface TCPL {
    void tcpReadyConnection(TCPC tcpc);//готовое соединение
    void tcpReceiveString(TCPC tcpc,String value);//получени строки

    void tcpDisconnect(TCPC tcpc);//разрыв соединения

    void tcpException(TCPC tcpc, Exception e);//исключение

}
