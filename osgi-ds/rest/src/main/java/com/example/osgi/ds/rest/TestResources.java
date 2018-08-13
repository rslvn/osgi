package com.example.osgi.ds.rest;

/**
 * Created by resulav on 13.08.2018.
 */

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import static org.slf4j.LoggerFactory.getLogger;


@Component(service=TestResources.class, property={"service.exported.interfaces=*",
        "service.exported.configs=org.apache.cxf.rs",
        "org.apache.cxf.rs.address=/test"})
public class TestResources extends Application {

    private final Logger logger = getLogger(getClass());

    @Activate
    void activate() {
        logger.info("{} activated", getClass().getTypeName());
    }

    @Deactivate
    void deactivate() {
        logger.info("{} deactivated", getClass().getTypeName());
    }

    @Modified
    void modified() {
        logger.info("{} modifed", getClass().getTypeName());
    }


    @GET
    @Path("hello")
    public String sayHello() {
        return "Hello from JAXRS";
    }
}
