package com.logging.repository;

import com.logging.entity.ApiType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Api type repository.
 */
public interface ApiTypeRepository extends JpaRepository<ApiType, Long > {

    /**
     * Find by name api type.
     *
     * @param name the name
     * @return the api type
     */
    ApiType findByName(String name);

}
