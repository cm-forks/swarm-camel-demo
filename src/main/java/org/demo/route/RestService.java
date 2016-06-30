package org.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class RestService extends RouteBuilder {
    @Override public void configure() throws Exception {

        restConfiguration()
          .component("undertow")
          .host("localhost");

        rest("/api")
           .get("/say/{name}").to("direct:say");

        from("direct:say")
           .transform()
              .simple("Hello from REST endpoint to ${header.name}");
    }
}
