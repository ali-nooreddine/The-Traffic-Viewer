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
@Table(name = "SETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sets.findAll", query = "SELECT s FROM Sets s"),
    @NamedQuery(name = "Sets.findById", query = "SELECT s FROM Sets s WHERE s.id = :id"),
    @NamedQuery(name = "Sets.findBySets", query = "SELECT s FROM Sets s WHERE s.sets = :sets")})
public class Sets implements Serializable {
    @OneToMany(mappedBy = "setsId")
    private Collection<News> newsCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "SETS")
    private String sets;
    @OneToMany(mappedBy = "setsId")
    private Collection<Jams> jamsCollection;

    public Sets() {
    }

    public Sets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    @XmlTransient
    public Collection<Jams> getJamsCollection() {
        return jamsCollection;
    }

    public void setJamsCollection(Collection<Jams> jamsCollection) {
        this.jamsCollection = jamsCollection;
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
        if (!(object instanceof Sets)) {
            return false;
        }
        Sets other = (Sets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sets[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }
    
}
