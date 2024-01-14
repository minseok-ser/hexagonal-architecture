package net.koast.hexagonalarchitecture.account.application.out;

import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;

public interface GetUserPort {
  public UserEntity getUserInfo(String userId) throws Exception;
}
