package net.koast.hexagonalarchitecture.account.application.out;

import net.koast.hexagonalarchitecture.account.domain.UserEntity;

public interface AddUserPort {
  public boolean checkUserId(UserEntity entity) throws Exception;
  public boolean addUser(UserEntity entity) throws Exception;
}
