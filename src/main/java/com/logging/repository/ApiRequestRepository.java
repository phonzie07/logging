package com.logging.repository;

import com.logging.entity.ApiRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Api request repository.
 */
public interface ApiRequestRepository extends JpaRepository<ApiRequestLog, Long > {
}
