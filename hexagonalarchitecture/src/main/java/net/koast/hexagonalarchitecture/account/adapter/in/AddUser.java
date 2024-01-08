package net.koast.hexagonalarchitecture.account.adapter.in;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.koast.hexagonalarchitecture.account.application.in.AddUserUsecase;
import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.common.ResultResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
class AddUser {

  private final AddUserUsecase addUserUsecase;
  
  @PostMapping(path = "/account/adduser")
  ResultResponse<String> addUser(@Valid UserDTO dto, BindingResult bindingResult) {

    log.info(bindingResult.getAllErrors().toString());
    if(bindingResult.getAllErrors().size() > 0) {
      return ResultResponse.<String>builder().status(200).payload(bindingResult.getAllErrors().get(0).getDefaultMessage()).build();
    }
    
    String message = "";
    if (dto.getUserId() == null || "".equals(dto.getUserId())) message = "id is null";
    else if (dto.getName() == null || "".equals(dto.getName())) message = "name is null";
    else if (dto.getPassword() == null || "".equals(dto.getPassword())) message = "password is null";
    else if (!dto.getPassword().equals(dto.getPasswordRetyped())) message = "password not equal";
    if(!"".equals(message)) {
      return ResultResponse.<String>builder().status(200).payload(message).build();
    } else {
      try {
        if (addUserUsecase.addUser(dto)) message = "ok";
        else message = "duplicated id";
        return ResultResponse.<String>builder().status(200).payload(message).build();
      } catch (Exception e) {
        return ResultResponse.<String>builder().status(200).payload(e.getMessage()).build();
      }
    }
  }
}
