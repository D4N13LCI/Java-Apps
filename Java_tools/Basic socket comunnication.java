// Ejemplo de Servidor
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 12345; // Puerto de escucha

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor esperando conexiones en el puerto " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + clientSocket.getInetAddress().getHostAddress());

            // Configurar flujos de entrada y salida
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Lógica de comunicación
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Cliente: " + inputLine);
                out.println("Servidor: " + inputLine); // Echo
                if (inputLine.equals("bye"))
                    break;
            }

        } catch (IOException e) {
            System.err.println("Excepción: " + e.getMessage());
        }
    }
}

// Ejemplo de Cliente
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String hostName = "localhost"; // O la dirección IP del servidor
        int portNumber = 12345;

        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Conectado al servidor");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Servidor: " + in.readLine());
                if (userInput.equals("bye"))
                    break;
            }

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + hostName);
        } catch (IOException e) {
            System.err.println("No se pudo conectar a " + hostName + " en el puerto " + portNumber);
            System.err.println("Excepción: " + e.getMessage());
        }
    }
}