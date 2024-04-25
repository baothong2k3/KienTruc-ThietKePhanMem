/*
 * @ (#) AppConfig.java    1.0    25/04/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package iuh.fit.se.productservice.configs;/*
 * @description:
 * @author: Bao Thong
 * @date: 25/04/2025
 * @version: 1.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
