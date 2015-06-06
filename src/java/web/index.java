package web;

import ejb.JamsFacadeLocal;
import ejb.NewsFacadeLocal;
import ejb.RadarFacadeLocal;
import entities.Jams;
import entities.News;
import entities.Radar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "index")
@SessionScoped
public class index implements Serializable {

    @EJB
    JamsFacadeLocal jams;
    @EJB
    NewsFacadeLocal news;
    @EJB
    RadarFacadeLocal radar;
    private List<Jams> jamsList = new ArrayList<>();
    private List<News> NewsList = new ArrayList<>();
    private List<Radar> RadarList = new ArrayList<>();
    private List<Jams> jamsListMorn = new ArrayList<>();
    private List<Jams> jamsListEven = new ArrayList<>();

    public List<Jams> getJamsListMorn() {
        jamsListMorn = jams.findSetsMorn();
        return jamsListMorn;
    }

    public void setJamsListMorn(List<Jams> jamsListMorn) {
        this.jamsListMorn = jamsListMorn;
    }

    public List<Jams> getJamsListEven() {
        //jamsListEven = jams.findEven();
        return jamsListEven;
    }

    public void setJamsListEven(List<Jams> jamsListEven) {
        this.jamsListEven = jamsListEven;
    }

    public List<Radar> getRadarList() {
        RadarList = radar.findAll();
        return RadarList;
    }

    public void setRadarList(List<Radar> RadarList) {
        this.RadarList = RadarList;
    }

    /**
     *
     * @return
     */
    public List<News> getNewsList() {
        NewsList = news.findAll();
        return NewsList;
    }

    /**
     *
     * @param NewsList
     */
    public void setNewsList(List<News> NewsList) {
        this.NewsList = NewsList;
    }

    /**
     *
     * @return
     */
    public List<Jams> getJamsList() {
        jamsList = jams.findAll();

        return jamsList;
    }

    /**
     *
     * @param JamsList
     */
    public void setJamsList(List<Jams> JamsList) {
        this.jamsList = JamsList;
    }

    /**
     *
     */
    public index() {
    }
}
