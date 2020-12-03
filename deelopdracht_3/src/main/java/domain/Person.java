package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;

public class Person {

    private String firstName;
    private String lastname;
    private String date;
    private String room;
    private String email;
    private String gsm;
    private String password;
    public boolean covid;
    @JsonIgnore
    public ArrayList<Person> friends;


    public Person(String email, String firstName, String lastname, String date, String room, String gsm, String password) {
        setDate(date);
        setEmail(email);
        setFirstName(firstName);
        setGsm(gsm);
        setLastname(lastname);
        setRoom(room);
        setPassword(password);
        friends = new ArrayList<>();
        covid = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void hascovid(){
        covid = true;
    }

    public boolean isCovid() {
        return covid;
    }

    public void setCovid(boolean covid) {
        this.covid = covid;
    }

    public boolean isCorrectPassword(String password){
        if(password.isEmpty()){
            throw new IllegalArgumentException("No password given");
        }
        return getPassword().equals(password);
    }

    public void addfriend(Person person){
        try{
            friends.add(person);
        }catch (Exception e){
            throw new IllegalArgumentException("cannot add person");
        }
    }

   public ArrayList<Person> getFriends() {
        return friends;
    }
}
