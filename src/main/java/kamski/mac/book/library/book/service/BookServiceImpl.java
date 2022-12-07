package kamski.mac.book.library.book.service;

import kamski.mac.book.library.book.entity.Book;
import kamski.mac.book.library.book.payload.BookDto;
import kamski.mac.book.library.book.payload.BookResponse;
import kamski.mac.book.library.book.repository.BookRepository;
import kamski.mac.book.library.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


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
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id.toString()));
        return mapToDto(book);
    }

    @Override
    public BookDto updateBook(BookDto dto, Long id) {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {

    }

    @Override
    public BookResponse getAllBooks(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortBy
                .equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> books = bookRepository.findAll(pageable);

        // get content for page object
        List<Book> listOfPosts = books.getContent();

        List<BookDto> content = listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        BookResponse bookResponse = new BookResponse();
        bookResponse.setContent(content);
        bookResponse.setPageNo(books.getNumber());
        bookResponse.setPageSize(books.getSize());
        bookResponse.setTotalElements(books.getTotalElements());
        bookResponse.setTotalPages(books.getTotalPages());
        bookResponse.setLast(books.isLast());
        return bookResponse;
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
