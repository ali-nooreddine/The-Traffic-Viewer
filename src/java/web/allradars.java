/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.RadarFacadeLocal;
import entities.Radar;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "allradars")
@Dependent
public class allradars {
@EJB RadarFacadeLocal radarFacadeLocal;
private List<Radar> radar = new ArrayList<>();
    /**
     * Creates a new instance of allradars
     */
    public allradars() {
    }

    public List<Radar> getRadars() {
                radar=radarFacadeLocal.findAll();
        return radar;
    }

    public void setRadars(List<Radar> radar) {
        this.radar = radar;
    }
    
        public void remove(Radar radar){
        radarFacadeLocal.remove(radar);
    }
    
}
