package com.example.osgi.ds.rest;

import static org.slf4j.LoggerFactory.getLogger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import com.example.osgi.ds.api.SampleService;
import com.example.osgi.ds.api.model.SampleConfig;
import com.example.osgi.ds.rest.util.RestUtility;

/**
 * Created by resulav on 13.08.2018.
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(SampleResources.SERVICE)
public class SampleResources {

	static final String SERVICE = "sample";

	static final String LOG_FORMAT = "{} called";

	private final Logger logger = getLogger(getClass());

	/**
	 * 
	 */
	public SampleResources() {
		super();
	}

	@GET
	@Path("hello")
	public String sayHello() {
		logger.info(LOG_FORMAT, "sayHello");
		return "Hello " + getClass().getTypeName();
	}

	@GET
	@Path("name")
	public String sayName() {
		logger.info(LOG_FORMAT, "sayHello");
		return RestUtility.getService(SampleService.class).getName();
	}

	@GET
	@Path("config")
	public SampleConfig getConfig() {
		logger.info(LOG_FORMAT, "getConfig");
		return RestUtility.getService(SampleService.class).getConfig();
	}
}
