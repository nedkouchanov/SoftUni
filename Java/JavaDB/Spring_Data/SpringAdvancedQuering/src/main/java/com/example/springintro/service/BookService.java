package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldBookTitlesWithCopiesLessThan5000();

    List<String> findAllBookTitlesWithPriceLessThan5OrMoreThan40();

    List<String> findAllBookTitlesNotReleasedInYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBookTitlesWhereTitleContainsStr(String containStr);

    List<String> findAllTitlesWithAuthorLastNameStartsWith(String lastNameStarts);

    int findAllBooksCountWithTitleLongerThan(int len);

    List<String> findBookWithReducedInformationByGivenTitle(String bookTitle);
}
