package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import logica.registro;
import logica.perfiles;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public final class peticiones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("application/json;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
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
            } catch ( SQLException ex ) {
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

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
