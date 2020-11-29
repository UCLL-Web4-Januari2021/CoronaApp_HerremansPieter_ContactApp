package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddFriend extends RequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException {
        Person friend = null;
        //get current person
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        //search for person to add friend
        String email = request.getParameter("email");

        for (Person p: persons.getAll()) {
            if (p.getEmail().equals(email)){
                friend = p;
            }
        }

        if (friend == null){
            throw new IllegalArgumentException("no friend found with this name");
        }
        //add person to friend list
        person.addfriend(friend);

        //nadat er een friend wordt gead flipt de json binding, weet niet wrm dat dit gebeurt.
        request.getRequestDispatcher("friends.jsp").forward(request, response);
    }
}
