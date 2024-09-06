package JavaMiddle.Services;

import JavaMiddle.Dto.RegPeople;
import JavaMiddle.Mapping.PeopleMap;
import JavaMiddle.Models.People;
import JavaMiddle.Repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

import static JavaMiddle.Mapping.PeopleMap.PeopleToRegPeople;
import static JavaMiddle.Mapping.PeopleMap.regPeopleToPeople;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    public PeopleRepository peopleRepository;
    @Override
    public People get(long id) {
        if(peopleRepository.findById(id).isPresent()){
            return peopleRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public List<RegPeople> getAll() {
        return peopleRepository.findAll().stream().map(PeopleMap::PeopleToRegPeople).toList();
    }

    @Override
    public People addPeople(People people) {
        if (people.getName().isEmpty()) {
            return null;
        }
        return peopleRepository.save(people);
    }

    @Override
    public People addNumber(long id, String number) {
        if (peopleRepository.findById(id).isEmpty() || number.isEmpty()){
            return null;
        }
        People people = peopleRepository.findById(id).get();
        people.getPhoneNumbers().add(number);
        return peopleRepository.save(people);
    }

    @Override
    public People addEmail(long id, String email) {
        if (peopleRepository.findById(id).isEmpty() || email.isEmpty()){
            return null;
        }
        People people = peopleRepository.findById(id).get();
        people.getEmails().add(email);
        return peopleRepository.save(people);
    }

    @Override
    public List<String> getNumbers(long id) {
        if(peopleRepository.findById(id).isPresent()){
            return peopleRepository.findById(id).get().getPhoneNumbers();
        }
        return null;
    }

    @Override
    public List<String> getEmails(long id) {
        if(peopleRepository.findById(id).isPresent()){
            return peopleRepository.findById(id).get().getEmails();
        }
        return null;
    }
}
