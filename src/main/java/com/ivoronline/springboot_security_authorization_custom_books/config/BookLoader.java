package com.ivoronline.springboot_security_authorization_custom_books.config;

import com.ivoronline.springboot_security_authorization_custom_books.entities.Book;
import com.ivoronline.springboot_security_authorization_custom_books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookLoader implements CommandLineRunner {

  @Autowired
  private BookRepository bookRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //BBOK1
    Book book1          = new Book();
         book1.title    = "Book about dogs";
         book1.userName = "john";

    //BBOK2
    Book book2          = new Book();
         book2.title    = "Book about cats";
         book2.userName = "bill";

    //STORE ACCOUNT INTO DB
    bookRepository.save(book1);
    bookRepository.save(book2);

  }

}
