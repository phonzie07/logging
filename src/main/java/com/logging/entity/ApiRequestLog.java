package com.logging.entity;

import com.generic.core.base.data.BaseEntity;
import com.generic.logger.request.LogRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Api request log.
 */
@Data
@Table
@Entity
@NoArgsConstructor
@Access( AccessType.FIELD )
@EqualsAndHashCode( callSuper = false )
@AttributeOverride( name = "id", column = @Column( name = "request_id" ) )
public class ApiRequestLog extends BaseEntity {

    private Integer connectionStatus;
    private String serviceUri;

    @ManyToOne
    @JoinColumn( name = "api_id" )
    private ApiType apiType;

    @Column( columnDefinition = "text" )
    private String requestMessage;

    @Column( columnDefinition = "text" )
    private String responseMessage;

    @Column( name = "http_method" )
    private String method;

    /**
     * Instantiates a new Api request log.
     *
     * @param request the request
     */
    public ApiRequestLog( LogRequest request ) {
        this.requestMessage = request.getRequestMessage( );
        this.responseMessage = request.getResponseMessage( );
        this.connectionStatus = request.getConnectionStatus( );
        this.serviceUri = request.getServiceUri( );
        this.serviceUri = request.getServiceUri( );
        this.method = request.getMethod( );
    }

}
