package JavaMiddle.Mapping;

import JavaMiddle.Dto.RegPeople;
import JavaMiddle.Models.People;
import lombok.*;


public class PeopleMap {
    public static People regPeopleToPeople(RegPeople regPeople){
        People people = new People();
        people.setName(regPeople.name);
        return  people;
    }
    public static RegPeople PeopleToRegPeople(People people){
        RegPeople regpeople = new RegPeople();
        regpeople.setName(people.getName());
        return  regpeople;
    }
}
