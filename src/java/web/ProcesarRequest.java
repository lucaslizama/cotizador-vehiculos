package web;

import cotizador.Cotizador;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * Clase que nos permite hacer el trabajo del Servlet.
 *
 * @author Pancho
 */
public class ProcesarRequest {

    private HttpServletRequest request;
    private SimpleDateFormat format;

    /**
     * Constructor con parametros.
     *
     * @param request
     */
    public ProcesarRequest(HttpServletRequest request) {
        this.request = request;
        this.format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    }

    /**
     * Metodo publico que realiza los calculos de la cotizacion y valida que las
     * fechas no sean menor a cero cuando se restan.
     *
     * @return
     * @throws Exception
     */
    public HashMap<String, Integer> getMensajeCotizasion() throws Exception {
        Date recogida = format.parse(formatDateStringRecogida());
        Date entrega = format.parse(formatDateStringDevolucion());

        if (entrega.getTime() - recogida.getTime() < 0) {
            throw new Exception("Fechas invalidas");
        }

        Cotizador cotiza = new Cotizador(recogida, entrega);
        HashMap<String, Integer> mensajes = new HashMap<>();

        mensajes.put("Compacto", cotiza.calcularValor("Compacto", request.getParameter("selRecorrido")));
        mensajes.put("Sedan", cotiza.calcularValor("Sedan", request.getParameter("selRecorrido")));
        mensajes.put("Camioneta", cotiza.calcularValor("Camioneta", request.getParameter("selRecorrido")));

        return mensajes;
    }

    /**
     * Metodo que concatena la fecha de recogida.
     *
     * @return
     */
    private String formatDateStringRecogida() {
        String fecha = request.getParameter("fechaRecogida");
        fecha = fecha.concat(" " + getTimeStringRecogida());
        return fecha;
    }

    /**
     * Metodo que concatena la fecha de devolucion.
     *
     * @return
     */
    private String formatDateStringDevolucion() {
        String fecha = request.getParameter("fechaDevolucion");
        fecha = fecha.concat(" " + getTimeStringDevolucion());
        return fecha;
    }

    /**
     * Metodo privado que obtiene las horas y minutos de la recogida.
     *
     * @return
     */
    private String getTimeStringRecogida() {
        String horas = request.getParameter("selHoraRecogida");
        String minutos = request.getParameter("selMinutoRecogida");

        return horas + ":" + minutos;
    }

    /**
     * Metodo privado que obtiene las horas y minutos de la devolucion.
     *
     * @return
     */
    private String getTimeStringDevolucion() {
        String horas = request.getParameter("selHoraDevolucion");
        String minutos = request.getParameter("selMinutoDevolucion");

        return horas + ":" + minutos;
    }
}
