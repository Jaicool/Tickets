/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicModel;

/**
 *
 * @author YorleydeMaría
 */
public class Tickets {
    private String type;
    private long ID;
    private String state;
    private long client_ID;
    private String Comments;
    private long attEmployee_ID;
    private String dateHourIn;
    private String dateHourAttend;
    private long TimeSpent;
    private String Subject;
    

    public Tickets(String dateHourReceived, long client_ID,String pSubject) {
        this.ID = ID;// cambiar a static
        this.Subject = pSubject;
        this.state = "pending";
        this.client_ID = client_ID; 
        this.dateHourIn = dateHourReceived;  //aca seria obtenida por el sistema?!! o lo que se escriba??
    }
    public void Print(){
        System.out.println(dateHourIn+Subject+client_ID);
    }

    public String getSubject() {
        return Subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getID() {
        return ID;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public long getClient_ID() {
        return client_ID;
    }
    public String getComments() {
        return Comments;
    }
    public void setComments(String Comments) {
        this.Comments = Comments;
    }
    public long getAttEmployee_ID() {
        return attEmployee_ID;
    }
    public void setAttEmployee_ID(long attEmployee_ID) {
        this.attEmployee_ID = attEmployee_ID;
    }
    public String getDateHourIn() {
        return dateHourIn;
    }

    public void setDateHourIn(String dateHourIn) {
        this.dateHourIn = dateHourIn;
    }

    public String getDateHourAttend() {
        return dateHourAttend;
    }

    public void setDateHourAttend(String dateHourAttend) {
        this.dateHourAttend = dateHourAttend;
    }

    public long getTimeSpent() {
        return TimeSpent;
    }

    public void setTimeSpent(long TimeSpent) {
        this.TimeSpent = TimeSpent;
    }
    
}
