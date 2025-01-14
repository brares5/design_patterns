package org.example.structural.service;


import org.example.structural.entity.Book;
import org.example.structural.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setFeatured(updatedBook.isFeatured());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setFeatured(updatedBook.isFeatured());
            return bookRepository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Book with ID " + id + " not found.");
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book with ID " + id + " not found."));
    }

    public List<Book> getFeaturedBooks() {
        return bookRepository.findFeaturedBooks();
    }

    public List<Book> findBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public String getBookDescriptionById(Long id) {
        return bookRepository.getBookDescription(id);
    }

    public BookDecorator markBookAsFeatured(Long id) {
        Book book = getBookById(id);
        return new FeaturedBookDecorator(book);
    }

    public BookDecorator markBookAsBestseller(Long id) {
        Book book = getBookById(id);
        return new BestsellerBookDecorator(book);
    }
}
