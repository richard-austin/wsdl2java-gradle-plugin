package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.HelloWorld;
import io.github.richard_austin.SayHi;
import io.github.richard_austin.SayHiResponse;

public class HelloWorldImpl implements HelloWorld {
	@Override
	public SayHiResponse sayHi(SayHi request) {
		SayHiResponse response = new SayHiResponse();
		response.setReturn("Hi, " + request.getArg0());
		return response;
	}
}
