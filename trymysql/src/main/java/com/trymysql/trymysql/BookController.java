package com.trymysql.trymysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// This means that this
// class is a Controller
@Controller

@RequestMapping(path="/geek")
public class BookController {


    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path="/addbook")
    public @ResponseBody String addBooks (@RequestParam String bookName
            , @RequestParam String isbnNumber) {


        Book book = new Book();
        book.setBookName(bookName);
        book.setIsbnNumber(isbnNumber);
        bookRepository.save(book);
        return "Details got Saved";
    }

    @GetMapping(path="/books")
    public @ResponseBody Iterable<Book> getAllUsers() {
        return bookRepository.findAll();
    }
}