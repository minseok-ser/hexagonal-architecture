package net.koast.hexagonalarchitecture.account.application.in;

import net.koast.hexagonalarchitecture.account.domain.UserDTO;
public interface AddUserUsecase {
  
  boolean addUser(UserDTO dto) throws Exception;
}
