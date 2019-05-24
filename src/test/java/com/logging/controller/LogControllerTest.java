package com.logging.controller;

import com.logging.service.ILogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.logging.controller.base.BaseControllerTest;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Log controller test.
 */
@RunWith( SpringRunner.class )
@WebMvcTest( LogController.class )
public class LogControllerTest extends BaseControllerTest {

    //    initialize request json as empty values
    private String requestJson = "{\n" +
            "  \"connectionStatus\": 0,\n" +
            "  \"method\": \"\",\n" +
            "  \"requestMessage\": \"\",\n" +
            "  \"responseMessage\": \"\",\n" +
            "  \"serviceUri\": \"\",\n" +
            "  \"uri\": \"\"\n" +
            "}";

    /**
     * The Service.
     */
    @MockBean
    ILogService service;

    /**
     * Sets up.
     */
    @Before
    public void setUp( ) {
        MockitoAnnotations.initMocks( this );
        mockMvc = MockMvcBuilders.webAppContextSetup( context )
                .apply( documentationConfiguration( restDocumentation ) )
                .build( );
    }

    /**
     * Controller success.
     *
     * @throws Exception the exception
     */
    @Test
    public void controllerSuccess( ) throws Exception {
        mockMvc.perform(
                post( "/log" )
                        .contentType( APPLICATION_JSON )
                        .content( requestJson )
        )
                .andExpect( status( ).isOk( ) )
                .andDo( document( "log" ) );
    }

}
