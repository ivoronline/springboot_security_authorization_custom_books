package com.ivoronline.springboot_security_authorization_custom_books.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //=================================================================
  // READ BOOK
  //=================================================================
  @RequestMapping("/ReadBook/{BookId}")
  @PreAuthorize("hasAuthority('ROLE_USER') AND @customAuthorizationService.authorize(authentication, #bookId)")
  public String readBook(@PathVariable("BookId") String bookId) {
    return "USER can read his Book";
  }


}
