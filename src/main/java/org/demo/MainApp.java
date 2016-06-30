package org.demo;

import org.demo.route.RestService;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.camel.core.CamelCoreFraction;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm();

		// Add fractions
		swarm.fraction(new CamelCoreFraction()
		        .addRouteBuilder(new RestService()));

		swarm.start();
		swarm.deploy();
	}
}
