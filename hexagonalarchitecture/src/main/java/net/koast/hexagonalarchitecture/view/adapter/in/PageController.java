package net.koast.hexagonalarchitecture.view.adapter.in;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageController {
  @GetMapping (value = "/")
  public String addUser(HttpServletRequest request) {
    return "request/addUser";
  }
}
