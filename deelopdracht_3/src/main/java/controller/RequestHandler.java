package controller;

import db.PersonRepositoryStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    public PersonRepositoryStub persons;

    public PersonRepositoryStub getService(){
        return persons;
    }

    public void setPersons(PersonRepositoryStub persons){
        this.persons = persons;
    }

    public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException;

    public void setModel(PersonRepositoryStub persons){
        this.persons = persons;
    }
}
