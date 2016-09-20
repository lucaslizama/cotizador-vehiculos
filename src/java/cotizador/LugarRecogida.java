package cotizador;

/**
 * Clase que nos permite almacenar la informacion de el lugar de recogida.
 *
 * @author Pancho
 */
public class LugarRecogida {

    private String nombre;
    private int recargo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRecargo() {
        return recargo;
    }

    public void setRecargo(int recargo) {
        this.recargo = recargo;
    }

    public LugarRecogida(String nombre, int recargo) {
        this.nombre = nombre;
        this.recargo = recargo;
    }
}
