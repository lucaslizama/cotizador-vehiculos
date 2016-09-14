/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador;

import com.sun.xml.ws.transport.tcp.server.glassfish.ServletFakeArtifactSet;
import javax.resource.NotSupportedException;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import static org.junit.Assert.*;

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
        request = new ServletFakeArtifactSet.FakeServletHttpRequest("", "");
        request.setAttribute("", this);
        
        assertTrue(false);
    }
}
