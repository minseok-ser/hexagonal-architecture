package net.koast.hexagonalarchitecture.account.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  @NotNull String userId;
  @NotNull String name;
  @NotNull String password;
  @NotNull String passwordRetyped;
}
