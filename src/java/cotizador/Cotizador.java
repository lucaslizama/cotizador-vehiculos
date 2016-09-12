package cotizador;

import java.util.Date;

public class Cotizador {

    private Date recogida;
    private Date entrega;

    public Cotizador(Date recogida, Date entrega) {
        this.recogida = recogida;
        this.entrega = entrega;
    }
    
    public int obtenerHoras() {

        long inicio = recogida.getTime();
        long termino = entrega.getTime();
        Long horas = ((inicio - termino) / 1000) / 3600;

        return horas.intValue();
    }

    public int obtenerDias() {
        int dias = obtenerHoras() / 24;
        return dias;
    }

    public int calcularValor(String auto,String recogida) {
        int horas = obtenerHoras();
        int dias = obtenerDias();
        
        int semanas = dias / 7;
        
        
        return 0;
    }
}
