package id.ravenchio.springsecurity.service;

import id.ravenchio.springsecurity.dto.LoginRequest;
import id.ravenchio.springsecurity.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final JwtUtil jwtUtil;

  private final AuthenticationManager authenticationManager;

  public String login(LoginRequest request) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        request.getEmail(), request.getPassword());
    authenticationManager.authenticate(authenticationToken);
    return jwtUtil.generate(request.getEmail());
  }

}
