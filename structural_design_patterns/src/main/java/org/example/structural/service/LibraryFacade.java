package org.example.structural.service;


import org.example.structural.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LibraryFacade {

    private final BookService bookService;

    @Autowired
    public LibraryFacade(BookService bookService) {
        this.bookService = bookService;
    }

    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public List<Book> getBooksByCategory(String category) {
        // Assuming BookService or BookRepository has a method for this
        return bookService.findBooksByCategory(category);
    }

    public List<Book> getFeaturedBooks() {
        // Retrieve and filter featured books (using decorators or service logic)
        return bookService.getFeaturedBooks();
    }

}
