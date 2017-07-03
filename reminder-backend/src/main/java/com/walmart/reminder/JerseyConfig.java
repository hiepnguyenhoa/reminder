package com.walmart.reminder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import javax.ws.rs.ApplicationPath;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        packages("com.walmart.reminder");
    }
}
