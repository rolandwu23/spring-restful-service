package com.grok.akm.rest.services.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping("hello-world")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("hello-world/path-variable/{name}")
	public HelloWorldBean getHelloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s",name));
	}
	
	@GetMapping("hello-world-internationalised")
	public String getHelloWorldInternationalised(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale
			) {
		return messageSource.getMessage("good.morning.message",null, "Default Message", LocaleContextHolder.getLocale());
	}
	
}
