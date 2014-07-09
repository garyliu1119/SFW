package com.ociweb.corespring.examples.employee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class RESTConfig {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Bean
	public CastorMarshaller castorMarshaller(){
		CastorMarshaller marshaller = new CastorMarshaller();
		marshaller.setMappingLocations(new Resource[]{
				ctx.getResource("classpath:/castor/employee.xml"), 
				ctx.getResource("classpath:/castor/resultMessage.xml")});
		return marshaller;
	}
	
	@Bean
	public HttpMessageConverter<Object> marshallingMessageConverter(){
		CastorMarshaller marshaller = castorMarshaller();
		return new MarshallingHttpMessageConverter(marshaller, marshaller);
	}

	@Bean
	public HandlerMapping handlerMapping(){
		return new DefaultAnnotationHandlerMapping();
	}
	
	@Bean
	public HandlerAdapter handlerAdapter(){
		AnnotationMethodHandlerAdapter adapter = 
			new AnnotationMethodHandlerAdapter();
		adapter.setMessageConverters(
				new HttpMessageConverter[]{marshallingMessageConverter()});
		return adapter;
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = 
			new InternalResourceViewResolver();
		viewResolver.setViewClass(InternalResourceView.class);
		return viewResolver;
	}
}
