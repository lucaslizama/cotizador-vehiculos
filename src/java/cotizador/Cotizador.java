package cotizador;

import java.util.Date;

public class Cotizador {

    private Date recogida;
    private Date entrega;
    private Automovil[] automoviles;
    private LugarRecogida[] lugaresRecogida;

    public Cotizador(Date recogida, Date entrega) {
        this.recogida = recogida;
        this.entrega = entrega;
        this.automoviles = inicializarAutomoviles();
        this.lugaresRecogida = inicializarLugaresRecogida();
    }

    /**
     * Metodo publico que calcula las horas.
     *
     * @return
     */
    public int obtenerHoras() {

        long inicio = recogida.getTime();
        long termino = entrega.getTime();
        Long horas = (termino - inicio) / 3600000L;

        return horas.intValue();
    }

    /**
     * Metodo publico que calcula los dias.
     *
     * @return
     */
    public int obtenerDias() {
        int dias = obtenerHoras() / 24;
        return dias;
    }

    /**
     * Metodo publico que calcula las semanas.
     *
     * @return
     */
    public int obtenerSemanas() {
        return obtenerDias() / 7;
    }

    /**
     * Metodo publico que obtiene los dias extra.
     *
     * @return
     */
    public int obtenerDiasExtra() {
        return obtenerDias() - (obtenerSemanas() * 7);
    }

    /**
     * Metodo publico que obtiene las horas extras.
     *
     * @return
     */
    public int obtenerHorasExtra() {
        return obtenerHoras() - (obtenerDias() * 24);
    }

    /**
     * Metodo publico que calcula el valor de la cotizacion final.
     *
     * @param auto
     * @param recogida
     * @return
     */
    public int calcularValor(String auto, String recogida) {
        switch (auto) {
            case "Compacto":
                return valorCompacto() + valorRecargo(recogida);
            case "Sedan":
                return valorSedan() + valorRecargo(recogida);
            case "Camioneta":
                return valorCamioneta() + valorRecargo(recogida);
            default:
                return 0;
        }
    }

    /**
     * Metodo privado que obtiene valores segun su categoria compacto.
     *
     * @return
     */
    private int valorCompacto() {
        return valorSemana("Compacto") + valorDiasExtra("Compacto") + valorHorasExtra("Compacto");
    }

    /**
     * Metodo privado que obtiene valores segun su categoria sedan.
     *
     * @return
     */
    private int valorSedan() {
        return valorSemana("Sedan") + valorDiasExtra("Sedan") + valorHorasExtra("Sedan");
    }

    /**
     * Metodo privado que obtiene valores segun su categoria camioneta.
     *
     * @return
     */
    private int valorCamioneta() {
        return valorSemana("Camioneta") + valorDiasExtra("Camioneta") + valorHorasExtra("Camioneta");
    }

    /**
     * Metodo privado que calcula segun la categoria el valor por semana.
     *
     * @param auto
     * @return
     */
    private int valorSemana(String auto) {
        switch (auto) {
            case "Compacto":
                return obtenerSemanas() * automoviles[0].getPrecio_semana();
            case "Sedan":
                return obtenerSemanas() * automoviles[1].getPrecio_semana();
            case "Camioneta":
                return obtenerSemanas() * automoviles[2].getPrecio_semana();
            default:
                return 0;
        }
    }

    /**
     * Metodo privado que calcula los dias extras segun la categoria.
     *
     * @param auto
     * @return
     */
    private int valorDiasExtra(String auto) {
        switch (auto) {
            case "Compacto":
                return obtenerDiasExtra() * automoviles[0].getPrecio_dia();
            case "Sedan":
                return obtenerDiasExtra() * automoviles[1].getPrecio_dia();
            case "Camioneta":
                return obtenerDiasExtra() * automoviles[2].getPrecio_dia();
            default:
                return 0;
        }
    }

    /**
     * Metodo privado que calcula el valor de horas extras segun su categoria.
     *
     * @param auto
     * @return
     */
    private int valorHorasExtra(String auto) {
        switch (auto) {
            case "Compacto":
                return obtenerHorasExtra() * automoviles[0].getHora_adicional();
            case "Sedan":
                return obtenerHorasExtra() * automoviles[1].getHora_adicional();
            case "Camioneta":
                return obtenerHorasExtra() * automoviles[2].getHora_adicional();
            default:
                return 0;
        }
    }

    /**
     * Metodo privado que calcula el valor del recargo.
     *
     * @param recogida
     * @return
     */
    private int valorRecargo(String recogida) {
        for (int i = 0; i < lugaresRecogida.length; i++) {
            if (lugaresRecogida[i].getNombre().equals(recogida)) {
                return lugaresRecogida[i].getRecargo();
            }
        }
        return 0;
    }

    private Automovil[] inicializarAutomoviles() {
        Automovil[] autos = new Automovil[3];
        autos[0] = new Automovil("Compacto", 26000, 136500, 2000);
        autos[1] = new Automovil("Sedan", 35000, 171500, 2500);
        autos[2] = new Automovil("Camioneta", 43000, 210000, 3000);
        return autos;
    }

    private LugarRecogida[] inicializarLugaresRecogida() {
        LugarRecogida[] lugares = new LugarRecogida[5];
        lugares[0] = new LugarRecogida("santiago_providencia", 0);
        lugares[1] = new LugarRecogida("santiago_aeropuerto", 5000);
        lugares[2] = new LugarRecogida("puerto_centro", 0);
        lugares[3] = new LugarRecogida("puerto_aeropuerto", 5000);
        lugares[4] = new LugarRecogida("antofagasta_aeropuerto", 5000);
        return lugares;
    }
}
