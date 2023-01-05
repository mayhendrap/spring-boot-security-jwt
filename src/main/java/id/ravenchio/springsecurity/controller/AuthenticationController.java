package id.ravenchio.springsecurity.controller;

import id.ravenchio.springsecurity.dto.LoginRequest;
import id.ravenchio.springsecurity.dto.LoginResponse;
import id.ravenchio.springsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse<String>> login(@RequestBody LoginRequest request) {
    String token = authenticationService.login(request);
    return ResponseEntity
        .ok()
        .body(new LoginResponse<String>("Success", token));
  }

}
