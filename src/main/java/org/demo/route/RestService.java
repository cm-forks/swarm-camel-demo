package org.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class RestService extends RouteBuilder {
    @Override public void configure() throws Exception {
        from("undertow://http://localhost:9191/api/say")
           .transform()
              .constant("Hello from REST endpoint");
    }
}
