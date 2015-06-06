/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ALI-NRD
 */
@Entity
@Table(name = "STREETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Streets.findAll", query = "SELECT s FROM Streets s"),
    @NamedQuery(name = "Streets.findById", query = "SELECT s FROM Streets s WHERE s.id = :id"),
    @NamedQuery(name = "Streets.findByName", query = "SELECT s FROM Streets s WHERE s.name = :name")})
public class Streets implements Serializable {
    @OneToMany(mappedBy = "streetId")
    private Collection<Reportedradar> reportedradarCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "streets")
    private Reportedradar reportedradar;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "streetId")
    private Collection<Jams> jamsCollection;
    @OneToMany(mappedBy = "street")
    private Collection<News> newsCollection;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private StreetType typeId;
    @OneToMany(mappedBy = "streetId")
    private Collection<Radar> radarCollection;

    public Streets() {
    }

    public Streets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Jams> getJamsCollection() {
        return jamsCollection;
    }

    public void setJamsCollection(Collection<Jams> jamsCollection) {
        this.jamsCollection = jamsCollection;
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    public StreetType getTypeId() {
        return typeId;
    }

    public void setTypeId(StreetType typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<Radar> getRadarCollection() {
        return radarCollection;
    }

    public void setRadarCollection(Collection<Radar> radarCollection) {
        this.radarCollection = radarCollection;
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
        if (!(object instanceof Streets)) {
            return false;
        }
        Streets other = (Streets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Streets[ id=" + id + " ]";
    }

    public Reportedradar getReportedradar() {
        return reportedradar;
    }

    public void setReportedradar(Reportedradar reportedradar) {
        this.reportedradar = reportedradar;
    }

    @XmlTransient
    public Collection<Reportedradar> getReportedradarCollection() {
        return reportedradarCollection;
    }

    public void setReportedradarCollection(Collection<Reportedradar> reportedradarCollection) {
        this.reportedradarCollection = reportedradarCollection;
    }
    
}
