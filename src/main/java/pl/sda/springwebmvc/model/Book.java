package pl.sda.springwebmvc.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;


@Data
@Builder
public class Book {
    @NotNull(message="Brak tytułu")
    @NotBlank(message = "Tytuł nie może byc pusty!")
    @Length(min = 1, message = "Minimalna długość tytułu to 1")
    private String title;

    @NotNull
    @NotBlank
    private String authors;

    @NotNull (message = "Musisz podać cene!!")
    @PositiveOrZero(message = "cena nie może być ujemna")
    private BigDecimal price;

    @ISBN
    private String isbn;

    @Range(min = 1600, max = 3000)
    private int publishingYear;

    @NotNull
    private String publisher;

    private Boolean firstEdition;

    public boolean isFirstEdition(){
        return firstEdition == null ? firstEdition = false : firstEdition;
    }
}
