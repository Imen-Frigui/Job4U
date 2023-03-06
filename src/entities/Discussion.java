/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Imen Frigui
 */
public class Discussion {
   
    private int id_disc;
    private int id_sender;
    private int id_reciver;
    private String Nreciver;
    private String Nsender;
    private User sender;
    private User reciver;
    private Message message;

    public Discussion(int id_disc, User sender, User reciver, Message message) {
        this.id_disc = id_disc;
        this.sender = sender;
        this.reciver = reciver;
        this.message = message;
    }

    public Discussion(int id_disc, User sender, User reciver) {
        this.id_disc = id_disc;
        this.sender = sender;
        this.reciver = reciver;
    }
        public Discussion(int id_disc, String Nsender, String Nreciver) {
        this.id_disc = id_disc;
        this.Nsender = Nsender;
        this.Nreciver = Nreciver;
    }

    public Discussion(int id_disc, int id_sender, int id_reciver) {
        this.id_disc = id_disc;
        this.id_reciver = id_reciver;
        this.id_sender = id_sender;
    }

    public Discussion(int id_sender, int id_reciver) {
        this.id_reciver = id_reciver;
        this.id_sender = id_sender;
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

    public User getSender() {
        return sender;
    }

    public User getReciver() {
        return reciver;
    }

    public void setId_reciver(int id_reciver) {
        this.id_reciver = id_reciver;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReciver(User reciver) {
        this.reciver = reciver;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Discussion{" + "id_disc=" + id_disc + ", id_sender=" + id_sender + ", id_reciver=" + id_reciver + ", sender=" + sender + ", reciver=" + reciver + ", message=" + message + '}';
    }

    /**
     * @return the id_disc
     */
    public int getId_disc() {
        return id_disc;
    }

    /**
     * @return the Nreciver
     */
    public String getNreciver() {
        return Nreciver;
    }

    /**
     * @param Nreciver the Nreciver to set
     */
    public void setNreciver(String Nreciver) {
        this.Nreciver = Nreciver;
    }

    /**
     * @return the Nsender
     */
    public String getNsender() {
        return Nsender;
    }

    /**
     * @param Nsender the Nsender to set
     */
    public void setNsender(String Nsender) {
        this.Nsender = Nsender;
    }
    
}
