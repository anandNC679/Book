package com.book.book.persistence.repo;

import com.book.book.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * author anand.
 * since on 17/3/18.
 */
public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findByTitle(String title);

    Optional<Book> findById(long id);

    void deleteById(long id);
}
