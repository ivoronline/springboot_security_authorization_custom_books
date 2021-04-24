package com.ivoronline.springboot_security_authorization_custom_books.services;

import com.ivoronline.springboot_security_authorization_custom_books.entities.Book;
import com.ivoronline.springboot_security_authorization_custom_books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomAuthorizationService {

  @Autowired BookRepository bookRepository;

  //==============================================================================
  // AUTHORIZE
  //==============================================================================
  @Transactional
  public boolean authorize(Authentication authentication, Integer bookId) {

    //GET BOOK
    Book book = bookRepository.findById(bookId).get();

    //GET BOOK USERNAME
    String bookUserName = book.userName;

    //GET USERNAME
    UserDetails userDetails     = (UserDetails) authentication.getPrincipal();
    String      enteredUsername = userDetails.getUsername();

    //CHECK OWNERSHIP
    return bookUserName.equals(enteredUsername);

  }

}



