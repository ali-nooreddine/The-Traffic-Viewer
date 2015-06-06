/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.NewsType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface NewsTypeFacadeLocal {

    void create(NewsType newsType);

    void edit(NewsType newsType);

    void remove(NewsType newsType);

    NewsType find(Object id);

    List<NewsType> findAll();

    List<NewsType> findRange(int[] range);

    int count();
    
}
