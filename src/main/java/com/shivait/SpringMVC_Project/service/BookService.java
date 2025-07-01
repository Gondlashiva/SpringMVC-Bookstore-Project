package com.shivait.SpringMVC_Project.service;

import com.shivait.SpringMVC_Project.Model.Book;
import com.shivait.SpringMVC_Project.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookService {
     @Autowired
    private BookRepository bookRepository;

    public List<Book>getAllBook(){
        return bookRepository.findAll();

    }

    public void saveBook(Book book){
         bookRepository.save(book);

    }

    public Book getBookById(long id){
        return bookRepository.findById(id).orElse(null);

    }

    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
}
