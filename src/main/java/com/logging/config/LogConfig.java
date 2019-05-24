package com.logging.config;

import com.generic.core.base.config.MonitoringConfig;
import com.generic.core.base.config.SwaggerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The type Log config.
 */
@Configuration
@Import( { SwaggerConfig.class, MonitoringConfig.class } )
public class LogConfig {
}
