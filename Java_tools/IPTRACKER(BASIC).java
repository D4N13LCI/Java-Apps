import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddress {

    public static void main(String[] args) {

        try {
            // Obtiene la dirección IP de la máquina local
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();

            System.out.println("Dirección IP local: " + ipAddress);

            //Opcional:  Obtener el nombre del host
            String hostName = localHost.getHostName();
            System.out.println("Nombre del host local: " + hostName);

        } catch (UnknownHostException e) {
            System.err.println("No se pudo determinar la dirección IP local: " + e.getMessage());
        }
    }
}