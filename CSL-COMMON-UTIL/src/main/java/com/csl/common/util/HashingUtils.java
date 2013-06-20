/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Deni Husni Fahri Rizal
 */
public class HashingUtils {

    public static String getHashSHA256(String sha256) {
        return DigestUtils.sha256Hex(sha256);
    }

    public static String getHashSHA(String sha) {
        return DigestUtils.shaHex(sha);
    }

    public static String getHashMD5(String md5) {
        return DigestUtils.md5Hex(md5);
    }

    public static String getHashSHA512(String sha512) {
        return DigestUtils.sha512Hex(sha512);
    }

    public static String getHashASHA384(String sha384) {
        return DigestUtils.sha384Hex(sha384);
    }
}
