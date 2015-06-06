package web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.RadarFacadeLocal;
import ejb.ReportedradarFacadeLocal;
import entities.Radar;
import entities.Reportedradar;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "reportedradar")
@Dependent
public class reportedradar {

@EJB ReportedradarFacadeLocal reportedRadarEJB;
private List<Reportedradar> reportedRadarlist;
@EJB RadarFacadeLocal radarEJB; 

    public List<Reportedradar> getReportedRadarlist() {
        return reportedRadarEJB.findAll();
    }

    public void setReportedRadarlist(List<Reportedradar> reportedRadarlist) {
        this.reportedRadarlist = reportedRadarlist;
    }
    
    public void remove(Reportedradar radar){
        reportedRadarEJB.remove(radar);
    }
    
    public void add(Reportedradar reportedradar){
        Radar radar = new Radar();
        radar.setLocation(reportedradar.getLocation());
        radar.setStreetId(reportedradar.getStreets());
        radarEJB.create(radar);
        reportedRadarEJB.remove(reportedradar);
    }
    
    
    public reportedradar() {
    } 
}
