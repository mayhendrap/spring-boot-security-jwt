package id.ravenchio.springsecurity.controller;

import id.ravenchio.springsecurity.dto.LoginRequest;
import id.ravenchio.springsecurity.dto.LoginResponse;
import id.ravenchio.springsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "/login")
    public LoginResponse<String> login(@RequestBody LoginRequest request) {
        String token = authenticationService.login(request);

        return new LoginResponse<>("Success", token);
    }
}
