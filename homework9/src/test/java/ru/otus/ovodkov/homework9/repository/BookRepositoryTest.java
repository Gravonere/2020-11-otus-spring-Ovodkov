package ru.otus.ovodkov.homework9.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.ovodkov.homework9.model.Book;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ovodkov Sergey
 * created on 26.04.2020
 */
@DisplayName("Репозиторий книг")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager em;

    private static final long ID_BOOK = 1L;

    @DisplayName("возвращает книгу по указанному идентификатору")
    @Test
    void shouldReturnExpectedBook() {
        Optional<Book> optionalActualBook = bookRepository.findByIdBook(ID_BOOK);
        Book expectedBook = em.find(Book.class, ID_BOOK);

        assertThat(optionalActualBook).isPresent().get()
                .isEqualToComparingFieldByField(expectedBook);
    }
}
