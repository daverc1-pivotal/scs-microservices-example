package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import service.data.domain.Movie;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScan(basePackages = { "service.config", "service.data" })

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private RepositoryRestMvcConfiguration repositoryRestConfiguration;

    @PostConstruct
    public void postConstructConfiguration() {
        repositoryRestConfiguration.config().exposeIdsFor(Movie.class);
    }
}
