package com.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@EnableEurekaClient
public class LoggingApplication extends SpringBootServletInitializer {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main( String[] args ) {
		SpringApplication.run( LoggingApplication.class, args );
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application ) {
		return application.sources( LoggingApplication.class );
	}

	/**
	 * Uri masking map.
	 *
	 * @return the map
	 */
	@Bean
	public Map< String, String > uriMasking( ) {
		Map< String, String > map = new HashMap<>( );
		map.put( "companies/\\d+/wallet-users", "{id}" );
		map.put( "system-users/\\d+/companies", "{id}" );
		map.put( "sofs/\\d+", "{id}" );
		map.put( "roles/\\d+/system-users", "{id}" );
		return map;
	}

}
