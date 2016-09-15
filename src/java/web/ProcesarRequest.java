package web;

import cotizador.Cotizador;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cetecom
 */
public class ProcesarRequest {
    
    private HttpServletRequest request;
    private SimpleDateFormat format;
    
    public ProcesarRequest(HttpServletRequest request) {
        this.request = request;
        this.format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    }
    
    public HashMap<String,Integer> getMensajeCotizasion() throws Exception{
        Date recogida = format.parse(formatDateStringRecogida());
        Date entrega = format.parse(formatDateStringDevolucion());
        
        if(entrega.getTime() - recogida.getTime() < 0)
            throw new Exception("Fechas invalidas");
        
        Cotizador cotiza = new Cotizador(recogida,entrega);
        HashMap<String,Integer> mensajes = new HashMap<>();
        
        mensajes.put("Compacto", cotiza.calcularValor("Compacto", request.getParameter("selRecorrido")));
        mensajes.put("Sedan", cotiza.calcularValor("Sedan", request.getParameter("selRecorrido")));
        mensajes.put("Camioneta", cotiza.calcularValor("Camioneta", request.getParameter("selRecorrido")));
        
        return mensajes;
    } 
    
    private String formatDateStringRecogida() {
        String fecha = request.getParameter("fechaRecogida");
        fecha = fecha.concat(" " + getTimeStringRecogida());
        return fecha;
    }
    
    private String formatDateStringDevolucion() {
        String fecha = request.getParameter("fechaDevolucion");
        fecha = fecha.concat(" " + getTimeStringDevolucion());
        return fecha;
    }
    
    private String getTimeStringRecogida() {
        String horas = request.getParameter("selHoraRecogida");
        String minutos = request.getParameter("selMinutoRecogida");
        
        return horas + ":" + minutos;
    }
    
    private String getTimeStringDevolucion() {
        String horas = request.getParameter("selHoraDevolucion");
        String minutos = request.getParameter("selMinutoDevolucion");
        
        return horas + ":" + minutos;
    }
}
