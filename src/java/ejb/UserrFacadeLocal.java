/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Userr;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface UserrFacadeLocal {

    void create(Userr userr);

    void edit(Userr userr);

    void remove(Userr userr);

    Userr find(Object id);

    List<Userr> findAll();

    List<Userr> findRange(int[] range);

    int count();
    
    public boolean authentication(String username, String password);
}
