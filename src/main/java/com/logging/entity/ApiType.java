package com.logging.entity;

import com.generic.core.base.data.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Api type.
 */
@Data
@Table
@Entity
@NoArgsConstructor
@Access( AccessType.FIELD )
@EqualsAndHashCode(callSuper = false)
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

}
