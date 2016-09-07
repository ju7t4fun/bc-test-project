package name.just4fun.bct.persistence.repository;

import name.just4fun.bct.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Yura Kovalik
 * @since by 9/7/2016.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitleOrAuthor(String title, String author);
}
