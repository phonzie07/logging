package com.logging.controller.base;

import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * The type Base controllers test.
 */
public class BaseControllerTest {

    /**
     * The Rest documentation.
     */
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation( );

    /**
     * The Context.
     */
    @Autowired
    protected WebApplicationContext context;

    /**
     * The Mock mvc.
     */
    protected MockMvc mockMvc;

}
