/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.dao.daoimplementasi;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Semua Class DaoImplementasi merupakan turunan dari BaseDaoImplemenasi. Semua
 * implementasi methode BaseDao secara dinamik di implemenasi sesuai class
 * entitynya masing-masing. Ini di gunakan khsusu untuk spring hibernate.
 *
 * @author Deni Husni Fahri Rizal
 * @param T berupa Class Entity.
 */
public abstract class BaseDaoImplementasi<T> extends HibernateDaoSupport {

    /**
     * Methode untuk mendapatkan object class on running
     *
     * @param T berupa Class
     */
    public abstract Class<T> getEntityClass();

    /**
     * Methode getClass berdasarkan Pk dengan tipe variable String
     *
     * @param T berupa Class
     */
    public T getByPkString(String kode) {
        return getHibernateTemplate().get(getEntityClass(), kode);
    }

    /**
     * Methode getClass berdasarkan Pk dengan tipe variable Integer
     *
     * @param T berupa Class
     */
    public T getByPkInteger(Integer kode) {
        return getHibernateTemplate().get(getEntityClass(), kode);
    }

    /**
     * Methode untuk penyimpan data dan update data. Apabila datanya berupa data
     * baru maka method save dieksekusi. Jika data telah ada maka method update
     * yang di eksekusi.
     *
     * @param T berupa class
     * @return T beruoa class
     */
    public T saveOrUpdate(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
        return entity;
    }

    /**
     * Methode untuk mendelete Clsss dari Database.
     *
     * @param T berupa Class
     */
    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * Method delete secara soft dengan merubah isActive dari Y menjadi N.
     * Implemetnasi perubahan isActive dari Y menjadi N di service implementasi.
     *
     * @param T berupa Class
     */
    public void softDelete(T entity) {
        getHibernateTemplate().update(entity);
    }

    /**
     * Method untuk mengambil sejumlah data dari tiap-tiap object class
     * ditampung dalam Coleectioan List. Banyaknya data di pagging dan di Oreder
     * berdasarkan awal indeks data mulai dari 0 sampai banyaknya data yang akan
     * di ambil. misalkan awal data=0 dan maksimu=10, maka akan keluar data dari
     * indeks 0 sampai indeks 9. Ordering ascending dan Descending
     *
     * @return List<T> berupa kumpulsn T class.
     * @param firstResult berupa integer indeks awal.
     * @param maxResults berupa integer maksimum jumlah data yang diquery.
     * @param order berupa object class Order bernikai asc dan desc.
     */
    public List<T> getAllData(final int firstResult, final int maxResults, final Order order) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.addOrder(order);
                criteria.add(Restrictions.isNotNull("id"));
                criteria.setFirstResult(firstResult);
                criteria.setMaxResults(maxResults);
                return criteria.list();
            }
        });
        return (List<T>) o;

    }

    /**
     * Method untuk mengambil total data
     *
     *
     * @param T berupa Class.
     * @return totalData berupa Long.
     */
    public Long getTotalData() {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                return session.createCriteria(getEntityClass()).add(Restrictions.isNotNull("id"))
                        .setProjection(Projections.rowCount()).uniqueResult();
            }
        });

        return (Long) o;
    }

    /**
     * Method untuk mengambil semuad data yang ada di database untuk class-class
     * tertentu.
     *
     * @param T berupa Class.
     */
    public List<T> getAll(final Order order) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.addOrder(order);
                criteria.add(Restrictions.isNotNull("id"));
                return criteria.list();
            }
        });
        return (List<T>) o;
    }

    /**
     * Methode void untuk penyimpan data dan update data. Apabila datanya berupa
     * data baru maka method save dieksekusi. Jika data telah ada maka method
     * update yang di eksekusi.
     *
     * @param T berupa class
     * @return T beruoa class
     */
    public void saveOrUpdateVoid(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    public T getByPkStringIsActive(final String id, final Byte b) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.add(Restrictions.eq("id", id));
                criteria.add(Restrictions.eq("isActive", b));
                return criteria.uniqueResult();
            }
        });
        return (T) o;
    }

    public T getByPkIntegerIsActive(final Integer id, final Byte b) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.add(Restrictions.eq("id", id));
                criteria.add(Restrictions.eq("isActive", b));
                return criteria.uniqueResult();
            }
        });
        return (T) o;
    }

    public List<T> getAllDataIsActive(final int firstResult, final int maxResults, final Order order, final Byte b) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.addOrder(order);
                criteria.add(Restrictions.eq("isActive", b));
                criteria.add(Restrictions.isNotNull("id"));
                criteria.setFirstResult(firstResult);
                criteria.setMaxResults(maxResults);
                return criteria.list();
            }
        });
        return (List<T>) o;
    }

    public Long getTotalDataIsActive(final Byte b) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                return session.createCriteria(getEntityClass())
                        .add(Restrictions.isNotNull("id"))
                        .add(Restrictions.eq("isActive", b))
                        .setProjection(Projections.rowCount()).uniqueResult();
            }
        });

        return (Long) o;
    }

    public List<T> getAllIsActive(final Order order, final Byte b) {
        Object o = getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.addOrder(order);
                criteria.add(Restrictions.eq("isActive", b));
                criteria.add(Restrictions.isNotNull("id"));
                return criteria.list();
            }
        });
        return (List<T>) o;
    }
}
