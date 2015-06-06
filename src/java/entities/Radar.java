/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALI-NRD
 */
@Entity
@Table(name = "RADAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radar.findAll", query = "SELECT r FROM Radar r"),
    @NamedQuery(name = "Radar.findByRadarid", query = "SELECT r FROM Radar r WHERE r.radarid = :radarid"),
    @NamedQuery(name = "Radar.findByLocation", query = "SELECT r FROM Radar r WHERE r.location = :location")})
public class Radar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RADARID")
    private Integer radarid;
    @Size(max = 200)
    @Column(name = "LOCATION")
    private String location;
    @JoinColumn(name = "STREET_ID", referencedColumnName = "ID")
    @ManyToOne
    private Streets streetId;

    public Radar() {
    }

    public Radar(Integer radarid) {
        this.radarid = radarid;
    }

    public Integer getRadarid() {
        return radarid;
    }

    public void setRadarid(Integer radarid) {
        this.radarid = radarid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Streets getStreetId() {
        return streetId;
    }

    public void setStreetId(Streets streetId) {
        this.streetId = streetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (radarid != null ? radarid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radar)) {
            return false;
        }
        Radar other = (Radar) object;
        if ((this.radarid == null && other.radarid != null) || (this.radarid != null && !this.radarid.equals(other.radarid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Radar[ radarid=" + radarid + " ]";
    }
    
}
