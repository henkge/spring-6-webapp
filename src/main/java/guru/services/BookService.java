package guru.services;

import guru.springframework.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();

}
