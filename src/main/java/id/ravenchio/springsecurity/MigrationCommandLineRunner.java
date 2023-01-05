package id.ravenchio.springsecurity;

import id.ravenchio.springsecurity.model.User;
import id.ravenchio.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MigrationCommandLineRunner implements CommandLineRunner {

  private final PasswordEncoder passwordEncoder;

  private final UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    User user = User
        .builder()
        .firstName("may")
        .lastName("hendra")
        .email("may@test.dev")
        .password(passwordEncoder.encode("123"))
        .build();
    userRepository.save(user);
  }

}
