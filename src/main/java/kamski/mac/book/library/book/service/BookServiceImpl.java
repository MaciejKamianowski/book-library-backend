package kamski.mac.book.library.book.service;

import kamski.mac.book.library.book.entity.Book;
import kamski.mac.book.library.book.payload.BookDto;
import kamski.mac.book.library.book.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


@Service
public class BookServiceImpl implements BookService{

    private ModelMapper modelMapper;
    private BookRepository bookRepository;

    public BookServiceImpl(ModelMapper modelMapper, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(BookDto dto) {
        Book newBook = bookRepository.save(mapToEntity(dto));
        return mapToDto(newBook);
    }

    @Override
    public BookDto getBookById(Long id) {
        return null;
    }

    @Override
    public BookDto updateBook(BookDto dto, Long id) {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {

    }


    private BookDto mapToDto(Book book) {
        BookDto dto = modelMapper.map(book, BookDto.class);
        return dto;
    }

    private Book mapToEntity(BookDto dto) {
        Book book = modelMapper.map(dto, Book.class);
        return book;
    }
}
