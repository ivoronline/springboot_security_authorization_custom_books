package com.ivoronline.springboot_security_authorization_custom_books.repositories;

import com.ivoronline.springboot_security_authorization_custom_books.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> { }
