package com.example.osgi.ds.rest;

import static org.slf4j.LoggerFactory.getLogger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

//@Component(immediate = true,service = SampleResources.class)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@JaxrsResource
public class SampleResources {

	private final Logger logger = getLogger(getClass());

	// @Activate
	// void activate() {
	// logger.info("{} activated", getClass().getTypeName());
	// }

	// @Deactivate
	// void deactivate() {
	// logger.info("{} deactivated", getClass().getTypeName());
	// }

	@Path("name")
	@GET
	public Response getName() {
		return Response.ok(getClass().getTypeName()).build();
	}
}
