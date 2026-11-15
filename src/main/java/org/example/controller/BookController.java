package org.example.controller;

import lombok.Getter;
import org.example.model.dto.BookDto;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookDto> getAll(){
        return bookService.getAll();
    }

    @PostMapping
    public void add(@RequestBody BookDto bookDto){
        bookService.add(bookDto);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable Long isbn){
        bookService.delete(isbn);
    }

    @PutMapping
    public void update(@RequestBody BookDto bookDto){
        bookService.update(bookDto);
    }
}
