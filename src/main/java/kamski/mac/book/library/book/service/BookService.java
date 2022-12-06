package kamski.mac.book.library.book.service;

import kamski.mac.book.library.book.payload.BookDto;

public interface BookService {
    BookDto createBook(BookDto dto);
    BookDto getBookById(Long id);
    BookDto updateBook(BookDto dto, Long id);
    void deleteBookById(Long id);
}
