<%-- 
    Document   : peticiones
    Created on : 28/09/2021, 08:32:29 PM
    Author     : Administrador
--%>
<%@page import="java.util.logging.Logger" %>
<%@page import="java.util.logging.Level" %>
<%@page import="java.sql.SQLException" %>
<%@page import="logica.registro" %>
<%@page import="logica.perfiles" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<% 
    String respuesta = "{";
        List<String> tareas = Arrays.asList(new String[]{
            "actulizarRegistro",
            "eliminarRegistro",
            "listarRegistro",
            "guardarRegistro"
        });
    
    
    String proceso = ""+ request.getParameter("proceso");
    
    if(tareas.contains(proceso)){
        respuesta += "\"ok\": true,";
        
        if(proceso.equals("guardarRegistro")){
            int id = Integer.getInteger(request.getParameter("id"));
            int lugar = Integer.getInteger(request.getParameter("lugar"));
            String matricula = request.getParameter("matricula");
            String vehiculo = request.getParameter("vehiculo");
            String hentrada = request.getParameter("hora_entrada");
            String hsalida = request.getParameter("hora_salida");
            String fecha = request.getParameter("fecha");
            String Vparqueo = request.getParameter("valor_parqueo");
            
            registro r = new registro();
            r.setLugar(lugar);
            r.setMatricula(matricula);
            r.setVehiculo(vehiculo);
            r.setHentrada(hentrada);
            r.setHsalida(hsalida);
            r.setFecha(fecha);
            r.setVparqueo(Integer.getInteger(Vparqueo));
            if(r.GuardarRegisitro()){respuesta += "\"" + proceso + "\": true";}else{respuesta += "\"" + proceso + "\": false";}
            
            
        }else if(proceso.equals("eliminarRegistro")){
            int id = Integer.getInteger(request.getParameter("id"));
            
            registro r = new registro();
            if(r.EliminarResgitro(id)){respuesta += "\"" + proceso + "\": true";}else{respuesta += "\"" + proceso + "\": false";}
        }else if(proceso.equals("listarRegistro")){
            registro r = new registro();
            try {
                List<registro> lista = r.listarRegistro();
                respuesta += "\"" + proceso + "\": true,\"registro\":" + new Gson().toJson(lista);
            } catch (SQLException ex) {
                respuesta += "\"" + proceso + "\": true,\"registro\":[]";
                Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(proceso.equals("actualizarRegistro")){
            int id = Integer.getInteger(request.getParameter("id"));
            int lugar = Integer.getInteger(request.getParameter("lugar"));
            String matricula = request.getParameter("matricula");
            String vehiculo = request.getParameter("vehiculo");
            String hentrada = request.getParameter("hora_entrada");
            String hsalida = request.getParameter("hora_salida");
            String fecha = request.getParameter("fecha");
            String Vparqueo = request.getParameter("valor_parqueo");
            
            registro r = new registro();
            r.setLugar(lugar);
            r.setMatricula(matricula);
            r.setVehiculo(vehiculo);
            r.setHentrada(hentrada);
            r.setHsalida(hsalida);
            r.setFecha(fecha);
            r.setVparqueo(Integer.getInteger(Vparqueo));
            if(r.ActualizarRegistro(id)){respuesta += "\"" + proceso + "\": true";}else{respuesta += "\"" + proceso + "\": false";}
        }
        }else{
            respuesta += "\"ok\": false,";
            respuesta += "\"error\": \"INVALID\",";
            respuesta += "\"errorMsg\": \"Lo sentimos, los datos que ha enviado,"
                + " son inválidos. Corrijalos y vuelva a intentar por favor.\"";
    }
    respuesta += "}";
    response.setContentType("application/json;charset=iso-8859-1");
    out.print(respuesta);
%>
