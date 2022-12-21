package com.springBootProject.sumit.services;

import com.springBootProject.sumit.entities.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

  /*  private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(101, "JAVA", "ABC"));
        list.add(new Book(102, "Maths", "DEF"));
        list.add(new Book(103, "Physics", "XYZ"));
    }*/


    private static List<Book> list = Arrays.asList(new Book(101, "JAVA", "ABC"),
            new Book(102, "Maths", "ABCD"), new Book(103, "Physics", "XYZ"));

    // returns all Books
    public List<Book> getAllBooks() {
        return list;
    }

    // return single book
    public Book getBookByID(int id) {
        Book book = null;
        try {

            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Add new Book
    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    // update book details
    public void updateBook(Book book, int id) {
        list = list.stream().map(b -> {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());

    }

    // Delete book
    public void deleteBookByID(int bid) {
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
    }
}
