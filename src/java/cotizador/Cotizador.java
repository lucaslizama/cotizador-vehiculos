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

    public int obtenerHoras() {

        long inicio = recogida.getTime();
        long termino = entrega.getTime();
        Long horas = (inicio - termino) / 3600000L;

        return horas.intValue();
    }

    public int obtenerDias() {
        int dias = obtenerHoras() / 24;
        return dias;
    }

    public int obtenerSemanas() {
        return obtenerDias() / 7;
    }

    public int obtenerDiasExtra() {
        return obtenerDias() - (obtenerSemanas() * 7);
    }

    public int obtenerHorasExtra() {
        return obtenerHoras() - (obtenerDias() * 24);
    }

    public int calcularValor(String auto, String recogida) {
        switch (auto) {
            case "Compacto":
                return valorCompacto();
            case "Sedan":
                return valorSedan();
            case "Camioneta":
                return valorCamioneta();
            default:
                return 0;
        }
    }

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

    private int valorCompacto() {
        return valorSemana("Compacto") + valorDiasExtra("Compacto") + valorHorasExtra("Compacto");
    }

    private int valorSedan() {
        return valorSemana("Sedan") + valorDiasExtra("Sedan") + valorHorasExtra("Sedan");
    }

    private int valorCamioneta() {
        return valorSemana("Camioneta") + valorDiasExtra("Camioneta") + valorHorasExtra("Camioneta");
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
        lugares[0] = new LugarRecogida("Santiago Provicendia", 0);
        lugares[1] = new LugarRecogida("Santiago Aeropuerto", 5000);
        lugares[2] = new LugarRecogida("Puerto Montt Centro", 0);
        lugares[3] = new LugarRecogida("Puerto Montt Aeropuerto", 5000);
        lugares[4] = new LugarRecogida("Antofagasta Aeropuerto", 5000);
        return lugares;
    }
}
