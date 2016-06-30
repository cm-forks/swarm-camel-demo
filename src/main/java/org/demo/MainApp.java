package org.demo;

import org.demo.rest.HelloResource;
import org.demo.route.RestService;
import org.demo.route.TimerToLog;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.camel.core.CamelCoreFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm();

		// Class required to register the REST Service
		JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
		deployment.addResource(HelloResource.class);

		// Add fractions
		swarm.fraction(new CamelCoreFraction()
				.addRouteBuilder(new TimerToLog())
		        .addRouteBuilder(new RestService()));

		swarm.start();
		swarm.deploy();
	}
}
