/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.StreetType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface StreetTypeFacadeLocal {

    void create(StreetType streetType);

    void edit(StreetType streetType);

    void remove(StreetType streetType);

    StreetType find(Object id);

    List<StreetType> findAll();

    List<StreetType> findRange(int[] range);

    int count();
    
}
