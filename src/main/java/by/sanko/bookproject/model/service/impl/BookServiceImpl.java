package by.sanko.bookproject.model.service.impl;

import by.sanko.bookproject.exception.DAOException;
import by.sanko.bookproject.exception.ProjectException;
import by.sanko.bookproject.model.dao.impl.BookListDaoImpl;
import by.sanko.bookproject.model.entity.Book;
import by.sanko.bookproject.model.service.BookService;
import by.sanko.bookproject.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> addBook(Book book) throws ProjectException {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        List<Book> bookList;

        try {
            bookList = bookListDao.addBook(book);
        }catch (DAOException e){
            throw new ProjectException("Error while adding book to storage");
        }
        return bookList;
    }

    @Override
    public List<Book> removeBook(Book book) throws ProjectException {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        List<Book> bookList;

        try {
            bookList = bookListDao.removeBook(book);
        }catch (DAOException e){
            throw new ProjectException("Error while deleting book from storage");
        }
        return bookList;
    }

    @Override
    public Optional<Book> findById(long bookId) {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        Optional<Book> targetBook = bookListDao.findById(bookId);

        return targetBook;
    }

    @Override
    public List<Book> findByTitle(String title) {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        BookValidator validator = new BookValidator();
        List<Book> answer = new ArrayList<>();
        if(validator.validateTittle(title)){
            answer = bookListDao.findByTitle(title);
        }
        return answer;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        BookValidator validator = new BookValidator();
        List<Book> answer = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        authors.add(author);
        if(validator.validateAuthors(authors)){
            answer = bookListDao.findByAuthor(author);
        }
        return answer;
    }

    @Override
    public List<Book> findByYearPublication(int yearPublication) {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        BookValidator validator = new BookValidator();
        List<Book> answer = new ArrayList<>();
        if(validator.validateYearPublication(yearPublication)){
            answer = bookListDao.findByYearPublication(yearPublication);
        }
        return answer;
    }

    @Override
    public List<Book> findByCountOfPages(long countOfPages) {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        BookValidator validator = new BookValidator();
        List<Book> answer = new ArrayList<>();
        if(validator.validateCountOfPages(countOfPages)){
            answer = bookListDao.findByCountOfPages(countOfPages);
        }
        return answer;
    }

    @Override
    public List<Book> sortById() {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        List<Book> sortedList = bookListDao.sortById();

        return sortedList;
    }

    @Override
    public List<Book> sortByTitle() {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        List<Book> sortedList = bookListDao.sortByTitle();

        return sortedList;
    }

    @Override
    public List<Book> sortByAuthor() {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        List<Book> sortedList = bookListDao.sortByAuthor();

        return sortedList;
    }

    @Override
    public List<Book> sortByYearPublication() {
        BookListDaoImpl bookListDao = new BookListDaoImpl();
        List<Book> sortedList = bookListDao.sortByYearPublication();

        return sortedList;
    }
}
