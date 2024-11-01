package org.example.structural.repository;


import org.example.structural.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);
    @Query("SELECT b FROM Book b WHERE b.isFeatured = true")
    List<Book> findFeaturedBooks();
    String getBookDescription(Long id);
}
