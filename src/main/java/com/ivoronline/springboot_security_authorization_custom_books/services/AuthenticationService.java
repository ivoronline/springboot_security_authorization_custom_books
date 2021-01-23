package com.ivoronline.springboot_security_authorization_custom_books.services;

import com.ivoronline.springboot_security_authorization_custom_books.entities.Book;
import com.ivoronline.springboot_security_authorization_custom_books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthenticationService {

  @Autowired
  BookRepository bookRepository;

  @Transactional
  public boolean authenticate(Authentication authentication, Integer bookId) {

    //GET BOOK
    Book book = bookRepository.findById(bookId).get();

    //GET BOOK USERNAME
    String bookUserName = book.userName;

    //GET AUTHENTICATED USERNAME
    UserDetails user = (UserDetails) authentication.getPrincipal();
    String authenticatedUserName = user.getUsername();

    //CHECK OWNERSHIP
    if (bookUserName.equals(authenticatedUserName)) { return true;  }
    else                                            { return false; }

  }

}



