package net.koast.hexagonalarchitecture.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  String userId;
  String name;
  String password;

  public UserEntity(UserDTO dto) {
    this.userId = dto.getUserId();
    this.name = dto.getName();
    this.password = dto.getPassword();
  }
}
