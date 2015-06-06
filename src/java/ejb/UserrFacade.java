/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Userr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author ALI-NRD
 */
@Stateless
public class UserrFacade extends AbstractFacade<Userr> implements UserrFacadeLocal {

    @PersistenceContext(unitName = "TheTrafficViewerPU")
    private EntityManager em;
    @Resource(name = "jdbc/TheTrafficViewer")
    private DataSource dbsource;
    private Connection dbconnect;

    @PostConstruct
    public void initialize() {
        try {
            dbconnect = dbsource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserrFacade() {
        super(Userr.class);
    }

    @Override
    public boolean authentication(String username, String password) {
        List<Userr> loginList = em.createNamedQuery("Userr.findAll").getResultList();
        Userr user;
        for (Userr loginList1 : loginList) {
            user = loginList1;
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

}
