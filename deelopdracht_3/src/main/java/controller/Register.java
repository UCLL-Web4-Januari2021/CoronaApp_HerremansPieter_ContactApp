package controller;

import db.PersonRepositoryStub;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Register extends RequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException {
        //do both addperson and login that person on then redirect the page

        //first add person
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String GSM = request.getParameter("GSM");
        String date = request.getParameter("date");
        String room = request.getParameter("room");
        String password = request.getParameter("password");
        Person person = new Person(email, fname, lname, date, room, GSM, password);
        try {
            persons.add(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //then login

        List<String> errors = new ArrayList<String>();

        String emaillogin = request.getParameter("email");
        if (emaillogin == null || emaillogin.isEmpty()){
            errors.add("No password given");
        }

        String passwordlogin = request.getParameter("password");
        if (passwordlogin == null || passwordlogin.isEmpty()){
            errors.add("No password given");
        }

        if (errors.size() == 0){
            PersonRepositoryStub persons = super.getService();
            Person person2 = persons.getAuthenticatedUser(emaillogin, passwordlogin);
            if (person2 != null){
                createSession(person2, request, response);
            } else {
                errors.add("No valid email/password");
            }
        }

        if (errors.size() > 0){
            request.setAttribute("errors", errors);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void createSession(Person person, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("user", person);
    }
}
