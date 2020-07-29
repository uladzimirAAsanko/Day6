package by.sanko.bookproject.model.service;

import by.sanko.bookproject.exception.ProjectException;
import by.sanko.bookproject.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> addBook(Book book) throws ProjectException;

    List<Book> removeBook(Book book) throws ProjectException;

    Optional<Book> findById(long bookId);

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByYearPublication(int yearPublication);

    List<Book> findByCountOfPages(long countOfPages);

    List<Book> sortById();

    List<Book> sortByTitle();

    List<Book> sortByAuthor();

    List<Book> sortByYearPublication();

}
