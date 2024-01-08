package net.koast.hexagonalarchitecture;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.account.domain.UserEntity;
import net.koast.hexagonalarchitecture.account.domain.mapper.UserMapper;

@SpringBootTest
class HexagonalarchitectureApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Hello test-world!");

		UserDTO userDto = new UserDTO("id", "name", "passwd", "passwd");
		System.out.println(userDto);
		UserEntity entity = UserMapper.INSTANCE.dtoToEntity(userDto);
		System.out.println(entity);
		UserDTO dto2 = UserMapper.INSTANCE.entityToDto(entity);
		System.out.println(dto2);

		Assertions.assertThat(userDto.getUserId()).isEqualTo("id");
	}

}
