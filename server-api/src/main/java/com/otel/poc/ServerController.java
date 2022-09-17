package com.otel.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/")
public class ServerController {

    private static final Logger log = LoggerFactory.getLogger(ServerController.class);

    @Autowired
    private Tracer tracer;

    private final RestTemplate restTemplate;

    public ServerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cities/{id}")
    String service1(@PathVariable Long id) throws Exception {
        Span newSpan = tracer.nextSpan().name("AsyncSpan").start();
        try (Tracer.SpanInScope ws = tracer.withSpan(newSpan.start())) {
            Thread.sleep(1000L);
            log.info("Before Async Method Call, I'm in the new span doing some cool work that needs its own span");
            asyncMethod();
            log.info("After Async Method Call");
        } finally {
            newSpan.end();
        }

        log.info("Call cities-api service");
        String url = "http://location-api:8081/cities/".concat(id.toString());
        log.info("hit url: ".concat(url));
        return this.restTemplate.getForObject(url, String.class);
    }

    @Async
    public void asyncMethod() throws Exception {
        log.info("Start Async Method");
        Thread.sleep(1000L);
        log.info("End Async Method");
    }

}
