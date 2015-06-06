/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "STREET_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StreetType.findAll", query = "SELECT s FROM StreetType s"),
    @NamedQuery(name = "StreetType.findById", query = "SELECT s FROM StreetType s WHERE s.id = :id"),
    @NamedQuery(name = "StreetType.findByType", query = "SELECT s FROM StreetType s WHERE s.type = :type")})
public class StreetType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "typeId")
    private Collection<Streets> streetsCollection;

    public StreetType() {
    }

    public StreetType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Streets> getStreetsCollection() {
        return streetsCollection;
    }

    public void setStreetsCollection(Collection<Streets> streetsCollection) {
        this.streetsCollection = streetsCollection;
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
        if (!(object instanceof StreetType)) {
            return false;
        }
        StreetType other = (StreetType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StreetType[ id=" + id + " ]";
    }
    
}
