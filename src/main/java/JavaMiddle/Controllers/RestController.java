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
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        return bookService.get(id);
    }
    // Добавление книги
    @PostMapping("/add")
    public String addPeople( @RequestBody Book book) throws ExecutionException, InterruptedException {
        return bookService.save(book);
    }
    // Удаление книги по id
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        return bookService.delete(id);
    }
    // Список всех книг
    @GetMapping("/getAll")
    public List<Book> getAll() throws ExecutionException, InterruptedException {
        return bookService.getAll();
    }


}
