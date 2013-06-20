/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ServiceUtil adalah class untuk mendapatkan instance Object yang dimanage sama spring.
 * 
 * @author Deni Husni Fahri Rizal
 * @param ApplicationContext spring context
 * @param pathappcontext alamat atau path ApplicationContext 
 * 
 */
public class ServiceUtil {

    private static ApplicationContext appContext;

    public static ApplicationContext getApplicationContext() {
        if (appContext == null) {
            appContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        }
        return appContext;
    }

    
    /**
     * Methode untuk mendapatkan object service dari setiap Class atau Interface yang di manage sama Spring.
     * <p><b>Contoh Code:</b>
     * <br/>SpringIO springIO=(SpringIO) ServiceUtil.getService("springIO");
     * <br/>springIO.getSomeThing();
     * 
     * 
     * @param beansName nama dari interface atau class yang akan di ambil object nya
     * @return berupa Object sesuai dengan nama class atau interface yang di panggil.
     */
    public static Object getService(String beansName) {
        return getApplicationContext().getAutowireCapableBeanFactory().getBean(beansName);

    }
}
