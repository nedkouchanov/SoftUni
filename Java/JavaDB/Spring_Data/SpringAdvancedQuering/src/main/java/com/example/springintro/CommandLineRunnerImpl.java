package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

/*
printAllBooksAfterYear(2000);
printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
printAllAuthorsAndNumberOfTheirBooks();
printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
*/

        System.out.println("Select exNum:");
        int exNum = Integer.parseInt(bufferedReader.readLine());
        switch (exNum) {
            case 1 -> booksTitlesByAgeRestriction();
            case 2 -> goldenBook();
            case 3 -> booksByPrice();
            case 4 -> notReleasedBooks();
            case 5 -> booksReleasedBefore();
            case 6 -> authorsSearch();
            case 7 -> booksSearch();
            case 8 -> booksTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
            case 11 -> reducedBook();
        }
    }

    private void reducedBook() throws IOException {
        System.out.println("Enter Book Title: ");
        String bookTitle = bufferedReader.readLine();

        bookService
                .findBookWithReducedInformationByGivenTitle(bookTitle)
                .forEach(System.out::println);
    }

    private void totalBookCopies() {
        authorService
                .findAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Enter Title length: ");
        int len = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.findAllBooksCountWithTitleLongerThan(len));
    }

    private void booksTitlesSearch() throws IOException {
        System.out.println("Enter author last name starts with..: ");
        String lastNameStarts = bufferedReader.readLine();

        bookService
                .findAllTitlesWithAuthorLastNameStartsWith(lastNameStarts)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Enter containing string..: ");
        String containStr = bufferedReader.readLine();

        bookService
                .findAllBookTitlesWhereTitleContainsStr(containStr)
                .forEach(System.out::println);

    }

    private void authorsSearch() throws IOException {
        System.out.println("Enter first name ends with..: ");
        String endStr = bufferedReader.readLine();

        authorService
                .findAuthorFirstNameEndsWithStr(endStr)
                .forEach(System.out::println);
    }

    private void booksReleasedBefore() throws IOException {
        System.out.println("Enter date in FORMAT (dd-MM-yyyy): ");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService
                .findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);

    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Enter year: ");
        int year = Integer.parseInt(bufferedReader.readLine());
        bookService
                .findAllBookTitlesNotReleasedInYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findAllBookTitlesWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void goldenBook() {
        bookService
                .findAllGoldBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("Enter Age Restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        bookService
                .findAllBooksTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
