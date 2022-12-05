package kamski.mac.book.library.book.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class BookDto {
    private Long id;

    @NotEmpty(message = "title should not be null or empty")
    private String title;

    private String shortDescription;
}
