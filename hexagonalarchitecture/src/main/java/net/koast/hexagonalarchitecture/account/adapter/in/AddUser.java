package net.koast.hexagonalarchitecture.account.adapter.in;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.koast.hexagonalarchitecture.account.application.in.AddUserUsecase;
import net.koast.hexagonalarchitecture.account.domain.UserDTO;
import net.koast.hexagonalarchitecture.common.ResultResponse;

@Controller
@RequiredArgsConstructor
class AddUser {

  private final AddUserUsecase addUserUsecase;

  @GetMapping (value = "/")
  String addUser(HttpServletRequest request) {
    return "request/addUser";
  }
  
  @PostMapping(path = "/account/adduser")
  ResultResponse<String> addUser(UserDTO dto) {
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
