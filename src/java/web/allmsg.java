/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.MessageFacadeLocal;
import entities.Jams;
import entities.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "allmsg")
@SessionScoped
public class allmsg implements Serializable {
    
    @EJB MessageFacadeLocal msg;
    private List<Message> message = new ArrayList<>();
    
    /**
     * Creates a new instance of allmsg
     * @return 
     */

    public MessageFacadeLocal getMsg() {
        return msg;
    }

    public void setMsg(MessageFacadeLocal msg) {
        this.msg = msg;
    }

    public List<Message> getMessage() {
        message=msg.findAll();
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }    
    
    public void remove(Message message){
        msg.remove(message);
    }
}
