package org.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class TimerToLog extends RouteBuilder {
    @Override public void configure() throws Exception {
        from("timer://demo?period=5000&delay=5000")
           .log("Hello from Camel");
    }
}
