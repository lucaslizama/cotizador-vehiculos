package cotizador;

public class Automovil {
    private String nombre;
    private int precio_dia;
    private int precio_semana;
    private int hora_adicional;

    public Automovil(String nombre, int precio_dia, int precio_semana, int hora_semana) {
        this.nombre = nombre;
        this.precio_dia = precio_dia;
        this.precio_semana = precio_semana;
        this.hora_adicional = hora_semana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(int precio_dia) {
        this.precio_dia = precio_dia;
    }

    public int getPrecio_semana() {
        return precio_semana;
    }

    public void setPrecio_semana(int precio_semana) {
        this.precio_semana = precio_semana;
    }

    public int getHora_adicional() {
        return hora_adicional;
    }

    public void setHora_adicional(int hora_adicional) {
        this.hora_adicional = hora_adicional;
    }
    
    
}
