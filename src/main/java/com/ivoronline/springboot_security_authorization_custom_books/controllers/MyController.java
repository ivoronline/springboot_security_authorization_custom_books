package com.ivoronline.springboot_security_authorization_custom_books.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/ReadBook/{BookId}")
  @PreAuthorize("hasAuthority('book.read') AND @authenticationService.authenticate(authentication, #bookId)")
  public String readBook(@PathVariable("BookId") String bookId) {
    return "USER can read his Book";
  }


}
