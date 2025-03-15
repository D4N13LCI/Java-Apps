import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataToExcel {

    public static void main(String[] args) {

        // Datos de ejemplo
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan Pérez", 30, "1993-05-15", "123456789"));
        personas.add(new Persona("María Gómez", 25, "1998-11-20", "987654321"));
        personas.add(new Persona("Carlos López", 40, "1983-02-10", "456789123"));

        // Nombre del archivo Excel
        String excelFilePath = "personas.xlsx";

        // Crear el archivo Excel
        try {
            Workbook workbook = createExcelFile(personas);

            // Escribir el archivo en disco
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }

            workbook.close(); // Cerrar el libro de trabajo
            System.out.println("Archivo Excel creado exitosamente: " + excelFilePath);

        } catch (IOException e) {
            System.err.println("Error al crear el archivo Excel: " + e.getMessage());
        }
    }

    // Método para crear el archivo Excel a partir de la lista de personas
    private static Workbook createExcelFile(List<Persona> personas) throws IOException {
        Workbook workbook = new XSSFWorkbook(); // Usar XSSFWorkbook para archivos .xlsx
        Sheet sheet = workbook.createSheet("Personas");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nombre");
        headerRow.createCell(1).setCellValue("Edad");
        headerRow.createCell(2).setCellValue("Fecha de Nacimiento");
        headerRow.createCell(3).setCellValue("Cédula");

        // Crear filas de datos
        int rowNum = 1;
        for (Persona persona : personas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(persona.getNombre());
            row.createCell(1).setCellValue(persona.getEdad());
            row.createCell(2).setCellValue(persona.getFechaNacimiento());
            row.createCell(3).setCellValue(persona.getCedula());
        }

        // Ajustar el ancho de las columnas al contenido
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }

    // Clase interna para representar una persona
    static class Persona {
        private String nombre;
        private int edad;
        private String fechaNacimiento;
        private String cedula;

        public Persona(String nombre, int edad, String fechaNacimiento, String cedula) {
            this.nombre = nombre;
            this.edad = edad;
            this.fechaNacimiento = fechaNacimiento;
            this.cedula = cedula;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public String getCedula() {
            return cedula;
        }
    }
}