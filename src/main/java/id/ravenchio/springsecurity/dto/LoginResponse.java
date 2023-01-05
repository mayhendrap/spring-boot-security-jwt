package id.ravenchio.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse<T> {

  private String message;

  private T data;

}
