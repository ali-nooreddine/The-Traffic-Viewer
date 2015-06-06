/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Sets;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface SetsFacadeLocal {

    void create(Sets sets);

    void edit(Sets sets);

    void remove(Sets sets);

    Sets find(Object id);

    List<Sets> findAll();

    List<Sets> findRange(int[] range);

    int count();
    
}
