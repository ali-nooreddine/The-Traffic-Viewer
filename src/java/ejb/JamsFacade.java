/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Jams;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ALI-NRD
 */
@Stateless
public class JamsFacade extends AbstractFacade<Jams> implements JamsFacadeLocal {

    @PersistenceContext(unitName = "TheTrafficViewerPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public JamsFacade() {
        super(Jams.class);
    }

    @Override
    public List<Jams> findEven() {
        Query query = em.createNamedQuery("Jams.findEven",Jams.class);
        return query.getResultList();
    }

}
