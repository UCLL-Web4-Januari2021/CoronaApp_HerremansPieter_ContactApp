package controller;

import domain.Person;
import db.PersonRepositoryStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogIn extends RequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException {
        List<String> errors = new ArrayList<String>();

        String email = request.getParameter("emaillogin");
        if (email == null || email.isEmpty()){
            errors.add("No password given");
        }

        String password = request.getParameter("passwordlogin");
        if (password == null || password.isEmpty()){
            errors.add("No password given");
        }

        if (errors.size() == 0){
            PersonRepositoryStub persons = super.getService();
            Person person = persons.getAuthenticatedUser(email, password);
            if (person != null){
                createSession(person, request, response);
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
