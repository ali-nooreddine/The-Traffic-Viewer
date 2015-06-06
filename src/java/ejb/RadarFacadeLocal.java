/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Radar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface RadarFacadeLocal {

    void create(Radar radar);

    void edit(Radar radar);

    void remove(Radar radar);

    Radar find(Object id);

    List<Radar> findAll();

    List<Radar> findRange(int[] range);

    int count();
    
}
