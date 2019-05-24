package com.logging.controller;

import com.generic.logger.request.LogRequest;
import com.logging.entity.ApiRequestLog;
import com.logging.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Log controller.
 */
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
        ApiRequestLog apiRequestLog = new ApiRequestLog( request );
        service.saveLog( apiRequestLog, request.getUri( ) );
        return new ResponseEntity( HttpStatus.OK );
    }

}
