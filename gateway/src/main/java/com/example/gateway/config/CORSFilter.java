package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;


@Configuration
@EnableWebFlux
public class CORSFilter implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(corsConfigurationSource);
    }

//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/api/v1/first/**")
//                        .filters(f -> f.rewritePath("/api/v1/first/(?<remains>.*)", "/${remains}")
//                                .addRequestHeader("X-first-Header", "first-service-header")
//                                .hystrix(c -> c.setName("hystrix")
//                                        .setFallbackUri("forward:/fallback/first")))
//                        .uri("lb://FIRST-SERVICE/")
//                        .id("first-service"))
//
//                .route(r -> r.path("/api/v1/second/**")
//                        .filters(f -> f.rewritePath("/api/v1/second/(?<remains>.*)", "/${remains}")
//                                .hystrix(c -> c.setName("hystrix")
//                                        .setFallbackUri("forward:/fallback/second")))
//                        .uri("lb://SECOND-SERVICE/")
//                        .id("second-service"))
//                .build();
//    }
}
