package com.karu3;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // Spring Boot 4.0では、application.propertiesで
    // spring.datasource.url=jdbc:log4jdbc:h2:mem:testdb
    // のように指定するだけでlog4jdbcが有効になります。
    // 追加のJavaコードは不要です。
}
