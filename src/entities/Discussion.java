/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author 
 */
public class Discussion {
    private int id_disc;
    private int id_sender;
    private int id_reciver;
        
    public Discussion(int id_disc,int id_sender, int id_reciver) {
        this.id_disc =id_disc;
        this.id_reciver=id_reciver;
        this.id_sender=id_sender;
    }

   public Discussion(int id_sender, int id_reciver) {
       this.id_reciver=id_reciver;
       this.id_sender=id_sender;
    }

    public Discussion() {
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
     * @return the id_reciver
     */
    public int getId_reciver() {
        return id_reciver;
    }

    /**
     * @param id_reciver the id_reciver to set
     */
    public void setId_revicer(int id_reciver) {
        this.id_reciver = id_reciver;
    }
        @Override
    public String toString() {
        return "Discussion{" + "Id_sender=" + id_sender + ", Id_revicer=" + id_reciver + '}';
    }

    /**
     * @return the id_disc
     */
    public int getId_disc() {
        return id_disc;
    }
    
}
