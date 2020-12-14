package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import domain.Person;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.writer.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class editperson extends RequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, ServletException, IOException {

        InputStream in = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String data = br.readLine();

        Gson gson = new Gson();

        Person p = gson.fromJson(data, Person.class);

        persons.delete(p.getFirstName());//remove first person from list
        try {
            persons.add(p);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
