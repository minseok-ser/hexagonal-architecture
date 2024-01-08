package net.koast.hexagonalarchitecture.account.application.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.koast.hexagonalarchitecture.account.application.in.AddUserUsecase;
import net.koast.hexagonalarchitecture.account.application.out.AddUserPort;
import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;
import net.koast.hexagonalarchitecture.account.domain.mapper.UserMapper;

@RequiredArgsConstructor
@Transactional
@Component
public class AddUserService implements AddUserUsecase {

  private final AddUserPort addUserPort;
  
  public boolean addUser(UserDTO dto) throws Exception {
    // UserEntity entity = new UserEntity(dto); 
    UserEntity entity = UserMapper.INSTANCE.dtoToEntity(dto);
    if(addUserPort.checkUserId(entity)) {
      addUserPort.addUser(entity);
      return true;
    } else {
      return false;
    }
  }
}
