/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import web.ProcesarRequest;

/**
 *
 * @author Lucas
 */
public class ProcesarRequestTest {
    
    private HttpServletRequest request;
    
    public ProcesarRequestTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void getMensajeCotizacionTest() {
        request = mock(HttpServletRequest.class);
        when(request.getParameter("selRecorrido")).thenReturn("santiago_providencia");
        when(request.getParameter("fechaRecogida")).thenReturn("2016-05-12");
        when(request.getParameter("selHoraRecogida")).thenReturn("02");
        when(request.getParameter("selMinutoRecogida")).thenReturn("45");
        when(request.getParameter("fechaDevolucion")).thenReturn("2016-06-15");
        when(request.getParameter("selHoraDevolucion")).thenReturn("05");
        when(request.getParameter("selMinutoDevolucion")).thenReturn("00");
        
        ProcesarRequest pr = new ProcesarRequest(request);
        
        HashMap<String,Integer> mensajes;
        try {
            mensajes = pr.getMensajeCotizasion();
        }catch(Exception ex) {
            throw new AssertionError();
        }
        
        assertEquals(706000, mensajes.get("Compacto").intValue());
        assertEquals(901000, mensajes.get("Sedan").intValue());
        assertEquals(1104000, mensajes.get("Camioneta").intValue());
    }
}
