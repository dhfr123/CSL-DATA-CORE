/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.dao.daoimplementasi;

import com.csl.datacore.dao.CityDao;
import com.csl.datacore.entity.City;

/**
 *
 * @author Deni Husni Fahri Rizal
 */
public class CityDaoImplementasi extends BaseDaoImplementasi<City> implements CityDao {

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
