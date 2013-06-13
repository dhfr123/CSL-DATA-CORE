/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.dao;

import java.util.List;
import org.hibernate.criterion.Order;

/**
 * Deni Husni Fahri Rizal. Semua Interface DAO khsusnya (Spring Hibernate)
 * extent dari BaseDAO. Dengan demikian methode-methode yang umum tertera pada
 * BaseDao tidak perlu dibuat di masing-masing Entity Dao.
 *
 * @author Deni Husni Fahri Rizal
 */
public interface BaseDao<T> {

    public T getByPkString(String id);

    public T getByPkInteger(Integer id);

    public T saveOrUpdate(T entity);

    public void delete(T entity);

    public void softDelete(T entity);

    public List<T> getAllData(int firstResult, int maxResults, Order order);

    public Long getTotalData();

    public List<T> getAll(Order order);

    public void saveOrUpdateVoid(T entity);

    public T getByPkStringIsActive(String id, Byte isActive);

    public T getByPkIntegerIsActive(Integer id, Byte isActive);

    public List<T> getAllDataIsActive(int firstResult, int maxResults, Order order, Byte isActive);

    public Long getTotalDataIsActive(Byte isActive);

    public List<T> getAllIsActive(Order order, Byte isActive);

    public T getByPkStringIsActive(String id, Boolean isActive);

    public T getByPkIntegerIsActive(Integer id, Boolean isActive);

    public List<T> getAllDataIsActive(int firstResult, int maxResults, Order order, Boolean isActive);

    public Long getTotalDataIsActive(Boolean isActive);

    public List<T> getAllIsActive(Order order, Boolean isActive);

    public T getByPkStringIsActive(String id, String isActive);

    public T getByPkIntegerIsActive(Integer id, String isActive);

    public List<T> getAllDataIsActive(int firstResult, int maxResults, Order order, String isActive);

    public Long getTotalDataIsActive(String isActive);

    public List<T> getAllIsActive(Order order, String isActive);
}
