/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Persistencia.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class perfiles {
    int id ;
    String nombreUsuario;
    String rolUsuario;
    String claveUsuario;
    
    conexion conexion = new conexion();

    public perfiles(String nombreUsuario, String rolUsuario, String claveUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.rolUsuario = rolUsuario;
        this.claveUsuario = claveUsuario;
    }

    public perfiles() {
    }

    @Override
    public String toString() {
        return "perfiles{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", rolUsuario=" + rolUsuario + ", claveUsuario=" + claveUsuario + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
    
    public boolean guardarUsuario(){
        String sentencia ="INSERT INTO usuarios (usuario,rol,clave) VALUES('"+this.nombreUsuario+"','"+this.rolUsuario+"','"+this.claveUsuario+"')";
        return conexion.insertarSQL(sentencia);
    }
    public boolean eliminarUsuario(int id){
        String sentencia="DELETE FROM usuarios WHERE id="+id+";";
        return conexion.borrarSQL(sentencia);
    }
    public boolean actualizarUsuario(int id){
        String sentencia="UPDATE usuarios SET usuario='"+this.nombreUsuario+"', rol='"+this.rolUsuario+"', clave='"+this.claveUsuario+"' WHERE id="+id+";";
        return conexion.insertarSQL(sentencia);
    }
    public ArrayList<perfiles> listarperfiles(){
        ArrayList<perfiles> listarusuarios = new ArrayList<>();
        String sentencia = "SELECT * FROM usuarios";
        ResultSet rs = conexion.consultarSQl(sentencia);
        perfiles p ;
        try{
            while(rs.next()){
                p=new perfiles();
                p.setId(rs.getInt("id"));
                p.setNombreUsuario(rs.getString("usuario"));
                p.setRolUsuario(rs.getString("rol"));
                p.setClaveUsuario(rs.getString("clave"));
                listarusuarios.add(p);
            }
            
        }catch(SQLException e){System.out.println("error Consulta: "+e.getMessage());}
    return listarusuarios;
    }
}
