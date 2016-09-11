package cotizador;

import java.util.Date;

public class Cotizador {

    public int obtenerHoras(Date recogida, Date devolucion) {

        long inicio = recogida.getTime();
        long termino = devolucion.getTime();
        Long horas = ((inicio - termino) / 1000) / 3600;

        return horas.intValue();
    }

    public int obtenerDias(Date recogida, Date devolucion) {

        long inicio = recogida.getTime();
        long termino = devolucion.getTime();
        Long dias = (((inicio - termino) / 1000) / 3600) / 24;

        return dias.intValue();
    }

    public int calcularValor() {

        return 0;
    }
}
