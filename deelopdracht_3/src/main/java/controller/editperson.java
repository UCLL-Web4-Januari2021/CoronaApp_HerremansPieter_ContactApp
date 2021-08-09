package controller;
import com.google.gson.Gson;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class editperson extends RequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException {

        InputStream in = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String data = br.readLine();

        Gson gson = new Gson();

        Person p = gson.fromJson(data, Person.class);

        try {
            persons.update(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
