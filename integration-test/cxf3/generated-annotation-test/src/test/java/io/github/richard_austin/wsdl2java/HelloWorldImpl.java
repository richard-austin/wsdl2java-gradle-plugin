package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.example.markgenerated.HelloWorld;
import io.github.richard_austin.example.markgenerated.SayHi;
import io.github.richard_austin.example.markgenerated.SayHiResponse;

public class HelloWorldImpl implements HelloWorld {
	@Override
	public SayHiResponse sayHi(SayHi request) {
		SayHiResponse response = new SayHiResponse();
		response.setReturn("Hi, " + request.getArg0());
		return response;
	}
}
