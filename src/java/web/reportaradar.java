/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.ReportedradarFacadeLocal;
import entities.Streets;
import entities.Userr;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "reportaradar")
@Dependent
public class reportaradar {

    @EJB ReportedradarFacadeLocal reportedRadar;
    private Userr user;
    private Streets street;
    private String location;

    public Userr getUser() {
        return user;
    }

    public void setUser(Userr user) {
        this.user = user;
    }

    public Streets getStreet() {
        return street;
    }

    public void setStreet(Streets street) {
        this.street = street;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public reportaradar() {
    }
    
}
