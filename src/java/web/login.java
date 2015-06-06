/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.UserrFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {
        private String username;
        private String password;
        @EJB UserrFacadeLocal user;
    /**
     * Creates a new instance of login
     * @return 
     */
    public String Validate(){
        if(user.authentication(username,password)==true){
        return "allmsg";
        }   
        else{
            FacesMessage fm = new FacesMessage("Wrong username or password");
            FacesContext.getCurrentInstance().addMessage("msg", fm);
            return null;
        }
            
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
