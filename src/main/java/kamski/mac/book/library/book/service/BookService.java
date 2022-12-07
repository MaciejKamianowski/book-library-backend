package kamski.mac.book.library.book.service;

import kamski.mac.book.library.book.payload.BookDto;
import kamski.mac.book.library.book.payload.BookResponse;

public interface BookService {
    BookDto createBook(BookDto dto);
    BookDto getBookById(Long id);
    BookDto updateBook(BookDto dto, Long id);
    void deleteBookById(Long id);

    BookResponse getAllBooks(Integer pageNo, Integer pageSize, String sortBy, String sortDir);
}
