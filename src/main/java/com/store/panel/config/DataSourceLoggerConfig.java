package com.store.panel.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Configuration
public class DataSourceLoggerConfig {

    @Value("${spring.datasource.url:NOT_DEFINED}")
    private String datasourceUrl;

    @Value("${spring.datasource.username:NOT_DEFINED}")
    private String datasourceUser;

    @Value("${spring.datasource.password:NOT_DEFINED}")
    private String datasourcePassword;

    @PostConstruct
    public void logDatasourceDetails() {
        log.info("[DB-CONFIG] Datasource URL: {}", datasourceUrl);
        log.info("[DB-CONFIG] Datasource Username: {}", datasourceUser);
        log.info("[DB-CONFIG] Datasource Password: {}", datasourcePassword != null ? "***" : "NOT_DEFINED");
    }
}
