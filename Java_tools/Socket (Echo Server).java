import java.io.*;
import java.net.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        int portNumber = 12345; // Elige un puerto (mayor que 1024)

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Servidor escuchando en el puerto " + portNumber);

            while (true) {
                try (
                    Socket clientSocket = serverSocket.accept(); // Espera una conexión
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Recibido del cliente: " + inputLine);
                        out.println("Echo: " + inputLine); // Envía el mensaje de vuelta
                    }
                } catch (IOException e) {
                    System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo escuchar en el puerto " + portNumber + ": " + e.getMessage());
        }
    }
}