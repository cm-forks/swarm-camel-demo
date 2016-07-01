# Swarm Camel REST Quickstart

## Introduction

This is an example that uses the rest-dsl to define a rest services which provides one operation

- GET api/say/{id}       - Say Hello to the user name

## Build

You will need to compile this example first:

    mvn install

## Run

To run the example type

    mvn wildfly-swarm:run

The rest service can be accessed from the following url

    curl http://localhost:8080/api/say/{name}
<http://localhost:8080/api/say/{name}>

For example to get say Hello for the name `charles`

    curl http://localhost:8080/api/say/charles
<http://localhost:8080/api/say/charles>

The rest services provides Swagger API which can be accessed from the following url

    curl http://localhost:8080/swagger.json
<http://localhost:8080/swagger.json>

To stop the example hit <kbd>ctrl</kbd>+<kbd>c</kbd>

## Running the example in fabric8

It is assumed a running Kubernetes platform is already running. If not you can find details how to get started.

The example can be built and deployed using a single goal:

    mvn -Pf8-local-deploy

When the example runs in fabric8, you can use the OpenShift client tool to inspect the status

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the fabric8 web console to manage the running pods, and view logs and much more.

## Access services using a web browser

You can use any browser to perform a HTTP GET. This allows you to very easily test a few of the RESTful services we defined:

Notice: As it depends on your OpenShift setup, the hostname (route) might vary. Verify with oc get routes which hostname is valid for you.

Use this URL to display the root of the REST service, which also allows to access the WADL of the service:

Use this URL to display the JSON representation for customer 123:

    http://cdi-camel-swagger-default.vagrant.f8/user/123

where `vagrant.f8` is your Kubernetes domain.

## More details

You can find more details about running this quickstart on the website. This also includes instructions how to change the Docker image user and registry.
Status API Training Shop Blog About


## Call the Service

```
curl -X GET http://localhost:8080/api/say/charles
```

## Jolokia & JMX

Some curl request that we can use to grab JVM data

```
curl -X GET http://localhost:8080/jmx
curl -d "{\"type\":\"read\",\"mbean\":\"java.lang:type=Memory\",\"attribute\":\"HeapMemoryUsage\",\"path\":\"used\"}" http://localhost:8080/jmx/ && echo ""
```
