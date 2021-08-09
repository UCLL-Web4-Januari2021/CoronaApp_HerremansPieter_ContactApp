package domain;

import db.PersonRepository;
import db.PersonRepositoryStub;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository = new PersonRepositoryStub();

    public PersonService(){

    }

    public Person getPerson(String personId) throws IllegalAccessException {return getPersonRepository().get(personId);}

    public List<Person> getPersons(){return getPersonRepository().getAll();}

    public void addPerson(Person person) throws IllegalAccessException {getPersonRepository().add(person);}

    public void updatePerson(Person person){getPersonRepository().update(person);}

    public void deletePerson(String id){getPersonRepository().delete(id);}

    public Person getAuthenticatedUser(String email, String password) throws IllegalAccessException {
        return getPersonRepository().getAuthenticatedUser(email, password);
    }

    private PersonRepository getPersonRepository(){return personRepository;}
}
