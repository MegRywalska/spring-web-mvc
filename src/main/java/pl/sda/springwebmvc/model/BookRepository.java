package pl.sda.springwebmvc.model;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository

public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        final Book book1 = Book.builder()
                .title("Ja, Inkwizytor. Droga do nieba.")
                .authors("Jacek Piekara")
                .isbn("11-1294-ab")
                .price(new BigDecimal("39.99"))
                .publishingYear(2010)
                .publisher("Fabryka słow")
                .firstEdition(true)
                .build();
        save(book1);

        save(Book.builder()
                .title("Ja, Inkwizytor. Przeklęte kobiety.")
                .authors("Jacek Piekara")
                .isbn("11-1299-ac")
                .price(new BigDecimal("59.99"))
                .publishingYear(2020)
                .publisher("Fabryka słow")
                .firstEdition(true)
                .build());


        save(Book.builder()
                .title("Ja, Inkwizytor. Kościany galeon.")
                .authors("Jacek Piekara")
                .isbn("11-1296-at")
                .price(new BigDecimal("49.99"))
                .publishingYear(2015)
                .publisher("Fabryka słow")
                .firstEdition(true)
                .build());
    }

    public void save(Book book){
        books.put(book.getIsbn(), book);
    }

    public List<Book> findAll(){
        return new ArrayList<>(books.values());
    }

    public boolean delete(String isbn){
//        if (books.remove(isbn)!=null)
//            return true;
//        else
//            return false;
//
    return books.remove(isbn) != null ? true : false;
    }

    public Optional<Book> findById(String isbn){
        return Optional.ofNullable(books.get(isbn));                    // używamy gdy wiemy że obiekt może byc nullem
    }

    public boolean update(Book book){
        final Optional<Book> bookOptional = findById(book.getIsbn());
        if(bookOptional.isPresent()){
            Book original = bookOptional.get();
            original.setTitle(book.getTitle());
            original.setAuthors(book.getAuthors());
            original.setPublisher(book.getPublisher());
            original.setFirstEdition(book.getFirstEdition());
            original.setPublishingYear(book.getPublishingYear());
            return true;
        }else return false;
    }
}
