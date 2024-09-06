package JavaMiddle.Controllers;

import JavaMiddle.Dto.RegPeople;
import JavaMiddle.Models.People;
import JavaMiddle.Services.PeopleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static JavaMiddle.Mapping.PeopleMap.regPeopleToPeople;

// Все endpoint`s
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/people")
public class RestController {
    @Autowired
    public PeopleServiceImpl peopleService;
    // Получения клиента по id
    @GetMapping("/{id}")
    public ResponseEntity<People> getPeople(@PathVariable("id") long id){
        return ResponseEntity.ok(peopleService.get(id));
    }
    // Добавление клиента
    @GetMapping("/add")
    public ResponseEntity<People> addPeople( @RequestBody RegPeople regPeople) {
        return ResponseEntity.ok(peopleService.addPeople(regPeopleToPeople(regPeople)));
    }
    // Добавление нового номера клиенту
    @RequestMapping(value = "{id}/addNumber/{number}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<People> addNumber(@PathVariable("id") long id, @PathVariable("number") String number){
        return ResponseEntity.ok(peopleService.addNumber(id, number));
    }
    // Добавление нового email клиенту
    @RequestMapping(value = "{id}/addEmail/{number}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<People> addEmail(@PathVariable("id") long id, @PathVariable("email") String email){
        return ResponseEntity.ok(peopleService.addNumber(id, email));
    }
    // Список всех клиентов
    @GetMapping("/getAll")
    public ResponseEntity<List<RegPeople>> getAll(){
        return ResponseEntity.ok(peopleService.getAll());
    }
    // Список всех номеров клиента по id
    @GetMapping("{id}/getNumbers")
    public ResponseEntity<List<String>> getNumbers(@PathVariable("id") long id){
        return ResponseEntity.ok(peopleService.getNumbers(id));
    }
    // Список всех email`s клиента по id
    @GetMapping("{id}/getEmails")
    public ResponseEntity<List<String>> getEmails(@PathVariable("id") long id){
        return ResponseEntity.ok(peopleService.getEmails(id));
    }

}
