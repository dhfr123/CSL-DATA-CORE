/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.service;

import java.util.List;
import org.hibernate.criterion.Order;

/**
 * BaseService all Service is extend from BaseService.
 *
 * @author Deni Husni Fahri Rizal
 */
public interface BaseService<T> {

    public T getByPkString(String id) throws Exception;

    public T getByPkInteger(Integer id) throws Exception;

    public T saveOrUpdate(T entity) throws Exception;

    public void delete(T entity) throws Exception;

    public void softDelete(T entity) throws Exception;

    public List<T> getAllData(int firstResult, int maxResults, Order order) throws Exception;

    public Long getTotalData() throws Exception;

    public List<T> getAll(Order order) throws Exception;

    public void saveOrUpdateVoid(T entity) throws Exception;

    public T getByPkStringIsActive(String id, Byte b) throws Exception;

    public T getByPkIntegerIsActive(Integer id, Byte b) throws Exception;

    public List<T> getAllDataIsActive(int firstResult, int maxResults, Order order, Byte b) throws Exception;

    public Long getTotalDataIsActive(Byte b) throws Exception;

    public List<T> getAllIsActive(Order order, Byte b) throws Exception;
    
    public T getByPkStringIsActive(String id, Boolean isActive) throws Exception;

    public T getByPkIntegerIsActive(Integer id, Boolean isActive) throws Exception;

    public List<T> getAllDataIsActive(int firstResult, int maxResults, Order order, Boolean isActive)  throws Exception;

    public Long getTotalDataIsActive(Boolean isActive) throws Exception;

    public List<T> getAllIsActive(Order order, Boolean isActive) throws Exception;

    public T getByPkStringIsActive(String id, String isActive) throws Exception;

    public T getByPkIntegerIsActive(Integer id, String isActive) throws Exception;

    public List<T> getAllDataIsActive(int firstResult, int maxResults, Order order, String isActive) throws Exception;

    public Long getTotalDataIsActive(String isActive) throws Exception;

    public List<T> getAllIsActive(Order order, String isActive) throws Exception;

}
