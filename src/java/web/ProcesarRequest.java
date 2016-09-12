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
        this.format = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    public HashMap<String,Integer> GetMensajeCotizasion() throws Exception{
        Date recogida = format.parse(request.getParameter("fechaRecogida"));
        Date entrega = format.parse(request.getParameter("fechaDevolucion"));
        Cotizador cotiza = new Cotizador(recogida,entrega);
        HashMap<String,Integer> mensajes = new HashMap<>();
        
        mensajes.put("Compacto", cotiza.calcularValor("Compacto", request.getParameter("selRecorrido")));
        mensajes.put("Sedan", cotiza.calcularValor("Sedan", request.getParameter("selRecorrido")));
        mensajes.put("Camioneta", cotiza.calcularValor("Camioneta", request.getParameter("selRecorrido")));
        
        return mensajes;
    }
}
