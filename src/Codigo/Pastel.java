package Codigo;

public interface Pastel extends Cloneable {
    Pastel clonar(); // Método para clonar el pastel
    int getId();
    String getNombre();
    boolean isDietFriendly();
    double getPrecio();
    int getCalificacion();
    void actualizarCalificacion(boolean recomendacion);
}