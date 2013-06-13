/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csl.datacore.util;

import org.springframework.stereotype.Service;

/**
 *
 * @author Deni Husni Fahri Rizal
 */

public class SpringIo {

    
    private String host;
    private String hostPort;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    public String getHostPort() {
        return hostPort;
    }
    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }
}
