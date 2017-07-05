package com.walmart.reminder;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(JacksonFeatures.class);
        register(MarshallingFeature.class);
        packages("com.walmart.reminder");
    }
}
