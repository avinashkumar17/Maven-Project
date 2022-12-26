package org.example;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:app.properties")
public class ConfigurationAdap extends WebMvcConfigurerAdapter {
	
	
@Value("${property.file}") String file;

@Value("classpath:app.properties")
private Resource resource;

@PostConstruct
public void hello() throws IOException {
	URL url=this.getClass().getClassLoader().getResource("app.properties");
	System.out.println("***********"+resource.getURL().getPath()+" and "+resource.getURI().getPath());
}

@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
	registry.addResourceHandler("/resource/**")
    .addResourceLocations("/resource/");	
	}

}
