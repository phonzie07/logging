package com.logging.service;


import com.logging.entity.ApiRequestLog;

/**
 * The interface Log service.
 */
public interface ILogService {

    /**
     * Save log.
     *
     * @param apiRequestLog the api request log
     * @param uri           the uri
     */
    void saveLog(ApiRequestLog apiRequestLog, String uri);

}
