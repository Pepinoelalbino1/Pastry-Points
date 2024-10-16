public class PastelConcreto implements Pastel {
    private int id;
    private String nombre;
    private boolean dietFriendly;
    private double precio;
    private int calificacion;

    public PastelConcreto(int id, String nombre, boolean dietFriendly, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.dietFriendly = dietFriendly;
        this.precio = precio;
        this.calificacion = 0; // Calificación inicial
    }

    @Override
    public Pastel clonar() {
        return new PastelConcreto(id, nombre, dietFriendly, precio);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean isDietFriendly() {
        return dietFriendly;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public int getCalificacion() {
        return calificacion;
    }

    @Override
    public void actualizarCalificacion(boolean recomendacion) {
        if (recomendacion) {
            calificacion++;
        } else {
            calificacion--;
        }
    }
}