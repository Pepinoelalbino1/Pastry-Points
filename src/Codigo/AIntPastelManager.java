package Codigo;

import java.math.BigDecimal;

public interface AIntPastelManager {
    int agregarPastel(String nombre, boolean dietFriendly, BigDecimal precio);
    void agregarDescripcion(int idPastel, String descripcion);
}