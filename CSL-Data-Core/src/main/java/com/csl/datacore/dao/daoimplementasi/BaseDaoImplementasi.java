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
 * Semua Class DaoImplementasi merupakan turunan dari BaseDaoImplementasi. Semua
 * implementasi method BaseDao secara dinamik di implemenasi sesuai class
 * entitynya masing-masing. Ini di gunakan khusus untuk spring hibernate.
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
     * @return T berupa Class
     * @param kode id atau primary key dari entity
     * 
     */
    public T getByPkString(String kode) {
        return getHibernateTemplate().get(getEntityClass(), kode);
    }

    /**
     * Methode getClass berdasarkan Pk dengan tipe variable Integer
     *
     * @return T berupa Class
     * @param kode id atau primary key dari entity
     */
    public T getByPkInteger(Integer kode) {
        return getHibernateTemplate().get(getEntityClass(), kode);
    }

    /**
     * Methode untuk penyimpan data dan update data. Apabila datanya berupa data
     * baru maka method save akan dieksekusi. Jika data telah ada maka method update
     * yang akan di eksekusi.
     *
     * @return T berupa class
     * @param T class entity
     */
    public T saveOrUpdate(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
        return entity;
    }

    /**
     * Methode untuk menghapus Class dari Database.
     *
     * @return T berupa class
     * @param T class entity
     */
    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * Method delete secara soft dengan merubah isActive dari Y menjadi N.
     * Implementasi perubahan isActive dari Y menjadi N di service implementasi.
     *
     * @return void
     * @param T class entity
     */
    public void softDelete(T entity) {
        getHibernateTemplate().update(entity);
    }

    /**
     * Method untuk mengambil sejumlah data dari tiap-tiap object class
     * ditampung dalam Collection List. Banyaknya data di pagging dan di Order
     * berdasarkan awal indeks data mulai dari 0 sampai banyaknya data yang akan
     * di ambil. misalkan awal data=0 dan maksimum=10, maka akan keluar data dari
     * indeks 0 sampai indeks 9. Ordering ascending dan Descending
     *
     * @return List<T> berupa kumpulan T class.
     * @param firstResult berupa integer indeks awal.
     * @param maxResults berupa integer maksimum jumlah data yang diquery.
     * @param order berupa object class Order bernilai asc dan desc.
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
     * Method untuk mengambil semua data yang ada di database untuk class-class
     * tertentu.
     *
     * @param order berupa Class Order.asc - Order.desc.
     * @return List<T> list of Object
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
     * data baru maka method save akan dieksekusi. Jika data telah ada maka method
     * update yang akan di eksekusi.
     *
     * @param entity berupa class entity
     * @return void
     */
    public void saveOrUpdateVoid(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    /**
     * Method untuk mengambil data berdasarkan Primary Key (PK) dan berdasarkan
     * data attribute isActive 
     * 
     * @return T berupa class
     * @param id primary key dari entity
     * @param b isActive dengan tipe data byte
     * 
     */
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

    /**
     * Method untuk mengambil data berdasarkan PK (Integer) dan data attribute isActive
     * @return T berupa class
     * @param id primary key berupa integer
     * @param b isActive attribute dengan type date byte
     *
     */
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

    /**
     * Method untuk mengambil sejumlah data dari tiap-tiap object class
     * ditampung dalam Collection List. Banyaknya data di pagging dan di Order
     * berdasarkan awal indeks data mulai dari 0 sampai banyaknya data yang akan
     * di ambil. misalkan awal data=0 dan maksimum=10, maka akan keluar data dari
     * indeks 0 sampai indeks 9. Ordering ascending dan Descending
     * 
     * @return List<T> list data 
     * @param firstResult indeks awal berupa integer
     * @param maxResults maksimum jumlah data yang di query
     * @param order sorting data berupa Order.asc - Order.desc
     * @param b attribute isActive (byte)
     *
     */
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

    /**
     * Method untuk mengambil total data berdasarkan attribute isActive
     * @return Long jumlah data yang didapat
     * @param b berdasarkan attribute isActive (byte)
     */
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

    /**
     * Method untuk mengambil data bedasarkan attribute isActive dan Sorting data yang di peroleh
     * @return List<T> list of class
     * @param order sort type, Order.asc - Order.desc
     * @param b isActive attribute (byte)
     */
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
    
    /**
     * Method untuk mengambil data berdasarkan PK dan attribute isActive
     * @return T unique result, berupa class
     * @param id primary key berupa string
     * @param isActive attribute isActive berupa boolean
     */
    public T getByPkStringIsActive(final String id, final Boolean isActive){
        Object o = getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(getEntityClass());
                criteria.add(Restrictions.eq("id", id));
                criteria.add(Restrictions.eq("isActive", isActive));
                return criteria.uniqueResult();
            }
        });
        
        return (T) o;
    }
    
    /**
     * Method untuk mengambil data berdasarkan PK dan isActive attribute
     * @return T unique result, berupa class
     * @param id PK attribute berupa integer
     * @param isActive isActive attribute berupa boolean
     * 
     */
     public T getByPkIntegerIsActive(final Integer id, final Boolean isActive) {
         Object o = getHibernateTemplate().execute(new HibernateCallback() {

             @Override
             public Object doInHibernate(Session session) throws HibernateException, SQLException {
                 Criteria criteria = session.createCriteria(getEntityClass());
                 criteria.add(Restrictions.eq("id", id));
                 criteria.add(Restrictions.eq("isActive", isActive));
                 return criteria.uniqueResult();
             }
         });
         
         return (T) o;
     }
     
     /**
     * Method untuk mengambil sejumlah data dari tiap-tiap object class
     * ditampung dalam Collection List. Banyaknya data di pagging dan di Order
     * berdasarkan awal indeks data mulai dari 0 sampai banyaknya data yang akan
     * di ambil. misalkan awal data=0 dan maksimum=10, maka akan keluar data dari
     * indeks 0 sampai indeks 9. Ordering ascending dan Descending
     * 
     * @return List<T> list data 
     * @param firstResult indeks awal berupa integer
     * @param maxResults maksimum jumlah data yang di query
     * @param order sorting data berupa Order.asc - Order.desc
     * @param b attribute isActive (Boolean)
     *
     */
      public List<T> getAllDataIsActive(final int firstResult,final int maxResults,final Order order,final Boolean isActive){
          Object o = getHibernateTemplate().execute(new HibernateCallback() {

              @Override
              public Object doInHibernate(Session session) throws HibernateException, SQLException {
                  Criteria criteria = session.createCriteria(getEntityClass());
                  criteria.addOrder(order);
                  criteria.add(Restrictions.isNotNull("id"));
                  criteria.add(Restrictions.eq("isActive", isActive));
                  criteria.setFirstResult(firstResult);
                  criteria.setMaxResults(maxResults);
                  return criteria.list();
              }
          });
          
          return (List<T>) o;
      }
      
      /**
     * Method untuk mengambil total data berdasarkan attribute isActive
     * @return Long jumlah data yang didapat
     * @param isActive berdasarkan attribute isActive (Boolean)
     */
      public Long getTotalDataIsActive(final Boolean isActive){
          Object o = getHibernateTemplate().execute(new HibernateCallback() {

              @Override
              public Object doInHibernate(Session session) throws HibernateException, SQLException {
                  Criteria criteria = session.createCriteria(getEntityClass());
                  criteria.add(Restrictions.isNotNull("id"));
                  criteria.add(Restrictions.eq("isActive", isActive));
                  return criteria.setProjection(Projections.rowCount()).uniqueResult();
              }
          });
          
          return (Long) o;
      }
      
     /**
     * Method untuk mengambil data bedasarkan attribute isActive dan Sorting data yang di peroleh
     * @return List<T> list of class
     * @param order sort type, Order.asc - Order.desc
     * @param b isActive attribute (Boolean)
     */
      public List<T> getAllIsActive(final Order order, final Boolean isActive){
          Object o = getHibernateTemplate().execute(new HibernateCallback() {

              @Override
              public Object doInHibernate(Session session) throws HibernateException, SQLException {
                  Criteria criteria = session.createCriteria(getEntityClass());
                  criteria.addOrder(order);
                  criteria.add(Restrictions.isNotNull("id"));
                  criteria.add(Restrictions.eq("isActive", isActive));
                  return criteria.list();
              }
          });
          
          return (List<T>) o;
      }
      
      /**
     * Method untuk mengambil data berdasarkan PK dan attribute isActive
     * @return T unique result, berupa class
     * @param id primary key berupa string
     * @param isActive attribute isActive berupa String
     */
      public T getByPkStringIsActive(final String id, final String isActive){
          Object o = getHibernateTemplate().execute(new HibernateCallback() {

              @Override
              public Object doInHibernate(Session session) throws HibernateException, SQLException {
                  Criteria criteria = session.createCriteria(getEntityClass());
                  criteria.add(Restrictions.eq("id", id));
                  criteria.add(Restrictions.eq("isActive", isActive));
                  return criteria.uniqueResult();
              }
          });
          
          return (T) o;
      }
      
     /**
     * Method untuk mengambil data berdasarkan PK dan attribute isActive
     * @return T unique result, berupa class
     * @param id primary key berupa Integer
     * @param isActive attribute isActive berupa String
     */
      public T getByPkIntegerIsActive(final Integer id,final String isActive){
          Object o = getHibernateTemplate().execute(new HibernateCallback() {

              @Override
              public Object doInHibernate(Session session) throws HibernateException, SQLException {
                  Criteria criteria = session.createCriteria(getEntityClass());
                  criteria.add(Restrictions.eq("id", id));
                  criteria.add(Restrictions.eq("isActive", isActive));
                  return criteria.uniqueResult();
              }
          });
          
          return (T) o;
      }
      
      /**
     * Method untuk mengambil sejumlah data dari tiap-tiap object class
     * ditampung dalam Collection List. Banyaknya data di pagging dan di Order
     * berdasarkan awal indeks data mulai dari 0 sampai banyaknya data yang akan
     * di ambil. misalkan awal data=0 dan maksimum=10, maka akan keluar data dari
     * indeks 0 sampai indeks 9. Ordering ascending dan Descending
     * 
     * @return List<T> list data 
     * @param firstResult indeks awal berupa integer
     * @param maxResults maksimum jumlah data yang di query
     * @param order sorting data berupa Order.asc - Order.desc
     * @param isActive attribute isActive (String)
     *
     */
      public List<T> getAllDataIsActive(final int firstResult, final int maxResults, final Order order, final String isActive){
          Object o = getHibernateTemplate().execute(new HibernateCallback() {

              @Override
              public Object doInHibernate(Session session) throws HibernateException, SQLException {
                  Criteria criteria = session.createCriteria(getEntityClass());
                  criteria.addOrder(order);
                  criteria.add(Restrictions.isNotNull("id"));
                  criteria.add(Restrictions.eq("isActive", isActive));
                  criteria.setFirstResult(firstResult);
                  criteria.setMaxResults(maxResults);
                  return criteria.list();
              }
          });
          
          return (List<T>) o;
      }
      
      /**
     * Method untuk mengambil total data berdasarkan attribute isActive
     * @return Long jumlah data yang didapat
     * @param isActive berdasarkan attribute isActive (String)
     */
      public Long getTotalDataIsActive(final String isActive){
           Object o = getHibernateTemplate().execute(new HibernateCallback() {

               @Override
               public Object doInHibernate(Session session) throws HibernateException, SQLException {
                   Criteria criteria = session.createCriteria(getEntityClass());
                   criteria.add(Restrictions.isNotNull("id"));
                   criteria.add(Restrictions.eq("isActive", isActive));
                   return criteria.setProjection(Projections.rowCount()).uniqueResult();
               }
           });
           
           return (Long) o;
       }
       
      /**
     * Method untuk mengambil data bedasarkan attribute isActive dan Sorting data yang di peroleh
     * @return List<T> list of class
     * @param order sort type, Order.asc - Order.desc
     * @param b isActive attribute (String)
     */
       public List<T> getAllIsActive(final Order order, final String isActive){
           Object o = getHibernateTemplate().execute(new HibernateCallback() {

               @Override
               public Object doInHibernate(Session session) throws HibernateException, SQLException {
                   Criteria criteria = session.createCriteria(getEntityClass());
                   criteria.addOrder(order);
                   criteria.add(Restrictions.isNotNull("id"));
                   criteria.add(Restrictions.eq("isActive", isActive));
                   return criteria.list();
               }
           });
           
           return (List<T>) o;
       }
}
