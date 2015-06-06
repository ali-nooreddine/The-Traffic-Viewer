/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.Reportedradar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface ReportedradarFacadeLocal {

    void create(Reportedradar reportedradar);

    void edit(Reportedradar reportedradar);

    void remove(Reportedradar reportedradar);

    Reportedradar find(Object id);

    List<Reportedradar> findAll();

    List<Reportedradar> findRange(int[] range);

    int count();
    
}
