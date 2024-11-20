package Codigo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;  // Importa LocalDateTime
import java.time.format.DateTimeFormatter;  // Importa DateTimeFormatter

public class IPastelData {
    private Connection connection;

    public IPastelData(Connection connection) {
        this.connection = connection;
    }

    public String obtenerNombrePastel(int id) {
        String nombre = null;
        String sql = "SELECT nombre FROM Pastel WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del pastel: " + e.getMessage());
        }
        return nombre;
    }

    public String obtenerDescripcionPastel(int id) {
        String descripcion = null;
        String sql = "SELECT descripcion FROM PastelDescripciones WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                descripcion = rs.getString("descripcion");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la descripción del pastel: " + e.getMessage());
        }
        return descripcion;
    }

    // Método para obtener la fecha actual como cadena
    private String obtenerFechaActual() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Formato de fecha
        return ahora.format(formato);
    }

    public void actualizarCalificacion(int id, int cambio) {
        String sql = "UPDATE Pastel SET calificacion = calificacion + ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cambio);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Calificación actualizada para el pastel con ID " + id);
            // Muestra la fecha actual
            System.out.println("Actualizado el día: " + obtenerFechaActual());
        } catch (SQLException e) {
            System.out.println("Error al actualizar la calificación: " + e.getMessage());
        }
    }

   public BigDecimal obtenerPrecioPastel(int id) {
    BigDecimal precio = null;
    String sql = "SELECT precio FROM Pastel WHERE id = ?";
    
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            precio = rs.getBigDecimal("precio"); // Obtiene el precio de la columna "precio"
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el precio del pastel: " + e.getMessage());
    }
    
    return precio;    }
}