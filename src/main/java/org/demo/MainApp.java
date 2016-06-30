package org.demo;

import org.demo.route.RestService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.camel.core.CamelCoreFraction;
import org.wildfly.swarm.jolokia.JolokiaFraction;
import org.wildfly.swarm.undertow.WARArchive;

import java.io.File;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm();

		// Camel Fraction
		swarm.fraction(new CamelCoreFraction()
		        .addRouteBuilder(new RestService()));

		// Jolokia Fraction - JMX HTTP Bridge
		swarm.fraction(new JolokiaFraction("/jmx"));

		swarm.start();
		// swarm.deploy(hawtWar);
		swarm.deploy();
	}
}
