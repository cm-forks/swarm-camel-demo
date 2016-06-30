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

/*		// Hawtio Web Console
        WARArchive hawtWar = ShrinkWrap.create(WARArchive.class);
		hawtWar.addAsWebResource(new URL("http://oss.sonatype.org/content/repositories/public/io/hawt/hawtio-default/1.4.65/hawtio-default-1.4.65.war"),"/");

		WARArchive hawtWar = ShrinkWrap.createFromZipFile(WARArchive.class,new File("/Users/chmoulli/Temp/test-swarm/demo/src/hawtio-default-1.4.65.war"));
		hawtWar.setContextRoot("/hawtio");
*/

		swarm.start();
		// swarm.deploy(hawtWar);
		swarm.deploy();
	}
}
