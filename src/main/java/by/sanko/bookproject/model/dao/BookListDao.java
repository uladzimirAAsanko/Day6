package by.sanko.bookproject.model.dao;

import by.sanko.bookproject.exception.DAOException;
import by.sanko.bookproject.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookListDao {
    List<Book> addBook(Book book) throws DAOException;

    List<Book> removeBook(Book book) throws DAOException;

    Optional<Book> findById(long bookId);

    List<Book> findAll();

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByYearPublication(int yearPublication);

    List<Book> findByCountOfPages(long countOfPages);

    List<Book> sortById();

    List<Book> sortByTitle();

    List<Book> sortByAuthor();

    List<Book> sortByYearPublication();

    List<Book> sortByCountOfPages();
}
