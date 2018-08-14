package com.example.osgi.ds.rest;

import static org.slf4j.LoggerFactory.getLogger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;

/**
 * Created by resulav on 13.08.2018.
 */

import com.example.osgi.ds.api.SampleService;

@Component(immediate = true,enabled = true,service = SampleResources.class, property = { "service.exported.interfaces=*",
		"service.exported.configs=org.apache.cxf.rs", "org.apache.cxf.rs.address=/sample" })

public class SampleResources {

	private final Logger logger = getLogger(getClass());

    @Reference
	private SampleService sampleService;

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
		return "Hello " + getClass().getTypeName();
	}

    @GET
    @Path("name")
    public String sayName() {
        return sampleService.getName();
    }
}
