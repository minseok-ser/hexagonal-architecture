package net.koast.hexagonalarchitecture.account.domain.mapper;

import javax.annotation.processing.Generated;
import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T03:36:41+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (OpenLogic)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity dtoToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( userDTO.getUserId() );
        userEntity.setName( userDTO.getName() );
        userEntity.setPassword( userDTO.getPassword() );

        return userEntity;
    }

    @Override
    public UserDTO entityToDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.userId( userEntity.getUserId() );
        userDTO.name( userEntity.getName() );
        userDTO.password( userEntity.getPassword() );

        return userDTO.build();
    }
}
