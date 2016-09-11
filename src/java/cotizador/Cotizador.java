package cotizador;

import java.util.Date;

public class Cotizador {

    private int obtenerHoras(Date recogida, Date devolucion) {

        long inicio = recogida.getTime();
        long termino = devolucion.getTime();
        Long horas = ((inicio - termino) / 1000) / 3600;

        return horas.intValue();
    }

    public int obtenerDias(Date recogida, Date devolucion) {
        int dias = obtenerHoras(recogida, devolucion) / 24;
        return dias;
    }

    public int calcularValor() {

        return 0;
    }
}
