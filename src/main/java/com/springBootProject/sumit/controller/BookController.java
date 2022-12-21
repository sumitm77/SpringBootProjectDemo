package com.springbootproject.sumit.controller;

import com.springbootproject.sumit.entities.Book;
import com.springbootproject.sumit.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Using RestController instead of Controller
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * Using GetMapping instead of RequestMapping
     *
     * @RequestMapping(value = "/books", method = RequestMethod.GET)
     */
    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/bookPostman")
    public String printReturnStatement() {
        return "Practice always makes u perfect!";
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookByID(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping("/createBook")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.OK).body(b);
           // return ResponseEntity.ok(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        try {
            this.bookService.updateBook(book, id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {
            this.bookService.deleteBookByID(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "Home Page !!";
    }

}
