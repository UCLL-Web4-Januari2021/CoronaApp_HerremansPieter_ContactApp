package db;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import java.util.ArrayList;

public class PersonRepositoryStub implements PersonRepository {

    ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Person> persons = new ArrayList<Person>();

    public PersonRepositoryStub () {
        Person test = new Person("test1@ucll.be", "test", "testl", "1970/07/08", "E104", "0497327862", "t");
        test.hascovid();
        Person test2 = new Person("test2@ucll.be", "test2", "testl2", "1970/07/08", "E102", "0497357892", "t");
        Person test3 = new Person("test3@ucll.be", "test3", "testl3", "1971/07/08", "E103", "0497327892", "t");
        Person test4 = new Person("test4@ucll.be", "test4", "testl4", "1972/07/08", "E102", "0497325892", "t");
        Person test5 = new Person("test5@ucll.be", "test5", "testl5", "1973/07/08", "E103", "0497327892", "t");
        Person t = new Person("t","t","t","t","t", "t", "t");
        persons.add(test);
        persons.add(test2);
        persons.add(test3);
        persons.add(test4);
        persons.add(test5);
        persons.add(t);
    }
    @Override
    public void add(Person person) throws IllegalAccessException {
        for (Person p: persons) {
                if(p == person){
                    throw new IllegalAccessException("person already exists.");
            }
        }
        persons.add(person);
    }

    @Override
    public void delete(String fname) {
        persons.removeIf(p -> p.getFirstName().equals(fname));
    }

    @Override
    public Person get(String email) throws IllegalAccessException {
        for (Person p: persons) {
            if(p.getEmail().equals(email)){
                return p;
            }
        }
        throw new IllegalAccessException("No person found.");
    }

    public Person getfname(String fname) throws IllegalAccessException {
        for (Person p: persons) {
            if(p.getFirstName().equals(fname)){
                return p;
            }
        }
        throw new IllegalAccessException("No person found.");
    }

    @Override
    public ArrayList<Person> getAll() {
        //sorting not perfect, crashes sometimes
        /*this.persons.sort(new Comparator<Person>()
            @Override
            public int compare(Person lhs, Person rhs) {
                return lhs.getFirstName().compareTo(rhs.getFirstName());
            }
        });*/
        return persons;
    }

    public ArrayList<Person> search(String Date, String Room) throws IllegalAccessException {
        ArrayList<Person> ret = new ArrayList<Person>();

        for (Person p : persons) {
            if (p.getDate().equals(Date) && p.getRoom().equals(Room)) {
                ret.add(p);
            }
        }
        if (ret.isEmpty()) {
            throw new IllegalAccessException("No matches found.");
        } else {
            return ret;
        }
    }

    public ArrayList<Person> searchdate(String Date) throws IllegalAccessException {
        ArrayList<Person> ret = new ArrayList<Person>();

        for (Person p: persons) {
            if (p.getDate().equals(Date)){
                ret.add(p);
            }
        }
        if(ret.isEmpty()){
            throw new IllegalArgumentException("no matches found.");
        }else{
            return ret;
        }
    }

    @Override
    public Person getAuthenticatedUser(String email, String password) throws IllegalAccessException {
        Person person = get(email);

        if (person != null && person.isCorrectPassword(password)) {
            return person;
        }
        else{
            return null;
        }
    }

    @Override
    public void update(Person person) {
        try {
            Person p = getfname(person.getFirstName());
            p.setLastname(person.getLastname());
            p.setDate(person.getDate());
            p.setRoom(person.getRoom());
            p.setEmail(person.getEmail());
            p.setGsm(person.getGsm());
            p.setPassword(person.getPassword());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

