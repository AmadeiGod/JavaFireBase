package JavaMiddle.Controllers;


import JavaMiddle.Models.Book;
import JavaMiddle.Services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;


// Все endpoint`s
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/book")
public class RestController {
    @Autowired
    public BookServiceImpl bookService;
    // Получения книги по id
    @GetMapping("/{name}")
    public Book getBook(@PathVariable("name") String name) throws ExecutionException, InterruptedException {
        return bookService.get(name);
    }
    // Добавление книги
    @PostMapping("/add")
    public String addPeople( @RequestBody Book book) throws ExecutionException, InterruptedException {
        return bookService.save(book);
    }
    // Удаление книги по id
    @GetMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name) throws ExecutionException, InterruptedException {
        return bookService.delete(name);
    }
    // Список всех книг
    @GetMapping("/getAll")
    public List<Book> getAll() throws ExecutionException, InterruptedException {
        return bookService.getAll();
    }


}
