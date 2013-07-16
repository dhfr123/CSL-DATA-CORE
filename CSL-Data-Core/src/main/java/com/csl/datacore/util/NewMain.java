/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.util;

import com.csl.datacore.entity.City;
import com.csl.datacore.service.CityService;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author CSL
 */
public class NewMain {
 private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(NewMain.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        CityService cityService = (CityService) ServiceUtil.getService("cityService");
//        System.out.println("Jumlah Total Data City :"+cityService.getTotalData());
        LOGGER.info("Jumlah Total Data City :"+cityService.getTotalData());
        List<City> data=cityService.getAll(Order.asc("cityCode"));
        for (City city : data) {
            LOGGER.info("City :"+city.getCityName());
        }
//        City city = new City();
//        city.setCityCode("DFE");
//        try {
//            cityService.saveOrUpdateVoid(city);
//        } catch (Exception ex) {
//            LOGGER.error("Error", ex);
//        }
    }
}
