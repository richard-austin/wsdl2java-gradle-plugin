package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.example.xjcplugins.HelloWorld;
import io.github.richard_austin.example.xjcplugins.SayHi;
import io.github.richard_austin.example.xjcplugins.SayHiResponse;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.HashCode2;

import javax.xml.ws.Endpoint;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloWorldTest {
    String serviceAddress = "http://localhost:8802/HelloWorldService";
    Endpoint endpoint;

    @AfterEach
    void stopEndpoint() {
        if (endpoint != null) {
            endpoint.stop();
        }
    }

    @Test
    void testServerClient() {
        // Create server
        endpoint = Endpoint.publish(serviceAddress, new HelloWorldImpl());

        // Create client
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWorld.class);
        factory.setAddress(serviceAddress);
        HelloWorld client = (HelloWorld) factory.create();

        // Call the service
        SayHi sayHi = new SayHi();
        sayHi.setArg0("Joe");
        SayHiResponse response = client.sayHi(sayHi);
        assertTrue(response.getReturn().contains("Hi"));

        // Check the plugins
        assertTrue(sayHi instanceof Equals2);
        assertTrue(sayHi instanceof HashCode2);
    }
}
