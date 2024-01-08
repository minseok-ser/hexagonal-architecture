package net.koast.hexagonalarchitecture.account.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
  @NotBlank
  @Size(min=4, max=32, message="아이디는 4~32자 사이로 입력")
  String userId;
  
  @NotBlank 
  String name;
  
  @NotBlank 
  @Size(min=4)
  String password;
  
  @NotBlank
  String passwordRetyped;
}
