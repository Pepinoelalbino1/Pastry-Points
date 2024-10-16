import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class APastelManager implements AIntPastelManager {
    private Connection connection;

    public APastelManager(Connection connection) {
        this.connection = connection;
    }

   @Override
public int agregarPastel(String nombre, boolean dietFriendly, BigDecimal precio) {
    if (connection == null) {
        System.out.println("Error: la conexión a la base de datos es nula.");
        return -1;
    }

    String sql = "INSERT INTO Pastel (nombre, dieta, precio, calificacion) VALUES (?, ?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, nombre);
        pstmt.setBoolean(2, dietFriendly);
        pstmt.setBigDecimal(3, precio);
        pstmt.setInt(4, 0); // Calificación inicial es 0
        
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows == 0) {
            System.out.println("Error: No se insertó ningún pastel.");
            return -1;
        }

        System.out.println("Pastel agregado: " + nombre);

        // Recuperar el ID generado
        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Devuelve el ID generado
            } else {
                System.out.println("Error: No se pudo recuperar el ID del pastel generado.");
                return -1;
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al agregar pastel: " + e.getMessage());
        e.printStackTrace(); // Agregar stack trace para más información
        return -1; // Retorna -1 en caso de error
    }
}

    @Override
    public void agregarDescripcion(int idPastel, String descripcion) {
        String sql = "INSERT INTO PastelDescripciones (id_pastel, descripcion) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idPastel);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Descripción agregada para el pastel con ID: " + idPastel);
        } catch (SQLException e) {
            System.err.println("Error al agregar descripción: " + e.getMessage());
        }
    }
}