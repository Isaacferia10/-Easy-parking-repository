/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
import java.sql.*;
public class conexion {
    
    public Connection con=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    
    public conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/easy_parking","root","");
            if(con != null){
                System.out.println("conexion correctar");
            }
        }catch(Exception e){
            System.err.println("error1:" + e);

        }
    }
    public ResultSet sonsultarSQl(String sentencia){
        try{
        stmt=con.createStatement();
        rs=stmt.executeQuery(sentencia);
        }catch(SQLException sqlex){
            System.out.println(sqlex.getMessage());
        }catch(RuntimeException rex){
            System.out.println(rex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return rs;
        
    }
    public boolean insertarSQL(String sentecia){
        try{
            stmt=con.createStatement();
            stmt.execute(sentecia);
        }catch(SQLException | RuntimeException sqlex){
            System.out.println("error Rutins" + sqlex.getMessage());
            return false;
        }
        return true;
    }
    public boolean actualizarSQL(String sentencia){
        try{
        stmt=con.createStatement();
        stmt.executeUpdate(sentencia);
    }catch(SQLException | RuntimeException sqlex){
            System.out.println("error Rutins" + sqlex.getMessage());
            return false;
        }
        return true;
    }
    public boolean borrarSQL(String sentencia){
        try{
            stmt=con.createStatement();
            stmt.execute(sentencia);
        }catch(SQLException | RuntimeException sqlex){
            System.out.println("error Rutins" + sqlex.getMessage());
            return false;
        }
        return true;
    }
    
}