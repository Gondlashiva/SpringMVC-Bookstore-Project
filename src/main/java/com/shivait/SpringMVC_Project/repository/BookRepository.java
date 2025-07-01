package com.shivait.SpringMVC_Project.repository;

import com.shivait.SpringMVC_Project.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
