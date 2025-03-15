import java.util.Map;

public class SystemInfo {

    public static void main(String[] args) {

        // 1. Obtener información del sistema usando System.getProperty()
        System.out.println("--- Propiedades del Sistema ---");
        System.out.println("Nombre del sistema operativo: " + System.getProperty("os.name"));
        System.out.println("Arquitectura del sistema operativo: " + System.getProperty("os.arch"));
        System.out.println("Versión del sistema operativo: " + System.getProperty("os.version"));
        System.out.println("Usuario actual: " + System.getProperty("user.name"));
        System.out.println("Directorio de inicio del usuario: " + System.getProperty("user.home"));
        System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
        System.out.println("Separador de archivos: " + System.getProperty("file.separator"));
        System.out.println("Separador de rutas: " + System.getProperty("path.separator"));
        System.out.println("Separador de líneas: " + System.getProperty("line.separator")); //  \n en Unix, \r\n en Windows

        // 2. Obtener variables de entorno usando System.getenv()
        System.out.println("\n--- Variables de Entorno ---");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
    }
}