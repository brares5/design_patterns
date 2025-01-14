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
        return bookService.findBooksByCategory(category);
    }


    public String markBookAsFeatured(Long id) {
        Book book = bookService.getBookById(id);
        BookDecorator featuredBook = new FeaturedBookDecorator(book);
        return featuredBook.getDescription();
    }

    public String markBookAsBestseller(Long id) {
        Book book = bookService.getBookById(id);
        BookDecorator bestsellerBook = new BestsellerBookDecorator(book);
        return bestsellerBook.getDescription();
    }

}
