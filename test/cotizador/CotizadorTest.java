/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class CotizadorTest {
    
    private Cotizador cotizador;
    
    public CotizadorTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void obtenerHorasTest() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(1, cotizador.obtenerHoras());
    }
    
    @Test
    public void obtener24HorasTest() {
        Date fecha1 = new Date();
        Date fecha2 = new Date();
        fecha2.setTime(fecha2.getTime() + 24L * 3600000L);
        
        cotizador = new Cotizador(fecha1,fecha2);
        assertEquals(24, cotizador.obtenerHoras());
    }
    
    @Test
    public void obtenerDiasTest() {
        
    }
}
