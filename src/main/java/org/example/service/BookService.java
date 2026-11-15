package org.example.service;

import org.example.model.dto.BookDto;
import org.example.model.entity.BookEntity;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<BookDto> getAll(){

        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();

        for (BookEntity bookEntity: bookEntities){
            BookDto bookDto = new BookDto();
            bookDto.setIsbn(bookEntity.getIsbn());
            bookDto.setTitle(bookEntity.getTitle());
            bookDto.setAuthor(bookEntity.getAuthor());

            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    public void add(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(bookDto.getIsbn());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setAvailable(true);

        bookRepository.save(bookEntity);
    }

    public void delete(Long isbn){
        bookRepository.deleteAllById(Collections.singleton(isbn));
    }

    public void update(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(bookDto.getIsbn());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setAvailable(true);

        bookRepository.save(bookEntity);
    }
}
