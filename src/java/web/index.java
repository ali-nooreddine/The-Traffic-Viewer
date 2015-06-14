package web;

import ejb.GoogleAuthFacadeLocal;
import ejb.JamsFacadeLocal;
import ejb.NewsFacadeLocal;
import ejb.RadarFacadeLocal;
import entities.GoogleAuth;
import entities.Jams;
import entities.News;
import entities.Radar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
    @EJB
    GoogleAuthFacadeLocal userEJB;
    private List<Jams> jamsList = new ArrayList<>();
    private List<News> NewsList = new ArrayList<>();
    private List<Radar> RadarList = new ArrayList<>();
    private List<Jams> jamsListMorn = new ArrayList<>();
    private List<Jams> jamsListEven = new ArrayList<>();

    private String displayName;
    private String email;
    private String userIconURL;
    private String gender;
    private String profileURL;

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

    public String getUserIconURL() {
        return userIconURL;
    }

    public void setUserIconURL(String userIconURL) {
        this.userIconURL = userIconURL;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    private GoogleAuth current;

    public GoogleAuth getCurrent() {
        return current;
    }

    public void setCurrent(GoogleAuth current) {
        this.current = current;
    }

    public void insertUserInfo() {
            System.out.println("adding variables " + getDisplayName() + " " + getEmail());
            GoogleAuth currentUser = new GoogleAuth();
            currentUser.setId(Integer.SIZE);
            currentUser.setDisplayName(getDisplayName());
            currentUser.setEmail(getEmail());
            currentUser.setGender(getGender());
            currentUser.setIconUrl(getUserIconURL());
            currentUser.setProfileUrl(getProfileURL());
            userEJB.create(currentUser);
    }
        public void insertUserInfo(String displayName, String email, String gender, String userIconUrl,
                String profileUrl) {
            System.out.println("adding variables " + getDisplayName() + " " + getEmail());
            GoogleAuth currentUser = new GoogleAuth();
            currentUser.setId(Integer.SIZE);
            currentUser.setDisplayName(displayName);
            currentUser.setEmail(email);
            currentUser.setGender(gender);
            currentUser.setIconUrl(userIconUrl);
            currentUser.setProfileUrl(profileUrl);
            userEJB.create(currentUser);
    }

    public List<Jams> getJamsListMorn() {
        jamsListMorn = jams.findSetsMorn();
        return jamsListMorn;
    }

    public void setJamsListMorn(List<Jams> jamsListMorn) {
        this.jamsListMorn = jamsListMorn;
    }

    public List<Jams> getJamsListEven() {
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
