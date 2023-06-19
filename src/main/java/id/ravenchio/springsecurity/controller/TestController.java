package id.ravenchio.springsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping
    String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("AUTH: {}", authentication.getPrincipal());
        return "TEST";
    }
}
