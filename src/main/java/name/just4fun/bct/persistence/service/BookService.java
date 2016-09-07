package name.just4fun.bct.persistence.service;

import name.just4fun.bct.persistence.model.Book;
import name.just4fun.bct.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> find(String title, String author){
        return repository.findByTitleAndAuthor(title,author);
    }

    public List<Book> find(String token){
        return repository.findByTitleOrAuthor(token, token);
    }
    public void save(Book book){
        repository.save(book);
    }
    public void remove(Book book){
        repository.delete(book);
    }
}
