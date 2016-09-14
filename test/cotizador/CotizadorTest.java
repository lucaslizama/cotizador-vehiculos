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
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 24L * 5L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(5,cotizador.obtenerDias());
    }
    
    @Test
    public void obtener2SemanasTest() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 24L * 15L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(2, cotizador.obtenerSemanas());
    }
    
    @Test
    public void obtener0SemanasTest() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 24L * 6L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(0, cotizador.obtenerSemanas());
    }
    
    @Test
    public void obtener3DiasExtras() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 24L * 10L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(3, cotizador.obtenerDiasExtra());
    }
    
    @Test
    public void obtener0DiasExtras() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 24L * 14L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(0, cotizador.obtenerDiasExtra());
    }
    
    @Test
    public void obtener23HorasExtraTest() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 47L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(23, cotizador.obtenerHorasExtra());
    }
    
    @Test
    public void obtener0HorasExtraTest() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 48L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(0, cotizador.obtenerHorasExtra());
    }
    
    @Test
    public void calcularValor2diasY3HorasExtraAeropuertoSantiagoSedan() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 51L);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(82500, cotizador.calcularValor("Sedan", "Santiago Aeropuerto"));
    }
    
    @Test
    public void calcularValor2SemanasY3DiasExtraY7HorasExtraSantiagoProvidenciaCamioneta() {
        Date fecha1 = new Date(0L);
        Date fecha2 = new Date(3600000L * 24L * 17L + 3600000L * 7);
        
        cotizador = new Cotizador(fecha1, fecha2);
        assertEquals(570000, cotizador.calcularValor("Camioneta", "Santiago Providencia"));
    }
}
