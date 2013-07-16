/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.service.serviceimplementasi;

import com.csl.datacore.dao.CityDao;
import com.csl.datacore.entity.City;
import com.csl.datacore.service.CityService;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Deni Husni FR
 */
@Service(value = "cityService")
public class CityServiceImplementasi implements CityService {

    private static final Logger LOGGER = Logger.getLogger(CityServiceImplementasi.class);
    @Autowired
    private CityDao cityDao;

    public City getByPkString(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City getByPkInteger(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City saveOrUpdate(City entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(City entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void softDelete(City entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllData(int firstResult, int maxResults, Order order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS,
            isolation = Isolation.SERIALIZABLE, timeout = 30)
    public Long getTotalData() throws Exception {
        try {
//            System.out.println("NIsidfidsifdsif "+this.cityDao1.getTotalData());
            return this.cityDao.getTotalData();
        } catch (Throwable e) {
//            LOGGER.error("Error", e);
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS,
            isolation = Isolation.REPEATABLE_READ, timeout = 30)
    public List<City> getAll(Order order) throws Exception {
        try {
            return this.cityDao.getAll(order);
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED, timeout = 30)
    public void saveOrUpdateVoid(City entity) throws Exception {
//        try {
        this.cityDao.saveOrUpdateVoid(entity);
//        } catch (Throwable e) {
//            throw new Exception(e.getMessage());
//        }
    }

    public City getByPkStringIsActive(String id, Byte b) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City getByPkIntegerIsActive(Integer id, Byte b) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllDataIsActive(int firstResult, int maxResults, Order order, Byte b) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getTotalDataIsActive(Byte b) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllIsActive(Order order, Byte b) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City getByPkStringIsActive(String id, Boolean isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City getByPkIntegerIsActive(Integer id, Boolean isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllDataIsActive(int firstResult, int maxResults, Order order, Boolean isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getTotalDataIsActive(Boolean isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllIsActive(Order order, Boolean isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City getByPkStringIsActive(String id, String isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public City getByPkIntegerIsActive(Integer id, String isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllDataIsActive(int firstResult, int maxResults, Order order, String isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getTotalDataIsActive(String isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<City> getAllIsActive(Order order, String isActive) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
