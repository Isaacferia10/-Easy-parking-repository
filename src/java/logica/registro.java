/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author Administrador
 */
import Persistencia.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
public class registro {
    
    int id ;
    int lugar;
    String matricula;
    String vehiculo;
    String hentrada;
    String hsalida;
    String fecha;
    long Vparqueo;
            
    
    conexion conexion = new conexion();
    
    
    private conexion con;

    public registro(int lugar, String matricula, String vehiculo, String hentrada) {
        this.lugar = lugar;
        this.matricula = matricula;
        this.vehiculo = vehiculo;
        this.hentrada = hentrada;
        
    } 

    public registro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getHentrada() {
        return hentrada;
    }

    public void setHentrada(String hentrada) {
        this.hentrada = hentrada;
    }

    public String getHsalida() {
        return hsalida;
    }

    public void setHsalida(String hsalida) {
        this.hsalida = hsalida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getVparqueo() {
        return Vparqueo;
    }

    public void setVparqueo(long Vparqueo) {
        this.Vparqueo = Vparqueo;
    }
    public String calcularParqueo() throws ParseException{
        
        String horasalida=this.hsalida;
        String horaentrada=this.hentrada;
        SimpleDateFormat formato= new SimpleDateFormat("HH:mm:ss");
        long date1 = (formato.parse(horasalida).getTime())-(formato.parse(horaentrada).getTime());
        String horaservicio = (date1/(60*60*1000))+":"+((date1/(60*1000))%60)+":"+((date1/1000))%60 ;
        return horaservicio;
    }

    @Override
    public String toString() {
        return "registro{" + "id=" + id + ", lugar=" + lugar + ", matricula=" + matricula + ", vehiculo=" + vehiculo + ", hentrada=" + hentrada + ", hsalida=" + hsalida + ", fecha=" + fecha + ", Vparqueo=" + Vparqueo + '}';
    }
    

    
    
    
    public boolean GuardarRegisitro(){
        String sentencia = "INSERT INTO parqueos (lugar,matricula,vehiculo,hora_entrada,hora_salida,fecha,valor_parqueo) VALUES("+this.lugar+",'"+this.matricula+"','"+this.vehiculo+"','"+this.hentrada+"','"+this.hsalida+"','"+this.fecha+"',"+this.Vparqueo+")";
        return conexion.insertarSQL(sentencia); 
    }
    public boolean EliminarResgitro(int id){
        String sentencia = "DELETE FROM parqueos WHERE id="+id+";";
        return conexion.borrarSQL(sentencia);
    }
    public boolean ActualizarRegistro(int id){
        String sentencia = "UPDATE parqueos SET lugar="+this.lugar+",matricula='"+this.matricula+"',vehiculo='"+this.vehiculo+"',hora_entrada='"+this.hentrada+"',hora_salida='"+this.hsalida+"',fecha='"+this.fecha+"',valor_parqueo='"+this.Vparqueo+"' WHERE id="+id+";";
        return conexion.actualizarSQL(sentencia);
    }
    
    public ArrayList<registro> listarRegistro(){
        ArrayList<registro> listaregistro = new ArrayList<>();
        String sentencia = "SELECT * FROM parqueos";
        ResultSet rs = conexion.consultarSQl(sentencia);
        registro r;
        try{
            while(rs.next()){
                r=new registro();
                r.setId(rs.getInt("id"));
                r.setLugar(rs.getInt("lugar"));
                r.setMatricula(rs.getString("matricula"));
                r.setVehiculo(rs.getString("vehiculo"));
                r.setHentrada(rs.getString("hora_entrada"));
                r.setHsalida(rs.getString("hora_salida"));
                r.setFecha(rs.getString("fecha"));
                r.setVparqueo(rs.getLong("valor_parqueo"));
                listaregistro.add(r);
                
            }
        }catch(SQLException e){
            System.out.println("error Consulta: "+e.getMessage());}
        return listaregistro;
    }

}
