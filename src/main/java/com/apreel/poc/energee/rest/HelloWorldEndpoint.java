package com.apreel.poc.energee.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.Optional;
import java.util.stream.Stream;

@Path("/hello")
@ApplicationScoped
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		Optional<Integer> optSum = Stream.of(0, 1, 2, 4, 8, 16, 32, 64)
				.reduce((a, b) -> a + b);
		return Response.ok("Hello from WildFly Swarm! Test if Java 8 is running " + optSum.orElse(0)).build();
	}
}