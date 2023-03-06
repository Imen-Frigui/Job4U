/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Imen Frigui
 */
public class Message {
    private int id_mesg;
    private int id_disc;
    private int id_sender;
    private String message;


    public Message(int id_mesg, int id_disc, int id_sender, String message) {
        this.id_mesg =id_mesg;
        this.id_disc=id_disc;
        this.id_sender=id_sender;
        this.message=message;

    }

    public Message(int id_disc, int id_sender, String message) {
        this.id_disc=id_disc;
        this.id_sender=id_sender;
        this.message=message;
    }
   
    public Message(int id_sender, String message) {
        this.id_sender=id_sender;
        this.message=message;
    }
    

    public Message() {
    }

    @Override
    public String toString() {
        return  "Message{" + "contenu_msg=" + getMessage()+", id_disc="+getId_disc()+", id_sender"+getId_sender();
    }

    /**
     * @return the id_mesg
     */
    public int getId_mesg() {
        return id_mesg;
    }

    /**
     * @param id_mesg the id_mesg to set
     */
    public void setId_mesg(int id_mesg) {
        this.id_mesg = id_mesg;
    }

    /**
     * @return the id_disc
     */
    public int getId_disc() {
        return id_disc;
    }

    /**
     * @param id_disc the id_disc to set
     */
    public void setId_disc(int id_disc) {
        this.id_disc = id_disc;
    }

    /**
     * @return the id_sender
     */
    public int getId_sender() {
        return id_sender;
    }

    /**
     * @param id_sender the id_sender to set
     */
    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
