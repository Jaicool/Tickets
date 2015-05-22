/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicModel;

/**
 *
 * @author Byron
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cdate {
    public String getDate(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String result=dateFormat.format(date);
        
        return result.replaceAll("/", "");
    }
    public String DatenHour(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String result=dateFormat.format(date);
        
        return result;
    }
}
