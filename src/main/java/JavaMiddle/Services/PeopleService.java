package JavaMiddle.Services;

import JavaMiddle.Dto.RegPeople;
import JavaMiddle.Models.People;

import java.util.List;

public interface PeopleService {
    People get(long id);
    List<RegPeople> getAll();
    People addPeople(People people);
    People addNumber(long id, String number);
    People addEmail(long id, String email);
    List<String> getNumbers(long id);
    List<String> getEmails(long id);
}
