/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Sets;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ALI-NRD
 */
@Stateless
public class SetsFacade extends AbstractFacade<Sets> implements SetsFacadeLocal {
    @PersistenceContext(unitName = "TheTrafficViewerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SetsFacade() {
        super(Sets.class);
    }
    
}
