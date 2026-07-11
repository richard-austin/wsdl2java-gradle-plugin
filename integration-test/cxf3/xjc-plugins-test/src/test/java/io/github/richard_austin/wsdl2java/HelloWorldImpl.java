package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.example.xjcplugins.HelloWorld;
import io.github.richard_austin.example.xjcplugins.SayHi;
import io.github.richard_austin.example.xjcplugins.SayHiResponse;

public class HelloWorldImpl implements HelloWorld {
	@Override
	public SayHiResponse sayHi(SayHi request) {
		SayHiResponse response = new SayHiResponse();
		response.setReturn("Hi, " + request.getArg0());
		return response;
	}
}
