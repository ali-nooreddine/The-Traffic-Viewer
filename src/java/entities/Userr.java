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
@Table(name = "USERR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userr.findAll", query = "SELECT u FROM Userr u"),
    @NamedQuery(name = "Userr.findById", query = "SELECT u FROM Userr u WHERE u.id = :id"),
    @NamedQuery(name = "Userr.findByUsername", query = "SELECT u FROM Userr u WHERE u.username = :username"),
    @NamedQuery(name = "Userr.findByPassword", query = "SELECT u FROM Userr u WHERE u.password = :password")})
public class Userr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "USERNAME")
    public String username;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    public String password;

    public Userr() {
    }

    public Userr(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Userr)) {
            return false;
        }
        Userr other = (Userr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userr[ id=" + id + " ]";
    }
    
}
