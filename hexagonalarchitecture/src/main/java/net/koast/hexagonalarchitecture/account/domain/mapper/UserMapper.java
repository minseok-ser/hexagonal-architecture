package net.koast.hexagonalarchitecture.account.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserEntity dtoToEntity(UserDTO userDTO);

  UserDTO entityToDto(UserEntity userEntity);
  
}
