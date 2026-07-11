package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.HelloUtf8ÆØÅPortType;
import io.github.richard_austin.RequestÆØÅ;
import io.github.richard_austin.ResponseÆØÅ;

public class HelloWorldImpl implements HelloUtf8ÆØÅPortType {

    @Override
    public ResponseÆØÅ utf8OperationWithCharsÆØÅ(final RequestÆØÅ parameters) {
        ResponseÆØÅ response = new ResponseÆØÅ();
        response.setReturn("Hi, " + parameters.getArg0());
        return response;
    }
}
