package net.koast.hexagonalarchitecture.account.application.in;

import net.koast.hexagonalarchitecture.account.domain.UserDTO;

public interface GetUserUsecase {
 
  UserDTO getUser(String userId) throws Exception;
}
