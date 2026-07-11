package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.example.nested.HelloWorldNested;
import io.github.richard_austin.example.nested.SayHi;
import io.github.richard_austin.example.nested.SayHiResponse;

public class HelloWorldNestedImpl implements HelloWorldNested {
    @Override
    public SayHiResponse sayHi(SayHi request) {
        SayHiResponse response = new SayHiResponse();
        response.setReturn("Hi, " + request.getArg0());
        return response;
    }
}
