/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import LogicModel.Tickets;
import LogicModel.excel_Manage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author YorleydeMaría
 */
public class Server {
    List<List> sheetDataPasswords = new ArrayList();
    ArrayList<Tickets> cubeTickets=new ArrayList();
    List<List> sheetDataTickets = new ArrayList();

    public Server() throws IOException {
        sheetDataPasswords= excel_Manage.readExcel(System.getProperty("user.home")+"/Documents/NetBeansProjects/Tickets/contraseñas.xls");
        sheetDataTickets=excel_Manage.readExcel(System.getProperty("user.home")+"/Documents/NetBeansProjects/Tickets/Tickets.xls");
        createTickets();
    }
    
    
    
    public boolean SignIn(String pUser,long pPassword){
        
        return true;
    }
    public boolean checkUser(String pUser){
        for (int m=0;m<sheetDataPasswords.size();m++){
            for(int y=0;y<1;y++){
                String name=((sheetDataPasswords.get(m).get(y)).toString()).toLowerCase();
                pUser=pUser.toLowerCase();
                if (name.equals(pUser)){
                    System.out.println("esta el usuario");
                    return true;
                }
            }
        }
        System.out.println("no esta el usuario");
        return false;
    }
        public boolean checkPassword(String pUser,String pPassword){
        for (int m=0;m<sheetDataPasswords.size();m++){
            for(int y=0;y<1;y++){
                if (checkUser(pUser)){
                    String pass=((sheetDataPasswords.get(m).get(y+1)).toString());
                    if(pPassword.equals(pass)){
                        System.out.println("contraseña correcta");
                        return true;
                    }
                }
            }
        }
        System.out.println("contraseña incorrecta");
        return false;
    }
    public void createTickets(){
        for(int y=1; y!=sheetDataTickets.size();y++){
            List ticket=sheetDataTickets.get(y);
            
            String str=(ticket.get(1).toString());
            Object tic=(Object)ticket.get(1);
            String Str=tic.toString();
            System.out.println(Str);
           // System.out.println(pParameter);
//            long p;
             int l = Integer.parseInt(Str);
            //long p1=p.valueOf(pParameter);
           // System.out.println(l);
            String st = "100";
    Long lObj2 = Long.valueOf(Str);
    System.out.println(lObj2);
            //Tickets newTicket=new Tickets(ticket.get(0).toString(),l,(ticket.get(2)).toString());
            //cubeTickets.add(newTicket);
        }
        for(int i=0;i<cubeTickets.size();i++){
            System.out.println(cubeTickets.get(i));
        }
    }
        
    public static void main(String[] args) throws Exception{
       Server ej1=new Server();
       ej1.checkPassword("ChriStian","Tortuguita");
        
    } 
}
