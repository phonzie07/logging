package com.logging.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.logging.controller.base.BaseControllerTest;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Monitoring endpoint test.
 */
@SpringBootTest()
@RunWith( SpringRunner.class )
public class MonitoringEndpointTest extends BaseControllerTest {

    @Value( "${spring.application.name}" )
    private String appName;

    /**
     * Sets .
     */
    @Before
    public void setup( ) {
        context.getBean( HealthEndpoint.class );
        mockMvc = MockMvcBuilders
                .webAppContextSetup( context )
                .apply( documentationConfiguration( restDocumentation ) )
                .alwaysDo( print( ) )
                .build( );
    }

    /**
     * Monitoring controllers health method call.
     *
     * @throws Exception the exception
     */
    @Test
    public void monitoringController_health_methodCall( ) throws Exception {
        mockMvc.perform( get( "/health" ) )
                .andExpect( status( ).isOk( ) )
                .andExpect( jsonPath( "status" ).value( "UP" ) )
                .andDo( document( "health" ) );
    }

    /**
     * Monitoring controllers info method call.
     *
     * @throws Exception the exception
     */
    @Test
    public void monitoringController_info_methodCall( ) throws Exception {
        mockMvc.perform( get( "/info" ) )
                .andExpect( status( ).isOk( ) )
                .andExpect( jsonPath( "app.name" ).value( appName ) )
                .andDo( document( "info" ) )
        ;
    }

}