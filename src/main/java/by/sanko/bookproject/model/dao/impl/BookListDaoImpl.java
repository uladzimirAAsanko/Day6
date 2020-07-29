package by.sanko.bookproject.model.dao.impl;

import by.sanko.bookproject.exception.DAOException;
import by.sanko.bookproject.model.comparator.AuthorComparator;
import by.sanko.bookproject.model.comparator.TitleComparator;
import by.sanko.bookproject.model.dao.BookListDao;
import by.sanko.bookproject.model.entity.Book;
import by.sanko.bookproject.model.entity.BookStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookListDaoImpl implements BookListDao {
    
    @Override
    public List<Book> addBook(Book book) throws DAOException {
        boolean result = BookStorage.getInstance().addBook(book);
        if(!result){
            throw new DAOException("Error while adding");
        }
        List<Book> answer = BookStorage.getInstance().getBooks();
        return answer;
    }

    @Override
    public List<Book> removeBook(Book book) throws DAOException {
        boolean result = BookStorage.getInstance().removeBook(book);
        if(!result){
            throw new DAOException("Error while adding");
        }
        List<Book> answer = BookStorage.getInstance().getBooks();
        return answer;
    }

    @Override
    public Optional<Book> findById(long bookId) {
        Optional<Book> result = Optional.empty();
        for(Book book : BookStorage.getInstance().getBooks()){
            if(book.getBookId() == bookId){
                result = Optional.of(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = BookStorage.getInstance().getBooks();
        return result;
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();;
        for(Book book : BookStorage.getInstance().getBooks()){
            if(book.getTittle().equals(title)){
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for(Book book : BookStorage.getInstance().getBooks()){
            if(book.getAuthors().equals(author)){
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findByYearPublication(int yearPublication) {
        List<Book> result = new ArrayList<>();
        for(Book book : BookStorage.getInstance().getBooks()){
            if(book.getYearOfPublication() == yearPublication){
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findByCountOfPages(long countOfPages) {
        List<Book> result = new ArrayList<>();
        for(Book book : BookStorage.getInstance().getBooks()){
            if(book.getCountOfPages() == countOfPages){
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> sortById() {
        List<Book> books = BookStorage.getInstance().getBooks();
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparingLong(Book::getBookId));

        return sortedBooks;
    }

    @Override
    public List<Book> sortByTitle() {
        List<Book> books = BookStorage.getInstance().getBooks();
        List<Book> sortedBooks = new ArrayList<>(books);

        sortedBooks.sort(new TitleComparator());
        return sortedBooks;
    }

    @Override
    public List<Book> sortByAuthor() {
        List<Book> books = BookStorage.getInstance().getBooks();
        List<Book> sortedBooks = new ArrayList<>(books);

        sortedBooks.sort(new AuthorComparator());
        return sortedBooks;
    }

    @Override
    public List<Book> sortByYearPublication() {
        List<Book> books = BookStorage.getInstance().getBooks();
        List<Book> sortedBooks = new ArrayList<>(books);

        sortedBooks.sort(Comparator.comparingInt(Book::getYearOfPublication));

        return sortedBooks;
    }

    @Override
    public List<Book> sortByCountOfPages() {
        List<Book> books = BookStorage.getInstance().getBooks();
        List<Book> sortedBooks = new ArrayList<>(books);

        sortedBooks.sort(Comparator.comparingLong(Book::getCountOfPages));

        return sortedBooks;
    }
}
