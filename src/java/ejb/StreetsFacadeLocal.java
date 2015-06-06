/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Streets;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface StreetsFacadeLocal {

    void create(Streets streets);

    void edit(Streets streets);

    void remove(Streets streets);

    Streets find(Object id);

    List<Streets> findAll();

    List<Streets> findRange(int[] range);

    int count();
    
}
