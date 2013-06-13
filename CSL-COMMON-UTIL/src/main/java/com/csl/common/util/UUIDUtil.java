/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.common.util;

import java.util.UUID;

/**
 *
 * @author Deni Husni Fahri Rizal
 */
public class UUIDUtil {

    public static String getRandomDataUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getRandomDataSubStringEndUUID(int endPosition) {
        return getRandomDataUUID().substring(0, endPosition);
    }

    public static String getRandomDataSubStringBeforeUUID(int beforePosition) {
        return getRandomDataUUID().substring(beforePosition, 0);
    }

    public static String getRandomDataAllParameter(int beforePosition, int endPosition) {
        return getRandomDataUUID().substring(beforePosition, endPosition);
    }
}
