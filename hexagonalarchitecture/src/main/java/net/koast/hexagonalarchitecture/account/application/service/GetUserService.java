package net.koast.hexagonalarchitecture.account.application.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.koast.hexagonalarchitecture.account.application.in.GetUserUsecase;
import net.koast.hexagonalarchitecture.account.application.out.GetUserPort;
import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;
import net.koast.hexagonalarchitecture.account.domain.mapper.UserMapper;

@RequiredArgsConstructor
@Transactional
@Component
public class GetUserService implements GetUserUsecase {

  private final GetUserPort getUserPort;

  public UserDTO getUser(String userId) throws Exception {
    UserEntity result = getUserPort.getUserInfo(userId);
    return UserMapper.INSTANCE.entityToDto(result);
  }
}
