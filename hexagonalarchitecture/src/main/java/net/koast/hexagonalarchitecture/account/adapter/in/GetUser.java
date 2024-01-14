package net.koast.hexagonalarchitecture.account.adapter.in;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.koast.hexagonalarchitecture.account.application.in.GetUserUsecase;
import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.common.ResultResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
class GetUser {

  private final GetUserUsecase getUserUsecase;
    
  @GetMapping(path = "/account/getuser")
  ResultResponse<UserDTO> getUser(@RequestParam("userId") @NotBlank String userId) {
    try {
      return ResultResponse.<UserDTO>builder().status(200).payload(getUserUsecase.getUser(userId)).build();
    } catch (Exception e) {
      return ResultResponse.<UserDTO>builder().status(200).payload(null).message(e.getMessage()).build();
    }
  }
}
