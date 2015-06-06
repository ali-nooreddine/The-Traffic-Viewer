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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
@Table(name = "JAMS")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "Jams.findAll", query = "select id,location,speed,\n"
            + "(select name from streets where STREETS.id=jams.street_id) as name,\n"
            + "(select type from STREET_TYPE where STREET_TYPE.id = \n"
            + "(select type_id from STREETS where STREETS.id=jams.STREET_ID)) as type,\n"
            + "(select sets from \"SETS\" where sets.ID=jams.SETS_ID) as sets\n"
            + "from APP.JAMS"),
    @NamedNativeQuery(name = "Jams.findEven", query = "select id,location,speed,\n"
            + "(select name from streets where STREETS.id=jams.street_id) as name,\n"
            + "(select type from STREET_TYPE where STREET_TYPE.id = \n"
            + "(select type_id from STREETS where STREETS.id=jams.STREET_ID)) as type,\n"
            + "(select sets from \"SETS\" where sets.ID=2) as sets\n"
            + "from APP.JAMS"),
    @NamedNativeQuery(name = "Jams.findMorn", query = "select id,location,speed,\n"
            + "(select name from streets where STREETS.id=jams.street_id) as name,\n"
            + "(select type from STREET_TYPE where STREET_TYPE.id = \n"
            + "(select type_id from STREETS where STREETS.id=jams.STREET_ID)) as type,\n"
            + "(select sets from \"SETS\" where sets.ID=1) as sets\n"
            + "from APP.JAMS"),
    @NamedNativeQuery(name = "Jams.findMid", query = "select id,location,speed,\n"
            + "(select name from streets where STREETS.id=jams.street_id) as name,\n"
            + "(select type from STREET_TYPE where STREET_TYPE.id = \n"
            + "(select type_id from STREETS where STREETS.id=jams.STREET_ID)) as type,\n"
            + "(select sets from \"SETS\" where sets.ID=3) as sets\n"
            + "from APP.JAMS")})

@NamedQueries({
    // @NamedQuery(name = "Jams.findAll", query = "SELECT j FROM Jams j"),
    @NamedQuery(name = "Jams.findById", query = "SELECT j FROM Jams j WHERE j.id = :id"),
    @NamedQuery(name = "Jams.findByLocation", query = "SELECT j FROM Jams j WHERE j.location = :location"),
    @NamedQuery(name = "Jams.findBySpeed", query = "SELECT j FROM Jams j WHERE j.speed = :speed")})
public class Jams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "SPEED")
    private Integer speed;
    @JoinColumn(name = "STREET_ID", referencedColumnName = "ID")
    @ManyToOne
    private Streets streetId;
    @JoinColumn(name = "SETS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Sets setsId;

    public Jams() {
    }

    public Jams(Integer id) {
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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Streets getStreetId() {
        return streetId;
    }

    public void setStreetId(Streets streetId) {
        this.streetId = streetId;
    }

    public Sets getSetsId() {
        return setsId;
    }

    public void setSetsId(Sets setsId) {
        this.setsId = setsId;
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
        if (!(object instanceof Jams)) {
            return false;
        }
        Jams other = (Jams) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Jams[ id=" + id + " ]";
    }

}
