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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALI-NRD
 */
@Entity
@Table(name = "REPORTEDRADAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportedradar.findAll", query = "SELECT r FROM Reportedradar r"),
    @NamedQuery(name = "Reportedradar.findById", query = "SELECT r FROM Reportedradar r WHERE r.id = :id"),
    @NamedQuery(name = "Reportedradar.findByLocation", query = "SELECT r FROM Reportedradar r WHERE r.location = :location"),
    @NamedQuery(name = "Reportedradar.findByUserId", query = "SELECT r FROM Reportedradar r WHERE r.userId = :userId")})
public class Reportedradar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "USER_ID")
    private Integer userId;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Streets streets;
    @JoinColumn(name = "STREET_ID", referencedColumnName = "ID")
    @ManyToOne
    private Streets streetId;

    public Reportedradar() {
    }

    public Reportedradar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Streets getStreets() {
        return streets;
    }

    public void setStreets(Streets streets) {
        this.streets = streets;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportedradar)) {
            return false;
        }
        Reportedradar other = (Reportedradar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reportedradar[ id=" + id + " ]";
    }
    
}
