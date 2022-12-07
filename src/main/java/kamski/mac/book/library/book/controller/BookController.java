package kamski.mac.book.library.book.controller;

import kamski.mac.book.library.book.payload.BookResponse;
import kamski.mac.book.library.book.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public BookResponse getAllBooks() {
        return bookService.getAllBooks(0,10,"id","asc");
    }
}
