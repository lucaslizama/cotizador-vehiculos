<%-- 
    Document   : mostrarCotizasion
    Created on : Sep 13, 2016, 8:30:56 PM
    Author     : Pancho
--%>

<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizacion Vehiculos</title>
        <link rel="stylesheet" href="css/cssIndex.css" type="text/css"><link>
    </head>
    <body>
        <%
            HashMap<String,Integer> mensajes = (HashMap<String, Integer>)request.getAttribute("mensajes");
        %>
        <div>
            <fieldset>
                <table>
                    <tr>
                        <td>Tipo de Automovil</td>
                        <td>Precio por Dia</td>
                        <td>Precio por Semana</td>
                        <td>Hora Adicional</td>
                        <td>Total</td>
                    </tr>
                    <tr>
                        <td>Compacto<img src="imagenes/compacto.jpg" width="150" height="80" alt="compacto"></td>
                        <td>$26000</td>
                        <td>$136500</td>
                        <td>$2000</td>
                        <td>$<%=mensajes.get("Compacto")%></td>
                    </tr>
                    <tr>
                        <td>Sedan<img src="imagenes/sedan.jpg" width="150" height="80" alt="sedan"></td>                                                                                                                                                                                                                                                                                                                                                                                                                                         jpg" width="150" height="80" alt="sedan"></td>
                        <td>$35000</td>
                        <td>$171500</td>
                        <td>$2500</td>
                        <td>$<%=mensajes.get("Sedan")%></td>
                    </tr>
                    <tr>
                        <td>Camioneta<img src="imagenes/camioneta.jpg" width="150" height="80" alt="camioneta"></td>
                        <td>$43000</td>
                        <td>$210000</td>
                        <td>$3000</td>
                        <td>$<%=mensajes.get("Camioneta")%></td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </body>
</html>
