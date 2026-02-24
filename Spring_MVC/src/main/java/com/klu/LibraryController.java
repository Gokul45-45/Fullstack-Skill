package com.klu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.Book;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    // 2. Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 3. Count
    @GetMapping("/count")
    public int countBooks() {
        return 120;
    }

    // 4. Price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 5. Book titles
    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java", "Spring Boot", "Python", "Data Structures");
    }

    // 6. Book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 7. Search using request param
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Book searched with title: " + title;
    }

    // 8. Author path variable
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 9. Add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 10. View books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
