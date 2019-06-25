package com.logging.controller;

import com.generic.logger.request.LogRequest;
import com.logging.entity.ApiRequestLog;
import com.logging.service.ILogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.generic.utils.MapperUtil.maskPropertyValue;
import static com.generic.utils.MapperUtil.objectToJson;

/**
 * The type Log controller.
 */
@Log4j2
@RestController
public class LogController {

    /**
     * The Service.
     */
    @Autowired
    ILogService service;

    /**
     * Save log response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @Async
    @PostMapping( "/log" )
    public ResponseEntity saveLog( @RequestBody LogRequest request ) {

        request.setRequestMessage( maskPropertyValue( request.getRequestMessage( ) ) );
        request.setResponseMessage( maskPropertyValue( request.getResponseMessage( ) ) );
        log.info( objectToJson( request ) );

//        ApiRequestLog apiRequestLog = new ApiRequestLog( request );
//        service.saveLog( apiRequestLog, request.getUri( ) );
        return new ResponseEntity( HttpStatus.OK );
    }

}
