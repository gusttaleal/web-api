package br.com.gusttaleal.webapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {
    private static final String APPLICATION_METHOD_LOG = Application.class.getSimpleName() + ":main";

    public static void main(String[] args) {
        log.info("[{}] Starting application", APPLICATION_METHOD_LOG);
        SpringApplication.run(Application.class, args);
    }

}
