package org.demo;

import org.demo.route.RestService;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.camel.core.CamelCoreFraction;
import org.wildfly.swarm.jolokia.JolokiaFraction;
import org.wildfly.swarm.management.ManagementFraction;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm();

		// Add fractions

		// Camel
		swarm.fraction(new CamelCoreFraction()
		        .addRouteBuilder(new RestService()));

		// Jolokia - JMX HTTP Bridge
		swarm.fraction(new JolokiaFraction("/jmx"));

		/*
		// Mngt Console
		swarm.fraction( new ManagementFraction()
				.httpInterfaceManagementInterface((iface) -> {
					iface.allowedOrigin("http://localhost:8080");
					iface.securityRealm("ManagementRealm");
				})
				.securityRealm("ManagementRealm", (realm) -> {
					realm.inMemoryAuthentication( (authn)->{
						authn.add( "bob", "tacos!", true );
					});
					realm.inMemoryAuthorization( (authz)->{
						authz.add( "bob", "admin" );
					});
				}));*/

		swarm.start();
		swarm.deploy();
	}
}
