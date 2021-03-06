package ru.otus.ovodkov.homework4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework4.config.properties.LocaleProperty;
import ru.otus.ovodkov.homework4.domain.Student;

import java.util.Locale;
import java.util.Scanner;

/**
 * Получение данных студента посредством консоли.
 *
 * @author Sergey Ovodkov
 */
@Repository
public class StudentDaoConsole implements StudentDao {

    private final MessageSource messageSource;
    private final LocaleProperty localeProperty;

    public StudentDaoConsole(MessageSource messageSource,
                             LocaleProperty localeProperty) {
        this.messageSource = messageSource;
        this.localeProperty = localeProperty;
    }

    /**
     * @see StudentDao#getStudentPersonalData()
     */
    public Student getStudentPersonalData() {
        Locale useAppLocale = new Locale(localeProperty.getLanguage(), localeProperty.getCountry());
        Scanner in = new Scanner(System.in);
        System.out.print(messageSource.getMessage("student.firstName", null, useAppLocale));
        String firstName = in.nextLine();
        System.out.print(messageSource.getMessage("student.lastName", null, useAppLocale));
        String lastName = in.nextLine();
        return new Student(firstName, lastName);
    }
}