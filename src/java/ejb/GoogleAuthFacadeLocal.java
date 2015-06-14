/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.GoogleAuth;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface GoogleAuthFacadeLocal {

    void create(GoogleAuth googleAuth);

    void edit(GoogleAuth googleAuth);

    void remove(GoogleAuth googleAuth);

    GoogleAuth find(Object id);

    List<GoogleAuth> findAll();

    List<GoogleAuth> findRange(int[] range);

    int count();
    
}
