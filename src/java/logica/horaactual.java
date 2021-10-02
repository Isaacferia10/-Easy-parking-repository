/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Administrador
 */
public class horaactual {
    String hora= new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    

    public horaactual() {
    }
    public String hora (){
        return this.hora;
    
    }
   
    
}
