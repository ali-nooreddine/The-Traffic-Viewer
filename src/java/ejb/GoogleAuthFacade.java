/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.GoogleAuth;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ALI-NRD
 */
@Stateless
public class GoogleAuthFacade extends AbstractFacade<GoogleAuth> implements GoogleAuthFacadeLocal {
    @PersistenceContext(unitName = "TheTrafficViewerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GoogleAuthFacade() {
        super(GoogleAuth.class);
    }
    
}
