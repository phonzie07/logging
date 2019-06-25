package com.logging.entity;

import com.generic.core.base.data.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.generic.utils.DateUtil.formatDate;

/**
 * The type Api type.
 */
@Data
@Table
@Entity
@NoArgsConstructor
@Access( AccessType.FIELD )
@EqualsAndHashCode( callSuper = false )
@AttributeOverride( name = "id", column = @Column( name = "api_id" ) )
public class ApiType extends BaseEntity {

    @Column( name = "api_name" )
    private String name;

    /**
     * Instantiates a new Api type.
     *
     * @param name the name
     */
    public ApiType( String name ) {
        this.name = name;
    }

    public String getCreatedTimeString( ) {
        return formatDate( this.createdTime, "yyyy-MM-dd HH:mm:ss.SSS" );
    }

}
