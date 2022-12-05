package kamski.mac.book.library.book.repository;

import kamski.mac.book.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByShortDescriptionContaining(String shortDescription);
}
