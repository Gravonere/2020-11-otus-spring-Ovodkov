package ru.otus.ovodkov.homework7.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.ovodkov.homework7.domain.Author;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ovodkov Sergey on 10.04.2020
 */
@DisplayName("Репозиторий авторов книг")
@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private TestEntityManager em;

    private static final long ID_AUTHOR = 1L;

    @DisplayName("возвращает указаного автора книги")
    @Test
    void shouldReturnExpectedAuthor(){
        Optional<Author> optionalActualAuthor = authorRepository.findByIdAuthor(ID_AUTHOR);
        Author expectedAuthor = em.find(Author.class, ID_AUTHOR);

        assertThat(optionalActualAuthor).isPresent().get()
                .isEqualToComparingFieldByField(expectedAuthor);
    }
}
