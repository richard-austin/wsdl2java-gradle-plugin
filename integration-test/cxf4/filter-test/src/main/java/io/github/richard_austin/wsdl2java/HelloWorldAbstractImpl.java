package io.github.richard_austin.wsdl2java;

import io.github.richard_austin.example._abstract.HelloWorldAbstract;
import io.github.richard_austin.example._abstract.SayHi;
import io.github.richard_austin.example._abstract.SayHiResponse;

public class HelloWorldAbstractImpl implements HelloWorldAbstract {
	@Override
	public SayHiResponse sayHi(SayHi request) {
		SayHiResponse response = new SayHiResponse();
		response.setReturn("Hi, " + request.getArg0());
		return response;
	}
}
