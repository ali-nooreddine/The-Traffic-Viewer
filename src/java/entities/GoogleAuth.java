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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALI-NRD
 */
@Entity
@Table(name = "GOOGLE_AUTH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoogleAuth.findAll", query = "SELECT g FROM GoogleAuth g"),
    @NamedQuery(name = "GoogleAuth.findById", query = "SELECT g FROM GoogleAuth g WHERE g.id = :id"),
    @NamedQuery(name = "GoogleAuth.findByDisplayName", query = "SELECT g FROM GoogleAuth g WHERE g.displayName = :displayName"),
    @NamedQuery(name = "GoogleAuth.findByEmail", query = "SELECT g FROM GoogleAuth g WHERE g.email = :email"),
    @NamedQuery(name = "GoogleAuth.findByGender", query = "SELECT g FROM GoogleAuth g WHERE g.gender = :gender"),
    @NamedQuery(name = "GoogleAuth.findByIconUrl", query = "SELECT g FROM GoogleAuth g WHERE g.iconUrl = :iconUrl"),
    @NamedQuery(name = "GoogleAuth.findByProfileUrl", query = "SELECT g FROM GoogleAuth g WHERE g.profileUrl = :profileUrl")})
public class GoogleAuth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 5)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 200)
    @Column(name = "ICON_URL")
    private String iconUrl;
    @Size(max = 200)
    @Column(name = "PROFILE_URL")
    private String profileUrl;

    public GoogleAuth() {
    }

    public GoogleAuth(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
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
        if (!(object instanceof GoogleAuth)) {
            return false;
        }
        GoogleAuth other = (GoogleAuth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GoogleAuth[ id=" + id + " ]";
    }
    
}
