package nl.aben.crud.demo.config;

import nl.aben.crud.demo.handler.ReactivePoliticianHandler;
//import com.spring.crud.demo.service.ReactivePoliticianService;
import lombok.AllArgsConstructor;
//import org.springdoc.core.annotations.RouterOperation;
//import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfig {


    private final ReactivePoliticianHandler reactivePoliticianHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        return RouterFunctions.route()
                .GET("/route/politicians", reactivePoliticianHandler::findAll)
                .GET("/route/politicians/{id}", reactivePoliticianHandler::findById)
                .POST("/route/politicians", reactivePoliticianHandler::save)
                .PUT("/route/politicians/{id}", reactivePoliticianHandler::update)
                .DELETE("/route/politicians/{id}", reactivePoliticianHandler::delete)
                .build();
    }


}
