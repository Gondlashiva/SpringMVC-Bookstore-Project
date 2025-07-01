package com.shivait.SpringMVC_Project.controller;

import com.shivait.SpringMVC_Project.Model.Book;
import com.shivait.SpringMVC_Project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/user")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String listAllbooks(Model model){
        List<Book> bk=bookService.getAllBook();
        model.addAttribute("book",bk);
//        model.addAttribute("book",bookService.getAllBook());
        return "book";
    }

    @GetMapping("/showaddbook")
    public String showaddbook(Model model){

        model.addAttribute("book",new Book());
        return "add";
    }


    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooked(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }




}
