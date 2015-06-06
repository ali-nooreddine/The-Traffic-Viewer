/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.NewsFacadeLocal;
import entities.News;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author ALI-NRD
 */
@Named(value = "allevents")
@Dependent
public class allevents {
@EJB NewsFacadeLocal news;
private List<News> allnews;

    public List<News> getAllnews() {
        allnews = news.findAll();
        return allnews;
    }

    public void setAllnews(ArrayList<News> allnews) {
        this.allnews = allnews;
    }
    
    public void remove (News news){
       this.news.remove(news);
    }
    
    public allevents() {
    }
    
}
