package com.example;

import com.example.servlet.MyListener;
import com.example.servlet.SpringFilter;
import com.example.servlet.SpringServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import java.io.IOException;

@SpringBootApplication
@MapperScan("com.example.dao")
@ServletComponentScan("com.example.servlet")
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public static ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

		servletRegistrationBean.setServlet(new SpringServlet());
		servletRegistrationBean.setName("springservlet");
		servletRegistrationBean.addUrlMappings("/spring/servlet");

		return servletRegistrationBean;
	}

	@Bean
	public static FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

		filterRegistrationBean.setFilter(new SpringFilter());
		filterRegistrationBean.addServletNames("springservlet");
		filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD);

		return filterRegistrationBean;

	}

	@Bean
	public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
		servletListenerRegistrationBean.setListener(new MyListener());

		return servletListenerRegistrationBean;
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		builder.sources(Application.class);
		return builder;
	}
}
