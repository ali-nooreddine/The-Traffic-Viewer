/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.News;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALI-NRD
 */
@Local
public interface NewsFacadeLocal {

    /**
     *
     * @param news
     */
    void create(News news);

    /**
     *
     * @param news
     */
    void edit(News news);

    /**
     *
     * @param news
     */
    void remove(News news);

    /**
     *
     * @param id
     * @return
     */
    News find(Object id);

    /**
     *
     * @return
     */
    List<News> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<News> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
