/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Jams;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface JamsFacadeLocal {

    /**
     *
     * @param jams
     */
    void create(Jams jams);

    /**
     *
     * @param jams
     */
    void edit(Jams jams);

    /**
     *
     * @param jams
     */
    void remove(Jams jams);

    /**
     *
     * @param id
     * @return
     */
    Jams find(Object id);

    /**
     *
     * @return
     */
    List findLocation();

    /**
     *
     * @return
     */
    List<Jams> findSetsMorn();
    
    //List<Jams> findSetsEven();
    /**
     *
     * @return
     */
    List<Jams> findAll();

    /**
     *
     * @param range
     * @return
     */
    
    List<Jams> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();

   // List<Jams> findEven();

    
}
