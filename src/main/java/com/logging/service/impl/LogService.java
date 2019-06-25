package com.logging.service.impl;

import com.generic.utils.MapperUtil;
import com.logging.entity.ApiRequestLog;
import com.logging.entity.ApiType;
import com.logging.repository.ApiRequestRepository;
import com.logging.repository.ApiTypeRepository;
import com.logging.service.ILogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.generic.utils.MapperUtil.maskPropertyValue;

/**
 * The type Log service.
 */
@Log4j2
@Service
public class LogService implements ILogService {

    @Autowired
    private ApiTypeRepository apiRepository;
    @Autowired
    private ApiRequestRepository requestRepository;

    @Resource
    private Map< String, String > uriMasking;

    @Override
    public void saveLog( ApiRequestLog apiRequestLog,
                         String uri ) {

        apiRequestLog.setRequestMessage( maskPropertyValue( apiRequestLog.getRequestMessage( ) ) );
        apiRequestLog.setResponseMessage( maskPropertyValue( apiRequestLog.getResponseMessage( ) ) );

        String finalUri;

        if ( uri.contains( "beta-equator.tmn-dev.com" ) ) finalUri = checkRegEx( uri );
        else finalUri = uri;

        ApiType apiType = Optional.ofNullable( apiRepository.findByName( finalUri ) )
                .orElseGet( ( ) -> apiRepository.save( new ApiType( finalUri ) ) );
        apiRequestLog.setApiType( apiType );

        apiRequestLog = requestRepository.save( apiRequestLog );
        log.info( MapperUtil.objectToJson( apiRequestLog ) );
    }

    private String checkRegEx( String uri ) {

        for ( Map.Entry< String, String > entry : uriMasking.entrySet( ) ) {
            String regEx = entry.getKey( );
            String val = entry.getValue( );
            Pattern pattern = Pattern.compile( regEx );
            Matcher matcher = pattern.matcher( uri );

            if ( matcher.find( ) ) {
                String temp = matcher.group( );
                pattern = Pattern.compile( "\\d+" );
                matcher = pattern.matcher( temp );
                if ( matcher.find( ) ) {
                    String temp1 = temp.replace( matcher.group( ), val );
                    return uri.replaceAll( temp, temp1 );
                }
            }
        }

        return uri;
    }

}
