/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "NEWS")
@XmlRootElement
@NamedNativeQuery(name="News.findAll1",query = "select title, description, image, location, name, type  from APP.NEWS left Join STREETS on news.STREET_ID = STREETS.ID left join STREET_TYPE on STREETS.TYPE_ID=STREET_TYPE.ID;")
/*@NamedQueries({
   // @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsId", query = "SELECT n FROM News n WHERE n.newsId = :newsId"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByDescription", query = "SELECT n FROM News n WHERE n.description = :description"),
    @NamedQuery(name = "News.findByImage", query = "SELECT n FROM News n WHERE n.image = :image"),
    @NamedQuery(name = "News.findByLocation", query = "SELECT n FROM News n WHERE n.location = :location")})*/
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NEWS_ID")
    private Integer newsId;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "IMAGE")
    private String image;
    @Size(max = 100)
    @Column(name = "LOCATION")
    private String location;
    @JoinColumn(name = "STREET_ID", referencedColumnName = "ID")
    @ManyToOne
    private Streets street;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private NewsType typeId;
    
    @JoinColumn(name = "SETS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Sets setsId;

    public Streets getStreet() {
        return street;
    }

    public void setStreet(Streets street) {
        this.street = street;
    }

    public Sets getSetsId() {
        return setsId;
    }

    public void setSetsId(Sets setsId) {
        this.setsId = setsId;
    }

    public News() {
    }

    public News(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Streets getStreetId() {
        return street;
    }

    public void setStreetId(Streets streetId) {
        this.street = streetId;
    }

    public NewsType getTypeId() {
        return typeId;
    }

    public void setTypeId(NewsType typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.News[ newsId=" + newsId + " ]";
    }
    
}
