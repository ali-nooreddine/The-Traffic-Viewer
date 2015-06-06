/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.MessageFacadeLocal;
import entities.Message;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "contactus")
@SessionScoped
public class contactus implements Serializable {

    private String name;
    private String eMail;
    private String phNum;
    private String msg;
    private Message message;


    @EJB
    MessageFacadeLocal messageEJB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;

    }

    public void insert() {
        Message msg = new Message();
        msg.setId(Integer.SIZE);
        msg.setFullname(this.name);
        msg.setEmail(this.eMail);
        msg.setPhone(this.phNum);
        msg.setMessage(this.msg);
        //messageEJB.sendMessage(message);
        messageEJB.create(msg);
        //messageEJB.sendMessage(message);
        System.out.println("value: " + msg.getFullname());
        this.name="";
        this.eMail="";
        this.phNum="";
        this.msg="";
    }

    public contactus() {
    }
}
